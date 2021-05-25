package com.decagon.android.sq007.remote

import com.google.gson.annotations.SerializedName

class CommentRemoteEntity(

    @SerializedName("postId")
    var postId: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("body")
    var body: String
)