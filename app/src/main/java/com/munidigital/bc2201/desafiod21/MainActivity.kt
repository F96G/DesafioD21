package com.munidigital.bc2201.desafiod21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.munidigital.bc2201.desafiod21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListaFragment.MonedaSelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onMonedaSelected(moneda: Moneda) {
        findNavController(R.id.fcMainNavigation).navigate(ListaFragmentDirections.actionListaFragmentToDetalleFragment(moneda))
    }


}