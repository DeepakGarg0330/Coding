package com.example.codingassignment.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.codingassignment.R
import com.example.codingassignment.dto.Address


/**
 * Created by deepak.garg on_it 16/05/2020
 */

class CitySearchAdapter(val context: Context, var addressList: List<Address>?) :
    RecyclerView.Adapter<CitySearchAdapter.CitySearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitySearchViewHolder {
        return CitySearchViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CitySearchViewHolder, position: Int) {
        holder.addressLine.text = addressList!!.get(position).addressString
    }

    override fun getItemCount(): Int {
        return addressList?.size?: 0
    }

    fun updateList(addressList: List<Address>?) {
        this.addressList = addressList
        notifyDataSetChanged()
    }

    class CitySearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val addressLine = view.findViewById<TextView>(R.id.address_line)
    }

}