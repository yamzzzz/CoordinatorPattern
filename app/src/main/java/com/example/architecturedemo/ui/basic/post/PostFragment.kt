package com.example.architecturedemo.ui.basic.post

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturedemo.R
import com.example.architecturedemo.adapter.PostAdapter
import com.example.architecturedemo.databinding.PostFragmentBinding
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.ui.base.BaseFragment


/* 
 * Created by Yamini on 16/5/18.
 */

class PostFragment : BaseFragment<PostViewAction, PostViewModel>() {
    override val layoutResourceId = R.layout.post_fragment

    companion object {
        fun newInstance() = PostFragment()
    }

    private lateinit var mBinding: PostFragmentBinding
    override val viewModel: PostViewModel by viewModels()
    lateinit var postAdapter: PostAdapter
    var data: List<Post> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = PostFragmentBinding.bind(view)

        context?.let {
            mBinding.userList.apply {
                layoutManager = LinearLayoutManager(it)
                postAdapter = PostAdapter(it, data)
                adapter = postAdapter
                postAdapter.onItemClickListener = {
                    Log.v("Yamiii", ""+it.id)
                    postAction(PostViewAction.OpenPostDetail(it.id))
                    //postClickAction(PostViewAction.OpenPostDetail(it.id))
                }
            }
        }


        viewModel.fetchAllData().observe(
            viewLifecycleOwner
        ) { t ->
            postAdapter.addItems(t)
        }

    }

}
