package com.zc.swipelayoutdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SimpleSwipeListener
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter

class UserViewAdapter(
    private var context: Context,
    private var dataList: MutableList<String>
) : RecyclerSwipeAdapter<UserViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.userName.text = item
        holder.userId.text = position.toString()

        holder.swipeLayout.showMode = SwipeLayout.ShowMode.LayDown
        holder.swipeLayout.addSwipeListener(object : SimpleSwipeListener() {
        })
        holder.swipeLayout.setOnDoubleClickListener { _, _ ->
            Toast.makeText(
                context,
                "DoubleClick",
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.deleteButton.setOnClickListener { view ->
            mItemManger.removeShownLayouts(holder.swipeLayout)
            dataList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataList.size)
            mItemManger.closeAllItems()
            Toast.makeText(
                view.context,
                "Deleted " + holder.userName.text.toString() + "!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getSwipeLayoutResourceId(position: Int): Int {
        return R.id.swipe_layout
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userId: TextView = itemView.findViewById(R.id.user_id)
        var userName: TextView = itemView.findViewById(R.id.user_name)
        var swipeLayout: SwipeLayout = itemView.findViewById(R.id.swipe_layout)
        var deleteButton: Button = itemView.findViewById(R.id.delete)
    }
}