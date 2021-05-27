package com.decagon.android.sq007.remote

import com.decagon.android.sq007.model.Comment
import com.decagon.android.sq007.util.EntityMapper

class CommentNetworkMapper : EntityMapper<CommentNetworkEntity, Comment> {

    override fun mapFromEntity(entity: CommentNetworkEntity): Comment {
        return Comment(

        )
    }

    override fun mapToEntity(domainModel: Comment): CommentNetworkEntity {
        return CommentNetworkEntity(

        )
    }
}