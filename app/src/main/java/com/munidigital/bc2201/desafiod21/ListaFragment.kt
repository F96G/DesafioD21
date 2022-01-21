package com.munidigital.bc2201.desafiod21

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

class ListaFragment : Fragment() {
    //utilizo la interface para pasarle datos al Activity
    interface MonedaSelectListener{
        fun onMonedaSelected(moneda: Moneda)
    }

    private lateinit var monedaSelectListener: MonedaSelectListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_lista, container, false)
        val adapter = MonedasAdapter()

        val lista = rootView.findViewById<RecyclerView>(R.id.rvListaMonedas)
        //Como no tengo un contexto, requireActivity se lo pide a la actividad que ejecuta el fragment
        lista.layoutManager = LinearLayoutManager(requireActivity())
        lista.adapter = adapter

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.yaCargado()

        adapter.onItemClickListener = {
            monedaSelectListener.onMonedaSelected(it)
        }

        adapter.submitList(mutableListOf<Moneda>(
            Moneda("Bitcoin","BTC",14500.2345,"15-12-1996",R.drawable.bitcoin),
            Moneda("Etherium","ETH",9024.23324,"8-2-1724",R.drawable.etherium),
            Moneda("Dogecoin","DOG",14.5241545,"17-8-2011",R.drawable.dogue)
        ))
        return rootView
    }

    //Se llama cuando el fragment es llamado por el Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //El activity que use este fragment debe implementar a fueza pokemonSelectListener
        monedaSelectListener = try {
            context as MonedaSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }
}