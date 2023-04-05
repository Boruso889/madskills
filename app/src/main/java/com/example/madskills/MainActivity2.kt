package com.example.madskills

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity2 : AppCompatActivity() {

    //private var rNews: RecyclerView? = null
    //private var news: ArrayList<NewsClass> = ArrayList()
    //private lateinit var selectItem: TextView

    private var catlogs: ArrayList<CatlogClass> = ArrayList()
    private var CatlogRecycle: RecyclerView? = null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        /*  rNews = findViewById(R.id.rNews)
        // rCatlog = findViewById(R.id.rCatlog)

        val retrofitServices: RetrofitServices =
            RetrofitClient.getClient("https://medic.madskill.ru/")
                .create(RetrofitServices::class.java)


        val response = retrofitServices.getNews().enqueue(object : Callback<ArrayList<NewsClass>> {
            override fun onResponse(
                call: Call<ArrayList<NewsClass>>,
                response: Response<ArrayList<NewsClass>>
            ) {
                news = response.body()!! // Создаем глобальный список карточек
                updateRecyclerView(news)
                Log.e("Allo", news.toString())
            }

            override fun onFailure(call: Call<ArrayList<NewsClass>>, t: Throwable) {
                Log.e("Беда.", t.message.toString())
            }
        })
    }

    fun updateRecyclerView(news: ArrayList<NewsClass>) {
        rNews?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val recyclerAdapter = NewsAdapter(news)
        rNews?.adapter = recyclerAdapter

    }
}
*/

        CatlogRecycle = findViewById(R.id.rCatlo)
        val retrofitServices: RetrofitServices =
            RetrofitClient.getClient("https://medic.madskill.ru/")
                .create(RetrofitServices::class.java)

        val response =
            retrofitServices.getCatlog().enqueue(object : Callback<ArrayList<CatlogClass>> {
                override fun onResponse(
                    call: Call<ArrayList<CatlogClass>>,
                    response: Response<ArrayList<CatlogClass>>
                ) {
                    catlogs = response.body()!! // Создаем глобальный список карточек
                    updateRecyclerView(catlogs)
                    Log.e("Allo", catlogs.toString())
                }

                override fun onFailure(call: Call<ArrayList<CatlogClass>>, t: Throwable) {
                    Log.e("Беда.", t.message.toString())
                }
            })
    }

    fun updateRecyclerView(catlogs: ArrayList<CatlogClass>) {
        CatlogRecycle?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        CatlogRecycle?.adapter = recyclerAdapter
    }

}







