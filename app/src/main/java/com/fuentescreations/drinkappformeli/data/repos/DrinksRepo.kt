package com.fuentescreations.drinkappformeli.data.repos

import com.fuentescreations.drinkappformeli.data.datasources.DrinksDataSource
import com.fuentescreations.drinkappformeli.data.models.DrinkListModel

class DrinksRepo() {
    private val drinksDataSource = DrinksDataSource()

    suspend fun getDrinksListByName(drinkName: String): DrinkListModel {
        return drinksDataSource.getDrinksListByName(drinkName)
    }
}