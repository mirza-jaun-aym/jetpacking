package com.example.livedata.list

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.livedata.R
import com.example.livedata.common.BaseActivity
import com.example.livedata.list.ui.listother.ListFragment
import com.example.livedata.model.Post
import com.example.livedata.network.AppClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListActivity : BaseActivity() {

    @Inject
    lateinit var listAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commitNow()
        }

      /*  (application as MyApp).appComponent.inject(this);
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.adapter = listAdapter
        beginSearch()*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Inflate the menu, this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var fragment = supportFragmentManager.findFragmentById(R.id.container) as ListFragment
        fragment.userLogOut()
        return super.onOptionsItemSelected(item)
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
