package com.decagon.android.sq007.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostRemoteEntity (

    @SerializedName("userId")
    @Expose
    var userId: Int,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String,
)