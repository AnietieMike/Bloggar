package com.decagon.android.sq007.util

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.decagon.android.sq007.BaseApplication
import kotlinx.android.synthetic.main.activity_blog_posts.*

object Utils {

    fun showProgressBar(progressBar: ProgressBar, isDisplayed: Boolean) {
        progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}