package com.decagon.android.sq007.model.remote

import com.decagon.android.sq007.model.domain.Comment
import com.decagon.android.sq007.util.EntityMapper

class CommentNetworkMapper : EntityMapper<CommentNetworkEntity, Comment> {

    override fun mapFromEntity(entity: CommentNetworkEntity): Comment {
        return Comment(
            postId = entity.postId,
            id = entity.id,
            name = entity.name,
            email = entity.email,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Comment): CommentNetworkEntity {
        return CommentNetworkEntity(
            postId = domainModel.postId,
            id = domainModel.id,
            name = domainModel.name,
            email = domainModel.email,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities : List<CommentNetworkEntity>) : List<Comment> {
        return entities.map { mapFromEntity(it) }
    }
}