package com.decagon.android.sq007.model.remote

import com.decagon.android.sq007.model.domain.Post
import com.decagon.android.sq007.util.EntityMapper

class PostNetworkMapper : EntityMapper<PostRemoteEntity, Post> {

    override fun mapFromEntity(entity: PostRemoteEntity): Post {
        return Post(
            userId = entity.userId,
            postId = entity.id,
            title = entity.title,
            body = entity.body
        )
    }


    override fun mapToEntity(domainModel: Post): PostRemoteEntity {
        return PostRemoteEntity(
            userId = domainModel.userId,
            id = domainModel.postId,
            title = domainModel.title,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities : List<PostRemoteEntity>) : List<Post> {
        return entities.map { mapFromEntity(it) }
    }
}