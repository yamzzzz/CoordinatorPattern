package com.example.architecturedemo.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.architecturedemo.databinding.PostItemBinding
import com.example.architecturedemo.databinding.UserItemBinding
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.model.User

/* 
 * Created by Yamini on 14/5/18.
 */

class UserAdapter(val context: Context, var users: List<User>?) :
    RecyclerView.Adapter<UserAdapter.Holder>() {
    var onItemClickListener: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = users?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItems(users?.get(position))
        holder.itemView.setOnClickListener {
            val post = users?.get(position)
            post?.let {
                onItemClickListener?.invoke(it)
            }

        }
    }

    fun addItems(t: List<User>?) {
        users = t
        notifyDataSetChanged()
    }

    class Holder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(user: User?) {
            binding.name.text = user?.name
            binding.email.text = user?.email
            binding.phone.text = user?.phone
        }
    }
}
