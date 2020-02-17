package com.example.livedata.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.app.MyApp
import com.example.livedata.model.Post
import com.example.livedata.network.AppClient
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var listAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        (application as MyApp).appComponent.inject(this);
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.adapter = listAdapter
        beginSearch()

    }

    private fun beginSearch() {
        AppClient.create().hitCountCheck().enqueue(object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("response","failure")
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                listAdapter.updateUsers(response.body() ?: ArrayList())
            }

        })
    }

}
