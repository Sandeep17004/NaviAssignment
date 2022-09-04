package com.example.naviassignment.data.mapper

interface Mapper<in Model, out DomainModel> {
    fun toDomain(model: Model): DomainModel
}