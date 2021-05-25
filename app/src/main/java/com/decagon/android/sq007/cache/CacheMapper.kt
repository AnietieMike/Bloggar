package com.decagon.android.sq007.cache

import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.util.EntityMapper

class CacheMapper : EntityMapper<PostCacheEntity, Post> {
    override fun mapFromEntity(entity: PostCacheEntity): Post {
        return Post(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Post): PostCacheEntity {
        return PostCacheEntity(
            userId = domainModel.userId,
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities : List<PostCacheEntity>) : List<Post> {
        return entities.map { mapFromEntity(it) }
    }
}