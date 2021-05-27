package com.decagon.android.sq007.views.post_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.decagon.android.sq007.R
import com.decagon.android.sq007.model.Comment
import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import com.decagon.android.sq007.viewmodels.PostDetailViewModel
import kotlinx.android.synthetic.main.fragment_add_comment_dialog.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddCommentDialogFragment(private val postId: Int) : DialogFragment() {

    private val addCommentViewModel by viewModel<PostDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comment_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonComment.setOnClickListener {
            val name = commenterName.text.toString()
            val email = emailAddress.text.toString()
            val body = newComment.text.toString()
            val id = 0

            if (name.isEmpty() || email.isEmpty() || body.isEmpty()){
                commenterName.error = "Name Can't Be Empty"
                emailAddress.error = "Email Can't Be Empty"
                newComment.error = "Comment Can't Be Empty"
                Toast.makeText(requireContext(), "All Fields Must Be Filled", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val newComment = Comment(postId, id, name, email, body)
                addCommentViewModel.insertComment(newComment, postId)
                addCommentViewModel.fetchComments(postId)
                Log.d("NEWCOM", "onActivityCreated: $newComment")
                dismiss()
            }
        }
    }

}