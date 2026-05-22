package com.example.modul1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransaksiAdapter(private val list : ArrayList<TransaksiModel>)
    : RecyclerView.Adapter<TransaksiAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nama = itemView.findViewById<TextView>(R.id.txtNama)
        val tanggal = itemView.findViewById<TextView>(R.id.txtTanggal)
        val nominal = itemView.findViewById<TextView>(R.id.txtNominal)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaksi,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = list[position]

        holder.nama.text = data.nama
        holder.tanggal.text = data.tanggal
        holder.nominal.text = data.nominal

    }

}