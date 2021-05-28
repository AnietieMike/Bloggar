package com.decagon.android.sq007.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(postEntity: PostCacheEntity) : Long

    @Query("SELECT * FROM posts ")
    suspend fun getPosts() : List<PostCacheEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addComment(commentEntity: CommentCacheEntity) : Long

    @Query("SELECT * FROM comments ")
    suspend fun getComments()
}
