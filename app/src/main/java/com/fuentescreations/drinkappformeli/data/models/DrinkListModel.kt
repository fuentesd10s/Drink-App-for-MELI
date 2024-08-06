package com.fuentescreations.drinkappformeli.data.models

import com.google.gson.annotations.SerializedName

data class DrinkListModel(
    @SerializedName("drinks")
    val list: MutableList<DrinkModel>? = mutableListOf()
)