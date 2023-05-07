package com.example.mobg5_53203.screen.recyclerview


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobg5_53203.R



class WifiRecyclerViewAdapter(private var mList: List<WifiModel> , private val listener : RecyclerViewInterface) : RecyclerView.Adapter<WifiRecyclerViewAdapter.ViewHolder>(), Filterable {

    private  var wifiListFilter : List<WifiModel> = mList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.textView.text = itemsViewModel.nomWifi
        holder.imageView.setImageResource(R.drawable.ic_baseline_wifi_24)

        holder.itemView.setOnClickListener{
            listener.onItemClick(holder.absoluteAdapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView3)
        var textView: TextView = itemView.findViewById(R.id.textView)
    }

     /**
     * Retrieves the list of WifiModels.
     *
     * @return The list of WifiModels.
     */
     fun getMlist() :  List<WifiModel>{
       return mList
    }

    /**
     * Note : toLowerCase works which is deprecated while tolowercase() does not
     */
    override fun getFilter(): Filter {
        var filter  = object : Filter(){

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var filterResult  = FilterResults()
                if(constraint == null || constraint.isEmpty()){
                    filterResult.values = wifiListFilter
                    filterResult.count = wifiListFilter.size
                }else{
                    var searchChar = constraint.toString().toLowerCase()
                    var filteredResults = ArrayList<WifiModel>()

                    for(wifiModel in wifiListFilter){
                        if(wifiModel.nomWifi?.toLowerCase()?.contains(searchChar) == true && !filteredResults.contains(wifiModel)){
                            filteredResults.add(wifiModel)
                        }
                    }
                    filterResult.values = filteredResults
                    filterResult.count = filteredResults.size

                }
                return filterResult
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                val resultList = results!!.values as? List<WifiModel>
                if (resultList != null) {
                    mList = resultList
                    notifyDataSetChanged()
                }
            }
        }
        return filter
    }
}