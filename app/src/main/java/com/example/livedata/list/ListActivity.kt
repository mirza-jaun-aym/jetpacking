package com.example.livedata.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
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

    private val listUser : ArrayList<User> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        listUser.add(User("Ahmed"))
        listUser.add(User("jamal"))
        listAdapter  = ListAdapter(listUser)
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.adapter = listAdapter
        beginSearch()

    }

    private fun beginSearch() {
        AppClient.create().hitCountCheck("1").enqueue(object : Callback<Post>{
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("response","failure")
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                response.body()?.title
                Log.d("response",response.body()?.title.toString())
            }

        })
    }

}
