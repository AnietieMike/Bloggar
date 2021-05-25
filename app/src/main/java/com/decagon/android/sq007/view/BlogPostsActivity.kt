package com.decagon.android.sq007.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.decagon.android.sq007.R
import com.decagon.android.sq007.apis.PostService
import com.decagon.android.sq007.cache.PostDao
import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.util.DataState
import com.decagon.android.sq007.view.adapter.BlogPostsAdapter
import com.decagon.android.sq007.view.viewmodels.BlogPostsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_blog_posts.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BlogPostsActivity : AppCompatActivity() {

    private val posts = ArrayList<Post>()
//    val postDao : PostDao
//    val postService: PostService
//    val repository: MainRepository = MainRepository()
    val blogPostViewModel: BlogPostsViewModel by viewModel()
//    private val blogPostsViewModel: BlogPostsViewModel by viewModel()
    private lateinit var postsAdapter: BlogPostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_posts)

        subscribeObservers()

        val recyclerView = recyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        postsAdapter = BlogPostsAdapter(posts)
        recyclerView.adapter = postsAdapter
    }

    private fun subscribeObservers() {
        blogPostViewModel.dataState.observe(this, Observer { dataState ->
            when(dataState) {
                is DataState.Success<List<Post>> -> {
                    showProgressBar(false)
                    dataState.data
                }
                is DataState.Error -> {
                    showProgressBar(false)
                    showError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    showProgressBar(true)
                }
            }
        })
    }

    private fun showError(msg: String?) {
        if (msg != null) {
            text.text = msg
        }
        text.text = getString(R.string.error_text)
    }

    private fun showProgressBar(isDisplayed: Boolean) {
        progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}