package com.example.architecturedemo.ui.users.user

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturedemo.R
import com.example.architecturedemo.adapter.PostAdapter
import com.example.architecturedemo.adapter.UserAdapter
import com.example.architecturedemo.databinding.PostFragmentBinding
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.model.User
import com.example.architecturedemo.ui.base.BaseFragment
import com.example.architecturedemo.ui.posts.post.PostFragment
import com.example.architecturedemo.ui.posts.post.UserViewAction


/* 
 * Created by Yamini on 16/5/18.
 */

class UserFragment : BaseFragment<UserViewAction, UserViewModel>() {
    override val layoutResourceId = R.layout.post_fragment

    companion object {
        fun newInstance() = PostFragment()
    }

    private lateinit var mBinding: PostFragmentBinding
    override val viewModel: UserViewModel by viewModels()
    lateinit var userAdapter: UserAdapter
    var data: List<User> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = PostFragmentBinding.bind(view)

        context?.let {
            mBinding.userList.apply {
                layoutManager = LinearLayoutManager(it)
                userAdapter = UserAdapter(it, data)
                adapter = userAdapter
                userAdapter.onItemClickListener = {
                    Log.v("Yamiii", ""+it.name)
                  //  postAction(UserViewAction.OpenPostDetail(it.id))
                }
            }
        }


        viewModel.fetchAllData().observe(
            viewLifecycleOwner
        ) { t ->
            userAdapter.addItems(t)
        }

    }

}
