package com.decagon.android.sq007.model

import com.decagon.android.sq007.apis.PostService
import com.decagon.android.sq007.cache.CacheMapper
import com.decagon.android.sq007.cache.PostDao
import com.decagon.android.sq007.remote.NetworkMapper
import com.decagon.android.sq007.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val postDao: PostDao,
    private val postService: PostService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getPosts() : Flow<DataState<List<Post>>> = flow  {
        emit(DataState.Loading)
        try {
            val remotePosts = postService.fetchPosts()
            val posts = networkMapper.mapFromEntityList(remotePosts)
            for (post in posts) {
                postDao.add(cacheMapper.mapToEntity(post))
            }
            val cachedPosts = postDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedPosts)))
        }
        catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}