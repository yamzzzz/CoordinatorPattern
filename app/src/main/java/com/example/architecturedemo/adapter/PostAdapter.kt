package com.example.architecturedemo.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.example.architecturedemo.databinding.PostItemBinding
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.ui.basic.post.PostFragmentDirections

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


/*
class PostAdapter (val context: Context, var data : List<Post>?) : RecyclerView.Adapter<PostAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItems(data?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return Holder(v)
    }

    override fun getItemCount(): Int = data?.size?:0

    fun addItems(t: List<Post>?) {
        data = t
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(user: Post?){
            */
/*itemView.title.text =  user?.title
            itemView.description.text = user?.body

            itemView.setOnClickListener {
                val direction = HomeFragmentDirections.openDetails(user!!.id)
                findNavController(itemView).navigate(direction)
            }*//*

        }
    }

}*/
