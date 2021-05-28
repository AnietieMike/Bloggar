package com.decagon.android.sq007.views.posts_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Post
import com.decagon.android.sq007.util.DataState
import com.decagon.android.sq007.util.Utils
import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import kotlinx.android.synthetic.main.activity_blog_posts.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlogPostsActivity : AppCompatActivity() {

    private val posts = ArrayList<Post>()
    private val blogPostViewModel: BlogPostsViewModel by viewModel()
    private lateinit var postsAdapter: BlogPostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_posts)

        subscribeObservers()

        val recyclerView = postsRecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        postsAdapter = BlogPostsAdapter(this, posts)
        recyclerView.adapter = postsAdapter

        // Add New Post
        fabAddPost.setOnClickListener {
            AddPostDialogFragment().show(supportFragmentManager, "ADD POST")
        }

        // SearchPosts
        postSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { blogPostViewModel.searchPosts(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { blogPostViewModel.searchPosts(it) }
                return false
            }
        })
    }

    private fun subscribeObservers() {
        blogPostViewModel.dataState.observe(this, { result ->
            when(result.status) {
                DataState.Status.SUCCESS -> {
                    Utils.showProgressBar(progressBar, false)
                    result.data?.let { list ->
                        postsAdapter.updateData(list)
                    }
                }
                DataState.Status.ERROR -> {
                    Utils.showProgressBar(progressBar, false)
                    result.message?.let {
                        showError(it)
                    }
                }
                DataState.Status.LOADING -> {
                    Utils.showProgressBar(progressBar, true)
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

}