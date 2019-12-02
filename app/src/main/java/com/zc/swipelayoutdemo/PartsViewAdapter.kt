package com.zc.swipelayoutdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SimpleSwipeListener
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter

class PartsViewAdapter(private var context: Context,
                       private var dataList: List<Part>) :
    RecyclerSwipeAdapter<PartsViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartsViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_part, parent, false)
        return ViewHolder(view)
    }

    override fun getSwipeLayoutResourceId(position: Int): Int {
        return R.id.swipe_layout
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.partName.text = item.name
        holder.partPrice.text = item.price.toString()
        holder.swipeLayout.showMode = SwipeLayout.ShowMode.LayDown
        holder.deleteButton.setOnClickListener {
            Toast.makeText(context,holder.partName.text.toString() + " DELETE!", Toast.LENGTH_SHORT).show()
        }
        holder.editButton.setOnClickListener {
            Toast.makeText(context,holder.partName.text.toString() + " CHANGED!", Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var partName: TextView = itemView.findViewById(R.id.part_name)
        var partPrice: TextView = itemView.findViewById(R.id.part_price)
        var swipeLayout: SwipeLayout = itemView.findViewById(R.id.swipe_layout)
        var deleteButton: ImageView = itemView.findViewById(R.id.delete_image)
        var editButton: ImageView = itemView.findViewById(R.id.edit_image)

    }
}