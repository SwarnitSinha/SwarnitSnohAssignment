package com.example.swarnitsnohassignment.ui.home

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swarnitsnohassignment.R
import com.example.swarnitsnohassignment.database.TheProject

class RVAdapter(private val context: Context?) : RecyclerView.Adapter<PViewHolder>(){
    private val items = ArrayList<TheProject>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_item_view,parent,false)

        return PViewHolder(view)
    }

    override fun onBindViewHolder(holder: PViewHolder, position: Int) {
    /*IMPORTANT
        This method take item one by one
        and put data corresponding to it
    */
        val currentItems = items[position]
        holder.textview.text = currentItems.anything.toString()

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(it: List<TheProject>) {
        items.clear()
        items.addAll(it)
        notifyDataSetChanged()
    }

}

class PViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
    var textview : TextView = itemview.findViewById(R.id.eachItemView)
}