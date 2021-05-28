package com.decagon.android.sq007.views.post_details

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.Comment
import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.views.posts_list.BlogPostsAdapter
import kotlinx.android.synthetic.main.include_user_info.view.*
import kotlinx.android.synthetic.main.item_list_post.view.*
import java.util.*

class CommentsAdapter(private val context: Context, private val list: ArrayList<Comment>) : RecyclerView.Adapter<CommentsAdapter.PostViewHolder>() {
    class PostViewHolder (view: View, private val context: Context) : RecyclerView.ViewHolder(view) {

        fun bind(comment: Comment) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_comments, parent, false)
        return PostViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}