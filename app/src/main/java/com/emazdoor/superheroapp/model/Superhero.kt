package com.emazdoor.superheroapp.model

data class Superhero(
    val id: Int,
    val name: String,
    val slug: String,
    val powerstats: PowerStates,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
)


