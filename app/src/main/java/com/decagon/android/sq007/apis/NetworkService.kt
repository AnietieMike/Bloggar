package com.decagon.android.sq007.apis

import com.decagon.android.sq007.remote.CommentRemoteEntity
import com.decagon.android.sq007.remote.PostRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts/")
    suspend fun fetchPosts(): List<PostRemoteEntity>

    @GET("posts/{id}")
    fun fetchPost(@Path("id") postId: Int): PostRemoteEntity

    @GET("comments/")
    suspend fun fetchComments() : List<CommentRemoteEntity>
}