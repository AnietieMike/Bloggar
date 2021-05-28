package com.decagon.android.sq007.views.posts_list

import androidx.fragment.app.DialogFragment
import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPostDialogFragment : DialogFragment() {

    private val addPostViewModel by viewModel<BlogPostsViewModel>()
}