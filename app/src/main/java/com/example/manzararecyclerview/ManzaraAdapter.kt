package com.example.manzararecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_manzara.view.*

class ManzaraAdapter(tumManzaralar: ArrayList<Manzara>) : RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {

    var manzaralar = tumManzaralar

    override fun getItemCount(): Int {
        return manzaralar.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {

        var inflater = LayoutInflater.from(parent?.context)
        var tekSatirmanzara = inflater.inflate(R.layout.tek_satir_manzara, parent, false)

        Log.e("RECYCLERVIEW", "ON CREATE VIEW HOLDER TETIKLENDI")
        return ManzaraViewHolder(tekSatirmanzara)


    }


    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {


        var oanOlusturulanManzara = manzaralar.get(position)
        holder?.setData(oanOlusturulanManzara, position)


    }


    inner class ManzaraViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var tekSatirManzara = itemView as CardView

        var manzaraBaslik = tekSatirManzara.txtManzaraBaslik
        var manzaraAciklama = tekSatirManzara.txtManzaraAciklama
        var manzaraResim = tekSatirManzara.imgManzara
        var btnKopyala = tekSatirManzara.imageViewKopya
        var btnSil = tekSatirManzara.imageViewSil




        fun setData(oankiManzara: Manzara, position: Int) {


            manzaraBaslik.text = oankiManzara.baslik
            manzaraAciklama.text = oankiManzara.aciklama
            manzaraResim.setImageResource(oankiManzara.resim)

            btnKopyala.setOnClickListener {

                manzaralar.add(position, oankiManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position, manzaralar.size)


            }

            btnSil.setOnClickListener {


                manzaralar.removeAt(position)
                btnSil.isClickable = false
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, manzaralar.size)


            }


        }


    }
}



