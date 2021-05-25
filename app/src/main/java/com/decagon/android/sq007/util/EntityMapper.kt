package com.decagon.android.sq007.util

interface EntityMapper<Entity, Domain> {

    fun mapFromEntity(entity : Entity) : Domain

    fun mapToEntity(domainModel : Domain) : Entity
}