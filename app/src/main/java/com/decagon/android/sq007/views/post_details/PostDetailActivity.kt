package com.decagon.android.sq007.views.post_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Comment
import com.decagon.android.sq007.util.DataState
import com.decagon.android.sq007.util.Utils
import com.decagon.android.sq007.viewmodels.PostDetailViewModel
import com.decagon.android.sq007.views.posts_list.AddPostDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_blog_posts.*
import kotlinx.android.synthetic.main.activity_post_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailActivity : AppCompatActivity() {

    private var comments = listOf<Comment>()
    private val viewModel: PostDetailViewModel by viewModel()
    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val postId = intent.getIntExtra(POST_ID, 0)
//        .let { id ->
//            viewModel.getPostComments(id)
//        } ?: showError("Unknown Post")

        val title = intent.getStringExtra("Post Title")
        val body = intent.getStringExtra("Post Body")
        tvPostTitle.text = title
        tvPostBody.text = body

        val recyclerView = commentsRecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        viewModel.getPostComments(postId)
        viewModel.commentData.observe(this, Observer { dataState ->

            when(dataState.status) {
                DataState.Status.SUCCESS -> {
                    Utils.showProgressBar(commentsProgressBar, false)
                    dataState.data?.let { list ->
                        commentsAdapter = CommentsAdapter(this, list)
                        recyclerView.adapter = commentsAdapter
                    }
                }
                DataState.Status.ERROR -> {
                    Utils.showProgressBar(commentsProgressBar, false)
                    dataState.message?.let {
                        showError(it)
                    }
                }
                DataState.Status.LOADING -> {
                    Utils.showProgressBar(commentsProgressBar, true)
                }
            }
        })

        fabAddComment.setOnClickListener {
            AddCommentDialogFragment(postId).show(supportFragmentManager, "ADD COMMENT")
        }

//        subscribeObservers()
    }

//    private fun subscribeObservers() {
//        viewModel.commentData.observe(this, Observer { dataState ->
//            when(dataState.status) {
//                DataState.Status.SUCCESS -> {
//                    Utils.showProgressBar(progressBar, false)
//                    dataState.data?.let { list ->
//                        commentsAdapter(this, list)
//                    }
//                }
//                DataState.Status.ERROR -> {
//                    Utils.showProgressBar(commentsProgressBar, false)
//                    dataState.message?.let {
//                        showError(it)
//                    }
//                }
//                DataState.Status.LOADING -> {
//                    Utils.showProgressBar(commentsProgressBar, true)
//                }
//            }
//        })
//    }

    private fun showError(msg: String) {
        Snackbar.make(parentView, msg, Snackbar.LENGTH_INDEFINITE).setAction("DISMISS") {
        }.show()
    }

    companion object {
        const val POST_ID = "postId"
    }
}