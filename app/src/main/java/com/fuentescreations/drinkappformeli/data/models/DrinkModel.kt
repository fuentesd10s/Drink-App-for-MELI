package com.fuentescreations.drinkappformeli.data.models

import com.google.gson.annotations.SerializedName

data class DrinkModel(
    @SerializedName("idDrink")
    var id: String? = null,

    @SerializedName("strDrink")
    var name: String? = null,

    @SerializedName("strAlcoholic")
    var alcoholic: String? = null,

    @SerializedName("strDrinkThumb")
    var thumbnailUrl: String? = null,

    @SerializedName("strIngredient1")
    var ingredient1: String? = null,

    @SerializedName("strIngredient2")
    var ingredient2: String? = null,

    @SerializedName("strIngredient3")
    var ingredient3: String? = null,

    @SerializedName("strIngredient4")
    var ingredient4: String? = null,
)
