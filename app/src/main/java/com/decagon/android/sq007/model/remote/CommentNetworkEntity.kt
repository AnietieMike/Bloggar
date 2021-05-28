package com.decagon.android.sq007.model.remote

import com.google.gson.annotations.SerializedName

class CommentNetworkEntity(

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