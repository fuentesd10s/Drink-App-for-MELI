package com.fuentescreations.drinkappformeli.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.fuentescreations.drinkappformeli.R
import com.fuentescreations.drinkappformeli.adapters.DrinkListAdapter
import com.fuentescreations.drinkappformeli.databinding.FragmentMainBinding
import com.fuentescreations.drinkappformeli.ui.viewmodels.MainViewModel
import com.fuentescreations.drinkappformeli.utils.SimpleStates
import com.fuentescreations.drinkappformeli.utils.setToGone
import com.fuentescreations.drinkappformeli.utils.setToVisible

class MainFragment : Fragment(R.layout.fragment_main), DrinkListAdapter.OnDrinkClickListener {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var b: FragmentMainBinding
    private val drinksListAdapter = DrinkListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentMainBinding.bind(view)

        setupDrinksListRv()
        setupSearchButton()
        setupLiveDataObserver()
    }

    private fun setupDrinksListRv() {
        b.rvDrinksList.apply {
            adapter = drinksListAdapter
        }
    }

    private fun setupLiveDataObserver() {
        mainViewModel.getDrinksListLiveData().observe(viewLifecycleOwner) {
            drinksListAdapter.updateAdapter(it)
        }
    }

    private fun setupSearchButton() {
        b.btnSearch.setOnClickListener {
            val drinkName = b.etCommentField.text.toString().trim()

            if (drinkName.isNotEmpty())
                performSearch(drinkName)
        }
    }

    private fun performSearch(drinkName: String) {
        mainViewModel.getDrinkListByName(drinkName).observe(viewLifecycleOwner) {
            when(it){
                is SimpleStates.Failure -> {
                    sendCrashReport()
                    Log.d(this.javaClass.name, "FAIL: ${it.e.toString()}")
                }
                is SimpleStates.Loading -> {
                    b.progressBar.setToVisible()
                    b.rvDrinksList.setToGone()
                    Log.d(this.javaClass.name, "LOADING")
                }
                is SimpleStates.Success -> {
                    b.progressBar.setToGone()
                    b.rvDrinksList.setToVisible()
                    Log.d(this.javaClass.name, "SUCCESS")
                }
            }
        }
    }

    private fun sendCrashReport() {
        //Here you can send the crash report to Crashlytics or somewhere else :)
    }

    override fun onDrinkClickListener(id: String) {
        Toast.makeText(requireContext(), "ID $id", Toast.LENGTH_SHORT).show()
    }
}