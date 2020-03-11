package com.example.livedata.list.ui.listother

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.auth.AuthActivity
import com.example.livedata.common.BaseFragment
import com.example.livedata.list.ListAdapter
import com.example.livedata.list.ListViewModel
import kotlinx.android.synthetic.main.list_other_fragment.*
import javax.inject.Inject

class ListFragment : BaseFragment() {

    @Inject
    lateinit var listAdapter: ListAdapter

    @Inject
    lateinit var viewModelFactory: ListViewModel.ListViewModelFactory
    val listViewModel: ListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
    }

    companion object {
        fun newInstance() = ListFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_other_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel

        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = listAdapter
        beginSearch()
    }

    fun userLogOut() {
        listViewModel.clearPref().observe(viewLifecycleOwner, Observer {
            val i = Intent(context, AuthActivity::class.java)
            // set the new task and clear flags
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        })
    }


    private fun beginSearch() {
        listViewModel.beginSearchViewModel().observe(viewLifecycleOwner, Observer {
            Log.d("yes", it.toList().get(0).toString())
            listAdapter.updateUsers(it.toList())
        })
    }

}
