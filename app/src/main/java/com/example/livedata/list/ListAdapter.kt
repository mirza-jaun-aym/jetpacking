package com.example.livedata.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedata.R
import kotlinx.android.synthetic.main.item_user.view.*

class ListAdapter(var users: ArrayList<User>) :
    RecyclerView.Adapter<ListAdapter.UserViewHolder>() {
    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )
    override fun getItemCount() = users.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userName = view.userName
        fun bind(country: User) {
            userName.text = country.firstName
        }
    }
}