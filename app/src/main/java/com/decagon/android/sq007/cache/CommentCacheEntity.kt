package com.decagon.android.sq007.cache

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class CommentCacheEntity(

    @ColumnInfo(name = "id")
    var postId: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "body")
    var body: String
)