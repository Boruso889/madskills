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

    private lateinit var bottomSheetDialog: BottomSheetDialog
    private var catlogs: ArrayList<CatlogClass> = ArrayList()
    lateinit var CatlogRecycle: RecyclerView
    lateinit var ListRecycle: RecyclerView
    lateinit var NewsRecycle: RecyclerView
    private var news: ArrayList<NewsClass> = ArrayList()
    lateinit var catdapt: CatlogAdapter
    lateinit var newsdapt: NewsAdapter
    val retrofitServices: RetrofitServices =
        RetrofitClient.getClient("https://medic.madskill.ru/")
            .create(RetrofitServices::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        /*this.ListRecycle = view.findViewById(R.id.rList)
        ListRecycle.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        ListRecycle.adapter = ListAdapter(fillList())*/

        this.CatlogRecycle = view.findViewById(R.id.rCatlo)
        CatlogRecycle.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        bottomSheetDialog = BottomSheetDialog(requireContext())


        this.NewsRecycle = view.findViewById(R.id.rNews)
        NewsRecycle.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)



        val response = retrofitServices.getCatlog().enqueue(object :
            Callback<ArrayList<CatlogClass>> {
            override fun onResponse(
                call: Call<ArrayList<CatlogClass>>,
                response: Response<ArrayList<CatlogClass>>
            ) {
                catlogs = response.body()!!
                catdapt = CatlogAdapter(catlogs)
                CatlogRecycle.adapter = catdapt
                Log.e("Allo", catlogs.toString())
            }

            override fun onFailure(call: Call<ArrayList<CatlogClass>>, t: Throwable) {

            }
        })

        val responses = retrofitServices.getNews().enqueue(object :
            Callback<ArrayList<NewsClass>> {
            override fun onResponse(
                call: Call<ArrayList<NewsClass>>,
                responses: Response<ArrayList<NewsClass>>
            ){
                news = responses.body()!!
                newsdapt = NewsAdapter(news)
                NewsRecycle.adapter = newsdapt
                Log.e("Allo", news.toString())
            }
            override fun onFailure(call: Call<ArrayList<NewsClass>>, t: Throwable) {
            }

        })
    }

}








/*private fun onCardViewClicked(view: View) {
    // Создаем BottomSheetDialog
    val bottomSheetDialog = BottomSheetDialog(requireContext())

    // Устанавливаем разметку для BottomSheetDialog
    val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null)
    bottomSheetDialog.setContentView(view)

    // Показываем BottomSheetDialog
    bottomSheetDialog.show()

}
private fun onCloseButtonClicked(view: View) {
    // Закрываем BottomSheetDialog
    bottomSheetDialog.dismiss() }
*/








        /* tvCatBtn.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val views = layoutInflater.inflate(R.layout.bottom_sheet, null)
            dialog.setContentView(views)
            dialog.show()
        }

        this.CatlogRecycle = view.findViewById(R.id.rCatlo)


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
*/

