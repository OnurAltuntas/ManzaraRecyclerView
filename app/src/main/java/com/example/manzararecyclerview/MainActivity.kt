package com.example.manzararecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumManzaralar=ArrayList<Manzara>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagınıDoldur()

        var myAdapter = ManzaraAdapter(tumManzaralar)

        recyclerViewManzara.adapter = myAdapter

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewManzara.layoutManager = linearLayoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.anamenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("WrongConstant")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item?.itemId

        when (id) {

            R.id.menulinearViewHorizontal -> {
                var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                recyclerViewManzara.layoutManager = linearLayoutManager
            }
            R.id.menulinearViewVertical -> {
                var menulinearViewVertical = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recyclerViewManzara.layoutManager = menulinearViewVertical
            }
            R.id.menuGrid -> {
                var menuGrid = GridLayoutManager(this, 2)
                recyclerViewManzara.layoutManager = menuGrid
            }
            R.id.menuStaggeredHorizontal -> {
                var menuStaggeredHorizontal= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
                recyclerViewManzara.layoutManager=menuStaggeredHorizontal
            }
            R.id.menuStaggeredVertical -> {
                var menuStaggeredVertical=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerViewManzara.layoutManager=menuStaggeredVertical
            }


        }

        return super.onOptionsItemSelected(item)
    }

    fun veriKaynagınıDoldur():ArrayList<Manzara>{
        var tumResimler = arrayOf(R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2, R.drawable.thumb_1_3,
            R.drawable.thumb_1_4, R.drawable.thumb_1_5, R.drawable.thumb_1_6, R.drawable.thumb_1_7,
            R.drawable.thumb_1_8, R.drawable.thumb_1_9,

            R.drawable.thumb_2_0, R.drawable.thumb_2_1, R.drawable.thumb_2_2, R.drawable.thumb_2_3,
            R.drawable.thumb_2_4, R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
            R.drawable.thumb_2_8, R.drawable.thumb_2_9,

            R.drawable.thumb_3_0, R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
            R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6, R.drawable.thumb_3_7,
            R.drawable.thumb_3_8, R.drawable.thumb_3_9,

            R.drawable.thumb_4_0, R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
            R.drawable.thumb_4_4, R.drawable.thumb_4_5, R.drawable.thumb_4_6, R.drawable.thumb_4_7,
            R.drawable.thumb_4_8, R.drawable.thumb_4_9,

            R.drawable.thumb_5_0, R.drawable.thumb_5_1, R.drawable.thumb_5_2, R.drawable.thumb_5_3,
            R.drawable.thumb_5_4, R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
            R.drawable.thumb_5_8, R.drawable.thumb_5_9,

            R.drawable.thumb_6_0, R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
            R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6, R.drawable.thumb_6_7,
            R.drawable.thumb_6_8, R.drawable.thumb_6_9,

            R.drawable.thumb_7_0, R.drawable.thumb_7_1, R.drawable.thumb_7_2, R.drawable.thumb_7_3,
            R.drawable.thumb_7_4)

        for(i in 0..tumResimler.size-1){
            var eklenecekManzara=Manzara("Manzara "+i,"Açiklama "+i,tumResimler[i])
            tumManzaralar.add(eklenecekManzara)
        }

        return tumManzaralar
    }
}
