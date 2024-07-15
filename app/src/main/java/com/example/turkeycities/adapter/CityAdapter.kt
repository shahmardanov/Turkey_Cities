package com.example.turkeycities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.turkeycities.databinding.CityItemBinding
import com.example.turkeycities.model.City

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val cityList = ArrayList<City>()

    inner class CityViewHolder(val itemCityBinding: CityItemBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem=cityList[position]
        holder.itemCityBinding.item=currentItem.cities
    }

    fun updateList(myList: List<City>){
        cityList.clear()
        cityList.addAll(myList)
        notifyDataSetChanged()  // this will notify the adapter that data has changed and it will redraw the list
    }
}