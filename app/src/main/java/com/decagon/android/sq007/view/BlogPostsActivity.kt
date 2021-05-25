package com.decagon.android.sq007.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.android.sq007.R
import com.decagon.android.sq007.view.viewmodels.BlogPostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlogPostsActivity : AppCompatActivity() {

    private val blogPostsViewModel: BlogPostsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_posts)
    }
}