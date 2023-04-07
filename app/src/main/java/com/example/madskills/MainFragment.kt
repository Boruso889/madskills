package com.example.madskills

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainFragment : Fragment() {


    private var catlogs: ArrayList<CatlogClass> = ArrayList()
    private var CatlogRecycle: RecyclerView? = null
    private var NewsRecycle: RecyclerView? = null
    private var news: ArrayList<NewsClass> = ArrayList()


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* tvCatBtn.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val views = layoutInflater.inflate(R.layout.bottom_sheet, null)
            dialog.setContentView(views)
            dialog.show()
        }*/

        this.CatlogRecycle = view.findViewById(R.id.rCatlo)
        val retrofitServices: RetrofitServices =
            RetrofitClient.getClient("https://medic.madskill.ru/")
                .create(RetrofitServices::class.java)

        val response = retrofitServices.getCatlog().enqueue(object :
            Callback<ArrayList<CatlogClass>> {
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

        this.NewsRecycle = view.findViewById(R.id.rNews)

        val responses = retrofitServices.getNews().enqueue(object : Callback<ArrayList<NewsClass>> {
            override fun onResponse(
                call: Call<ArrayList<NewsClass>>,
                responses: Response<ArrayList<NewsClass>>
            ) {
                news = responses.body()!! // Создаем глобальный список карточек
                updateRecyclerView(news)
                Log.e("Allo", news.toString())
            }

            override fun onFailure(call: Call<ArrayList<NewsClass>>, t: Throwable) {
                Log.e("Беда.", t.message.toString())
            }
        })
    }

   protected fun updateRecyclerView(news: ArrayList<NewsClass>) {
        this.NewsRecycle?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val recyclerAdapter = NewsAdapter(news)
        this.NewsRecycle?.adapter = recyclerAdapter
    }
    private fun updateRecyclerView(catlogs: ArrayList<CatlogClass>) {
        CatlogRecycle?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        CatlogRecycle?.adapter = recyclerAdapter
    }

}


