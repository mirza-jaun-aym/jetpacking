package com.example.livedata.list.ui.listother

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.common.BaseFragment
import com.example.livedata.list.ListAdapter
import com.example.livedata.list.ListViewModel
import kotlinx.android.synthetic.main.list_other_fragment.*
import javax.inject.Inject

class ListOtherFragment : BaseFragment() {

    @Inject
    lateinit var listAdapter : ListAdapter

    @Inject
    lateinit var viewModelFactory: ListViewModel.ListViewModelFactory
    val listViewModel: ListViewModel by lazy {
        ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)
    }

    companion object {
        fun newInstance() = ListOtherFragment()
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


    private fun beginSearch() {
        listViewModel.beginSearchViewModel().observe(viewLifecycleOwner, Observer {
            Log.d("yes", it.toList().get(0).toString())
            listAdapter.updateUsers(it.toList())
        })
    }

}
