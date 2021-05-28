package com.decagon.android.sq007.views.post_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Comment
import com.decagon.android.sq007.model.domain.Post
import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import com.decagon.android.sq007.viewmodels.PostDetailViewModel
import com.decagon.android.sq007.views.posts_list.BlogPostsAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_post_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailActivity : AppCompatActivity() {

    private val comments = ArrayList<Comment>()
    private val viewModel: PostDetailViewModel by viewModel()
    private lateinit var postsAdapter: BlogPostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        intent?.getIntExtra(POST_ID, 0)?.let { id ->
            val postId = id
        } ?: showError("Unknown Post")

        val postTitle = intent.getStringExtra("Post Title")
        tvPostTitle.text = postTitle
    }

    private fun showError(msg: String) {
        Snackbar.make(parentView, msg, Snackbar.LENGTH_INDEFINITE).setAction("DISMISS") {
        }.show()
    }

    companion object {
        const val POST_ID = "postId"
    }
}