package com.example.architecturedemo.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.architecturedemo.databinding.PostItemBinding
import com.example.architecturedemo.model.Post

/* 
 * Created by Yamini on 14/5/18.
 */

class PostAdapter(val context: Context, var posts: List<Post>?) :
    RecyclerView.Adapter<PostAdapter.Holder>() {
    var onItemClickListener: ((Post) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = posts?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItems(posts?.get(position))
        holder.itemView.setOnClickListener {
            val post = posts?.get(position)
            post?.let {
                onItemClickListener?.invoke(it)
            }

        }
    }

    fun addItems(t: List<Post>?) {
        posts = t
        notifyDataSetChanged()
    }

    class Holder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(post: Post?) {
            binding.title.text = post?.title
            binding.description.text = post?.body
        }
    }
}
