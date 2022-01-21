package com.munidigital.bc2201.desafiod21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.navArgs

class DetalleFragment : Fragment() {
    //Recibo los agrumentos
    private val args: DetalleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_detalle, container, false)

        val nombre = rootView.findViewById<TextView>(R.id.tvNombre)
        val abreviatura = rootView.findViewById<TextView>(R.id.tvAbreviatura)
        val precio = rootView.findViewById<TextView>(R.id.tvPrecio)
        val fecha = rootView.findViewById<TextView>(R.id.tvFecha)
        val imaen = rootView.findViewById<ImageView>(R.id.ivImagen)

        nombre.text = args.moneda.nombre
        abreviatura.text = args.moneda.abreviatura
        precio.text = args.moneda.precio.toString()
        fecha.text = args.moneda.fecha
        imaen.setImageResource(args.moneda.imagen)

        val botonVolver = rootView.findViewById<Button>(R.id.btVolver)

        botonVolver.setOnClickListener {
            //this.fragmentManager?.popBackStack()
            //Falta volver atras sin entrar en un bucle
        }
        return rootView
    }

}