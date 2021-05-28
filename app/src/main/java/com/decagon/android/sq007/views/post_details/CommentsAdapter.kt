package com.decagon.android.sq007.views.post_details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Comment
import kotlinx.android.synthetic.main.item_list_comments.view.*
import kotlinx.android.synthetic.main.item_list_post.view.*
import kotlinx.android.synthetic.main.item_list_post.view.userName
import java.util.*

class CommentsAdapter(private val context: Context, private val list: ArrayList<Comment>) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {
    class CommentViewHolder (view: View, private val context: Context) : RecyclerView.ViewHolder(view) {

        fun bind(comment: Comment) {
            itemView.userName.text = comment.name.capitalize(Locale.ROOT)
            itemView.userEmail.text = comment.email
            itemView.commentBody.text = comment.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_comments, parent, false)
        return CommentViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}