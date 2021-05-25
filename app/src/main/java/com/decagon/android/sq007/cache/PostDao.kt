package com.decagon.android.sq007.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(postEntity: PostCacheEntity) : Long

    @Query("SELECT * FROM posts ")
    suspend fun get() : List<PostCacheEntity>
}
