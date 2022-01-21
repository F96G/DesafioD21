package com.munidigital.bc2201.desafiod21

import android.content.Context
import android.view.AttachedSurfaceControl
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.munidigital.bc2201.desafiod21.databinding.ListMonedasBinding

class MonedasAdapter(): ListAdapter<Moneda, MonedasAdapter.ViewHolder>(DiffCallbak) {

    //Permite saber que item se agrego o edito o se borro
    companion object DiffCallbak : DiffUtil.ItemCallback<Moneda>(){
        override fun areItemsTheSame(oldItem: Moneda, newItem: Moneda): Boolean {
            return oldItem.nombre == newItem.nombre
        }

        override fun areContentsTheSame(oldItem: Moneda, newItem: Moneda): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Moneda) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonedasAdapter.ViewHolder {
        val binding = ListMonedasBinding.inflate(LayoutInflater.from(parent.context))

        //Le pasamos el layout a nuestro viewHolder
        return ViewHolder(binding)
    }

    //Esta clase pinta los elementos del view holder en la posicion indicada
    override fun onBindViewHolder(holder: MonedasAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    //Es una clase que pertenece al adapter
    inner class ViewHolder(private val binding: ListMonedasBinding): RecyclerView.ViewHolder(binding.root){
        //Son todos los view que componen al adapter y que deben pintarse
        fun bind(moneda: Moneda){
            binding.tvNombre.text = moneda.nombre

            binding.ivMoneda.setImageResource(moneda.imagen)
            //Esto no es muy necesario pero agiliza la velocidad del recyclerView en caso de listas muy grandes
            binding.executePendingBindings()

            binding.root.setOnClickListener{
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(moneda)
            }
        }
    }
}