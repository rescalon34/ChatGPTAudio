package com.escalondev.data.mapper

interface DomainMapper <T : Any> {
    fun mapToDomainModel(): T
}
