package com.fuentescreations.drinkappformeli.data.datasources

import com.fuentescreations.drinkappformeli.data.models.DrinkListModel
import com.fuentescreations.drinkappformeli.data.api.RetrofitClient

class DrinksDataSource {
    suspend fun getDrinksListByName(drinkName: String) : DrinkListModel {
        return RetrofitClient.retrofit.getDrinkByName(drinkName)
    }
}