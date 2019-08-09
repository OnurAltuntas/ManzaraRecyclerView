package com.example.manzararecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_manzara.view.*

  class ManzaraAdapter(tumManzaralar: ArrayList<Manzara>) : RecyclerView.Adapter<ManzaraViewHolder>() {

    var manzaralar = tumManzaralar

    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {
        holder?.manzaraBaslik?.text = manzaralar.get(position).baslik
        holder?.manzaraAciklama?.text = manzaralar.get(position).aciklama
        holder?.manzaraResim?.setImageResource(manzaralar.get(position).resim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var tekSatırManzara = inflater.inflate(R.layout.tek_satir_manzara,parent, false)

        return ManzaraViewHolder(tekSatırManzara)
    }

    override fun getItemCount(): Int {
        return manzaralar.size
    }


}

 class ManzaraViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var tekSatırManzara = itemView as CardView
    var manzaraBaslik = tekSatırManzara.txtManzaraBaslik
    var manzaraAciklama = tekSatırManzara.txtManzaraAciklama
    var manzaraResim = tekSatırManzara.imgManzara
}