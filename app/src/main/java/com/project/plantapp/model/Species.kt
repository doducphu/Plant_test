package com.project.plantapp.model

data class Species(
    val id: Int,
    val title: String,
    val kingdom: String,
    val family: String,
    val description: String,
    val image: String,
    val isFavorite: Boolean
)
