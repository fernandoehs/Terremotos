package com.fernandoherrera.terremotos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fernandoherrera.terremotos.databinding.EqListItemBinding
import org.w3c.dom.Text


class EqAdapter(private  val context:Context): ListAdapter<Terremoto, EqAdapter.EqViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<Terremoto>(){
        override fun areItemsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Terremoto)-> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val binding = EqListItemBinding.inflate(LayoutInflater.from(parent.context)) //se cambio a data binding
        return EqViewHolder(binding)

        //val view = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_item,parent,false)
       // return EqViewHolder(view)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
       val terremotos = getItem(position)
        holder.bind(terremotos)
    // val terremotos = getItem(position)
        //holder.magnitudeText.text = terremotos.magnitude.toString()
        //holder.placeText.text = terremotos.place

    }

    inner class EqViewHolder(private val binding: EqListItemBinding):RecyclerView.ViewHolder(binding.root){
        //val magnitudeText = binding.findViewById<TextView>(R.id.eq_magnitude_text)
       // val placeText = binding.findViewById<TextView>(R.id.eq_place_text)

        fun bind(terremoto: Terremoto){
            //binding.eqMagnitudeText.text = terremoto.magnitude.toString()
            binding.eqMagnitudeText.text = context.getString(R.string.magnitude_format,terremoto.magnitude)
            binding.eqPlaceText.text = terremoto.place
            binding.root.setOnClickListener{
                onItemClickListener(terremoto)
            }

        }

    }
}