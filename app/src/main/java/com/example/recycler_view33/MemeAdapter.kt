package com.example.recycler_view33

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view33.databinding.MemItemBinding

class MemeAdapter: RecyclerView.Adapter<MemeAdapter.MemeHolder>() {
    val memList = ArrayList<Mem>()
    class MemeHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = MemItemBinding.bind(item)
        fun bind(mem: Mem){
            binding.memeImage.setImageResource(mem.imageId)
            binding.tvTitle.text = mem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mem_item, parent, false)
        return (MemeHolder(view))
    }

    override fun onBindViewHolder(holder: MemeHolder, position: Int) {
        holder.bind(memList[position])
    }

    override fun getItemCount(): Int {
        return memList.size
    }

    fun addMem(mem: Mem){
        memList.add(mem)
        notifyDataSetChanged()
    }
}