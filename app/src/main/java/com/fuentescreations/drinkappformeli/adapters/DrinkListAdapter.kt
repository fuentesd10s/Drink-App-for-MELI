package com.fuentescreations.drinkappformeli.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fuentescreations.drinkappformeli.R
import com.fuentescreations.drinkappformeli.data.models.DrinkListModel
import com.fuentescreations.drinkappformeli.data.models.DrinkModel
import com.fuentescreations.drinkappformeli.databinding.ItemDrinkPreviewBinding
import com.fuentescreations.drinkappformeli.utils.ALCOHOLIC_ENUM
import com.fuentescreations.drinkappformeli.utils.loadImage
import com.fuentescreations.drinkappformeli.utils.setToInvisible

class DrinkListAdapter(
    private val onDrinkClickListener: OnDrinkClickListener
) : RecyclerView.Adapter<DrinkListAdapter.ItemDrinkViewHolder>() {

    private var drinkList = DrinkListModel()

    interface OnDrinkClickListener {
        fun onDrinkClickListener(id: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDrinkViewHolder =
        ItemDrinkViewHolder(
            ItemDrinkPreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return if (drinkList.list.isNullOrEmpty())
            0
        else
            drinkList.list!!.size
    }

    override fun onBindViewHolder(holder: ItemDrinkViewHolder, position: Int) = holder.bind(drinkList.list!![position])

    inner class ItemDrinkViewHolder(private val b: ItemDrinkPreviewBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(drink: DrinkModel) {

            b.apply {
                ivDrinkItem.loadImage(drink.thumbnailUrl)

                tvDrinkNameItem.text = drink.name
                tvIngredientOne.text = "• ${drink.ingredient1}"
                tvIngredientTwo.text = "• ${drink.ingredient2}"
                tvIngredientThree.text = "• ${drink.ingredient3}"
                tvIngredientFour.text = "• ${drink.ingredient4}"

                if (drink.ingredient1.isNullOrEmpty())
                    tvIngredientOne.setToInvisible()

                if (drink.ingredient2.isNullOrEmpty())
                    tvIngredientTwo.setToInvisible()

                if (drink.ingredient3.isNullOrEmpty())
                    tvIngredientThree.setToInvisible()

                if (drink.ingredient4.isNullOrEmpty())
                    tvIngredientFour.setToInvisible()

                val alcoholIcon =
                    if (drink.alcoholic!! == ALCOHOLIC_ENUM.ALCOHOLIC.str)
                        R.drawable.ic_has_alcohol
                    else
                        R.drawable.ic_hasnt_alcohol

                ivAlcoholCheckItem.setImageDrawable(ContextCompat.getDrawable(root.context, alcoholIcon))

                mcvDrink.setOnClickListener {
                    onDrinkClickListener.onDrinkClickListener(drink.id!!)
                }
            }
        }
    }

    fun updateAdapter(newDrinkList: DrinkListModel){
        drinkList = newDrinkList
        notifyDataSetChanged()
    }
}