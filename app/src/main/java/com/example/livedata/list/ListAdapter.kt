package com.example.livedata.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedata.R
import com.example.livedata.model.Post
import kotlinx.android.synthetic.main.item_user.view.*
import javax.inject.Inject

class ListAdapter @Inject constructor():
    RecyclerView.Adapter<ListAdapter.UserViewHolder>() {

    private val users = ArrayList<Post>()
    fun updateUsers(newUsers: List<Post>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )
    override fun getItemCount() = users.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users.get(position))
    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userName = view.userName
        fun bind(country: Post) {
            userName.text = country.title
        }
    }
}