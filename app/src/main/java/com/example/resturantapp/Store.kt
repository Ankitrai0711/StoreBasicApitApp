package com.example.resturantapp

import ApiInterface
import MyAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resturantapp.databinding.FragmentStoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Store : Fragment() {
    val baseUrl = "https://fakestoreapi.com"
    private lateinit var binding : FragmentStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)


        getData()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    private fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retroData = retrofit.getData()
        retroData.enqueue(object : Callback<List<MyData>>{
            override fun onResponse(call: Call<List<MyData>>, response: Response<List<MyData>>) {
                val my_data = response.body()!!

                binding.recyclerView.adapter = MyAdapter(requireContext(),my_data)

                if(response.isSuccessful){
                    Log.e("getData", my_data.toString())
                }
            }

            override fun onFailure(call: Call<List<MyData>>, t: Throwable) {
                Log.e("getData", "Failure: ${t.message}")            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }


}