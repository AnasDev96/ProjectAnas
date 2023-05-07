package com.example.mobg5_53203.screen.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobg5_53203.R
import com.example.mobg5_53203.database.Favoris


class FavorisRecyclerViewAdapter(private val mList: List<Favoris>, private val listener : RecyclerViewInterface) : RecyclerView.Adapter<FavorisRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_view_favoris, parent, false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.textView.text = itemsViewModel.nom
        holder.imageView.setImageResource(R.drawable.ic_baseline_wifi_24)
        holder.trash.setImageResource(R.drawable.ic_baseline_delete_24)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View,  listener :  RecyclerViewInterface ) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.favorisImageView)
        var trash: ImageView = itemView.findViewById(R.id.trash)
        var textView: TextView = itemView.findViewById(R.id.favorisTextView)

        init {
            trash.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }

        }
    }

}