package com.example.mugiwaracrew


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mugiwaracrew.databinding.ItemRowCrewBinding

class CrewAdapter(private val listCrew: ArrayList<Crew>): RecyclerView.Adapter<CrewAdapter.CrewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    class CrewViewHolder(var binding: ItemRowCrewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CrewViewHolder {
        val binding = ItemRowCrewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CrewViewHolder(binding)
    }

    override fun getItemCount(): Int = listCrew.size

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        val (name, bounty, photo) = listCrew[position]
        holder.binding.tvCrew.text = name
        holder.binding.tvBounty.text = "Bounty $bounty"
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.ivCrew)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listCrew[holder.adapterPosition])
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Crew)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
}


