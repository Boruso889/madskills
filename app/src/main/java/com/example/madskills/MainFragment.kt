package com.example.madskills

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
    private var CatlogRecycle: RecyclerView? = null
    private val list = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        this.CatlogRecycle = view?.findViewById(R.id.rCatlo)
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
        selectItem = view.findViewById(R.id.rCatlo)
        selectItem.setOnClickListener{
            showBottomSheet()

        }
    }

    fun updateRecyclerView(catlogs: ArrayList<CatlogClass>) {
        CatlogRecycle?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        CatlogRecycle?.adapter = recyclerAdapter
    }
    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)

        catlogAdapter = CatlogAdapter(catlogs)
        dialog.show()
    }
}


