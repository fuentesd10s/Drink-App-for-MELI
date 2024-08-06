package com.fuentescreations.drinkappformeli.data.api

import com.fuentescreations.drinkappformeli.data.models.DrinkListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("search.php")
    suspend fun getDrinkByName(@Query(value = "s") drinkName: String): DrinkListModel
}
