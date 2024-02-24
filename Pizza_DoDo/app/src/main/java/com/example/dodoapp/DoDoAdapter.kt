package com.example.dodoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DoDoAdapter(private val onItemClickListener:(DoDoItem)->Unit):
    ListAdapter<DoDoItem, DoDoAdapter.DoDoItemViewHolder>(DiffCallback) {

    class DoDoItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val name:TextView=view.findViewById(R.id.name)
        val description:TextView=view.findViewById(R.id.description)
        val img:ImageView=view.findViewById(R.id.img)
        val price:TextView=view.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoDoItemViewHolder {
        val layout=when(viewType){
            VIEW_TYPE_PIZZA->R.layout.item_pizza
            VIEW_TYPE_COMBO->R.layout.item_specialpizza
            else->throw RuntimeException("Unknown viewType $viewType")
        }

        val view=LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return DoDoItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if(getItem(position).type==ItemType.PIZZA){
            return VIEW_TYPE_PIZZA
        }
        else if(getItem(position).type==ItemType.COMBO){
            return VIEW_TYPE_COMBO
        }
        else{
            throw RuntimeException("Unknown viewType")
        }
    }

    override fun onBindViewHolder(viewHolder: DoDoItemViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.name.text = item.name
        viewHolder.img.setImageResource(item.imgSource)
        viewHolder.description.text=item.description
        viewHolder.price.text=item.price.toString()+" KZT"
        viewHolder.itemView.setOnClickListener{
            onItemClickListener(item)
        }
    }

    companion object{
        const val VIEW_TYPE_PIZZA=100
        const val VIEW_TYPE_COMBO=101

    }

    object DiffCallback: DiffUtil.ItemCallback<DoDoItem>() {
        override fun areItemsTheSame(oldItem: DoDoItem, newItem: DoDoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DoDoItem, newItem: DoDoItem): Boolean {
            return oldItem == newItem
        }
    }
}