package com.example.livedata.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.model.Model
import com.example.livedata.network.WikiApiService
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var listAdapter : ListAdapter

    private val listUser : ArrayList<User> = ArrayList()

    private var disposable: Disposable? = null

    private val wikiApiServe by lazy {
        WikiApiService.create()
    }

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
        wikiApiServe.hitCountCheck("1").enqueue(object : Callback<Model>{
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.d("response","failure")
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
//                response.body()?.title
                Log.d("response",response.body()?.title.toString())
            }

        })
    }

}
