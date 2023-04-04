package com.example.madskills

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var selectItem: RecyclerView
    private lateinit var dialog: BottomSheetDialog
    private lateinit var catlogAdapter: CatlogAdapter
    private var catlogs: ArrayList<CatlogClass> = ArrayList()
    private var rCatlog: RecyclerView? = null
    private val list = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        rCatlog?.adapter = recyclerAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        rCatlog = this.view?.findViewById(R.id.rCatlog)
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
        rCatlog?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        rCatlog?.adapter = recyclerAdapter
    }
}
