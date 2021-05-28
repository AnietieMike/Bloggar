package com.decagon.android.sq007.model

import com.decagon.android.sq007.apis.PostService
import com.decagon.android.sq007.cache.CommentCacheMapper
import com.decagon.android.sq007.cache.PostCacheMapper
import com.decagon.android.sq007.cache.PostDao
import com.decagon.android.sq007.remote.CommentNetworkMapper
import com.decagon.android.sq007.remote.PostNetworkMapper
import com.decagon.android.sq007.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val postDao: PostDao,
    private val postService: PostService,
    private val postCacheMapper: PostCacheMapper,
    private val postNetworkMapper: PostNetworkMapper,
    private val commentCacheMapper: CommentCacheMapper,
    private val commentNetworkMapper: CommentNetworkMapper
) {

    suspend fun getPosts() : Flow<DataState<List<Post>>> = flow {
        emit(DataState.loading())
        try {
            val remotePosts = postService.fetchPosts()
            val posts = postNetworkMapper.mapFromEntityList(remotePosts)
            for (post in posts) {
                postDao.add(postCacheMapper.mapToEntity(post))
            }
            val cachedPosts = postDao.getPosts()
            emit(DataState.success(postCacheMapper.mapFromEntityList(cachedPosts)))
        }
        catch (e: Exception) {
            emit(DataState.error<Nothing>("Error", e))
        }
    }
}