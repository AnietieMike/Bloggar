package com.decagon.android.sq007.remote

import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.util.EntityMapper

class NetworkMapper : EntityMapper<PostRemoteEntity, Post > {
    override fun mapFromEntity(entity: PostRemoteEntity): Post {
        return Post(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Post): PostRemoteEntity {
        return PostRemoteEntity(
            userId = domainModel.userId,
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities : List<PostRemoteEntity>) : List<Post> {
        return entities.map { mapFromEntity(it) }
    }
}