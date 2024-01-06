package com.example.persistencia_de_datos.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.persistencia_de_datos.R
import com.example.persistencia_de_datos.db.entity.TarjetaEntity

class TarjetaAdapter(private val context: Context): RecyclerView.Adapter<TarjetaAdapter.ViewHolder>() {

    private var listartarjeta: List<TarjetaEntity>

    init {
        listartarjeta = ArrayList()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitulo = itemView.findViewById<TextView>(R.id.txttarjetatitulo)
        var tvContenido = itemView.findViewById<TextView>(R.id.txttarjetacontenido)
        var tvTarjeta = itemView.findViewById<ImageView>(R.id.imgTarjeta)
         var contenedor = itemView.findViewById<CardView>(R.id.crdContenedor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tarjeta, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
      return listartarjeta.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tarjeta: TarjetaEntity = listartarjeta[position]

        holder.tvTitulo.text = tarjeta.titulo
        holder.tvContenido.text = tarjeta.contenido

        if(tarjeta.importante){
            holder.tvTarjeta.setImageResource(R.drawable.start_black)
        }else{
            holder.tvTarjeta.setImageResource(R.drawable.start)
        }

        when (tarjeta.color){
            "Amarillo" -> holder.contenedor.setCardBackgroundColor(Color.YELLOW)
            "Rojo" -> holder.contenedor.setCardBackgroundColor(Color.RED)
            "Verde" -> holder.contenedor.setCardBackgroundColor(Color.GREEN)

        }
    }

    fun setListarTarjetas(lista: List<TarjetaEntity>){
        listartarjeta = lista
        notifyDataSetChanged()
    }


}