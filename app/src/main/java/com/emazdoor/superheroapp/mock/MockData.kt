package com.emazdoor.superheroapp.mock

import com.emazdoor.superheroapp.model.Appearance
import com.emazdoor.superheroapp.model.Biography
import com.emazdoor.superheroapp.model.Connections
import com.emazdoor.superheroapp.model.Images
import com.emazdoor.superheroapp.model.PowerStates
import com.emazdoor.superheroapp.model.Superhero
import com.emazdoor.superheroapp.model.Work

object MockData {
    private val mockData = mutableListOf<Superhero>()

    init {
        mockData.add(
            Superhero(
                345,
                "Iron Fist",
                "345-iron-fist",
                PowerStates(
                    75,
                    55,
                    33,
                    50,
                    95,
                    100
                ),
                Appearance(
                    "Male",
                    "Human",
                    height = mutableListOf(
                        "5'11",
                        "180 cm"
                    ),
                    weight = mutableListOf(
                        "175 lb",
                        "79 kg"
                    ),
                    "Blue",
                    "Blond"
                ),
                Biography(
                    "Danny Rand",
                    "No alter egos found.",
                    aliases = mutableListOf(
                        "Daredevil",
                        "Daniel Thomas Rand",
                        "the Living Weapon",
                        "Young Dragon",
                        "Danny Rand"
                    ),
                    "-",
                    "Marvel Premiere #15 (May 1974)",
                    "Marvel Comics",
                    "good",
                ),
                Work(
                    "Adventurer; formerly co-owner of Rand-Meachum, Inc., bodyguard, private investigator, research assistant, warrior",
                    "New York"
                ),
                Connections(
                    "New Avengers, Heroes for Hire, Inc., Secret Defenders, Defenders, Misty Knight, Luke Cage",
                    "Wendell Rand-K'ai (father, deceased), Heather Duncan Rand (mother, deceased), Yu-Ti (adopted uncle), Miranda Rand-K'ai (half-sister), Lord Tuan (adopted paternal grandfather, deceased), Lady Ming (adopted paternal grandmother, deceased), Thomas Duncan (maternal grandfather)"
                ),
                Images(
                    "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/images/xs/345-iron-fist.jpg",
                    "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/images/sm/345-iron-fist.jpg",
                    "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/images/md/345-iron-fist.jpg",
                    "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/images/lg/345-iron-fist.jpg"
                )
            )
        )
    }

    fun getMockData(): MutableList<Superhero> {
        return mockData
    }
}
