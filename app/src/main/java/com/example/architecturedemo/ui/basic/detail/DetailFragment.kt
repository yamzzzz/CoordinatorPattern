package com.example.architecturedemo.ui.basic.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecturedemo.R
import com.example.architecturedemo.databinding.DetailPageBinding
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.ui.base.BaseFragment
import com.example.architecturedemo.ui.base.BaseViewModel

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailFragment : BaseFragment<DetailViewAction, DetailViewModel>() {
    private lateinit var mBinding: DetailPageBinding
    private var mId = 0
    private val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = DetailViewModel() as T
    }

    private val mViewModel: DetailViewModel by viewModels { factory }
    lateinit var post: Post
    override val layoutResourceId: Int
        get() = R.layout.detail_page
    override val viewModel: DetailViewModel
        get() = mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DetailPageBinding.bind(view)
        arguments?.let {
            mId = DetailFragmentArgs.fromBundle(it).id
        }

        viewModel.fetchPostById(mId).observe(
            viewLifecycleOwner
        ) { t ->
            mBinding.postTitle.text = t?.title
            mBinding.description.text = t?.body
        }
    }

}
