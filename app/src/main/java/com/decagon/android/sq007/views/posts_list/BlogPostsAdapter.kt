package com.decagon.android.sq007.views.posts_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.domain.Post
import com.decagon.android.sq007.views.post_details.PostDetailActivity
import kotlinx.android.synthetic.main.item_list_post.view.*
import java.util.*

class BlogPostsAdapter(private val context: Context, private val list: ArrayList<Post>) : RecyclerView.Adapter<BlogPostsAdapter.PostViewHolder>() {

    class PostViewHolder (view: View, private val context: Context) : RecyclerView.ViewHolder(view) {

        fun bind(post: Post) {
            itemView.setOnClickListener {
                val intent = Intent(context, PostDetailActivity::class.java)
                context.startActivity(intent)
            }
//            itemView.userUsername.text = "@${post.username}"
            itemView.userName.text = post.postId.toString()
            itemView.postTitle.text = post.title.capitalize(Locale.ROOT)
//            itemView.postBody.text = post.body.capitalize()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_post, parent, false)
        return PostViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Post>) {
        list.clear()
        val sortedList = newList.sortedBy { post -> post.postId }
        list.addAll(sortedList)
        notifyDataSetChanged()
    }
}