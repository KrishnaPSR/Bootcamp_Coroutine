package com.example.coroutinesapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val dataSet: List<DataModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val TitleTextView: TextView = view.findViewById(R.id.Title_TV)
        val MsgTextView: TextView = view.findViewById(R.id.Msg_TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CustomAdapter.ViewHolder {

        // Now Create new view, that defines the UI of the list item.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.TitleTextView.text = dataSet[position].titleText
        holder.MsgTextView.text = dataSet[position].msgText
    }
}