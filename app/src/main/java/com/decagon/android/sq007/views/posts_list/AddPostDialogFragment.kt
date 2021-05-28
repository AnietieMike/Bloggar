package com.decagon.android.sq007.views.posts_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Post
import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import kotlinx.android.synthetic.main.fragment_add_post_dialog.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPostDialogFragment : DialogFragment() {

    private val addPostViewModel by viewModel<BlogPostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonPost.setOnClickListener {
            val postTitle = newPostTitle.text.toString()
            val postBody = newPostBody.text.toString()
            val userId = 10

            if (postTitle.isEmpty() || postBody.isEmpty()) {
                newPostTitle.error = "This field can't be empty"
                newPostBody.error = "This field can't be empty"
            }
            else {
                val newPost = Post(userId, id, postTitle, postBody)
                addPostViewModel.insertPost(newPost)
                addPostViewModel.fetchPosts()
            }
        }
    }
}