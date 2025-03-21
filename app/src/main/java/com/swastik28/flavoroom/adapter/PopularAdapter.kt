package com.swastik28.flavoroom.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swastik28.flavoroom.databinding.PopularBinding

class PopularAdapter (private val items:List<String>,private val price:List<String>, private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
    return PopularViewHolder(PopularBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val images = image[position]
        holder.bind(item,price,images)
    }
    override fun getItemCount(): Int {
       return items.size
    }
    class PopularViewHolder (private val binding: PopularBinding) : RecyclerView.ViewHolder(binding.root)  {
        private val imagesView = binding.imageView6
        fun bind(item: String,price : String, images: Int) {
            binding.foodName.text = item
            binding.priceofPopular.text = price
            imagesView.setImageResource(images)
        }
    }
}