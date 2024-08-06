package com.fuentescreations.drinkappformeli.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fuentescreations.drinkappformeli.data.models.DrinkListModel
import com.fuentescreations.drinkappformeli.data.repos.DrinksRepo
import com.fuentescreations.drinkappformeli.utils.SimpleStates

class MainViewModel(): ViewModel() {

    private val drinksRepo = DrinksRepo()
    private val drinksList = MutableLiveData<DrinkListModel>()

    init {
        drinksList.value = DrinkListModel()
    }

    fun getDrinksListLiveData() = drinksList

    fun getDrinkListByName(drinkName: String) = liveData {
        emit(SimpleStates.Loading())

        try {
            drinksList.value = drinksRepo.getDrinksListByName(drinkName)

            emit(SimpleStates.Success())
        }catch (e: Exception) {
            emit(SimpleStates.Failure(e))
        }
    }
}