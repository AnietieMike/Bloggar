package com.decagon.android.sq007.remote

import com.decagon.android.sq007.model.Comment
import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.util.EntityMapper

class CommentRemoteMapper : EntityMapper<CommentRemoteEntity, Comment> {

    override fun mapFromEntity(entity: CommentRemoteEntity): Comment {
        return Comment(

        )
    }

    override fun mapToEntity(domainModel: Comment): CommentRemoteEntity {
        return CommentRemoteEntity(

        )
    }
}