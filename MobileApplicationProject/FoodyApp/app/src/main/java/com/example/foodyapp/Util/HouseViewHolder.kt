package com.example.foodyapp.Util

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodyapp.R

class HouseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView = view.findViewById<ImageView>(R.id.ivHouse)
    private val textViewHouseDetail = view.findViewById<TextView>(R.id.tvHouseDetail)
    private val textViewPrice = view.findViewById<TextView>(R.id.tvPriceTag)
    private val context = view.context
    private val textViewType = view.findViewById<TextView>(R.id.tvFoodType)
    private val ivActionBtn = view.findViewById<ImageView>(R.id.ivActionBtn)

    fun bind(houseItem: HouseItem) {
//        imageView.setImageResource(houseItem.imageId)
        Glide.with(context).load(houseItem.image_url).into(imageView);
        textViewHouseDetail.text = houseItem.location
        textViewPrice.text = houseItem.price
        textViewType.text = houseItem.type_food

        ivActionBtn.setOnClickListener {
            GlobalBox.selectedHouseItem = houseItem
            GlobalBox.savedBottomNavigation?.setItemSelected(R.id.mapPage)
        }

    }

}