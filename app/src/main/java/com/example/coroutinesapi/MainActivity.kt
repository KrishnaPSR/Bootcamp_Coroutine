package com.example.coroutinesapi

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var dataList = ArrayList<DataModel>()
    lateinit var progressDialog: ProgressDialog
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        getData()
    }

    private fun setupUI() {
        createProgressDialog()
        progressDialog.show()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        api_details_RV.layoutManager = linearLayoutManager
        customAdapter = CustomAdapter(this, dataList)
        api_details_RV.adapter = customAdapter
    }
    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading Data")
        progressDialog.setMessage("Please Wait")
        progressDialog.setCancelable(false)
    }

    /**
     * Getting data from API using coroutine.
     */
    private fun getData() {
        lifecycleScope.launch {
            val call = ApiClient.getClient.getPost()
            call.enqueue(object : retrofit2.Callback<List<DataModel>> {
                override fun onFailure(call: retrofit2.Call<List<DataModel>>, t: Throwable) {
                    Log.i("MainActivity", "Error ${t.localizedMessage}")
                    Toast.makeText(this@MainActivity, "Oops! Error Occurs!!", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                }
                override fun onResponse(
                        call: retrofit2.Call<List<DataModel>>,
                        response: Response<List<DataModel>>
                ) {
                    progressDialog.dismiss()
                    Log.i("MainActivity", "Data ${response.body()}")
                    dataList.addAll(response.body()?: ArrayList())
                    api_details_RV.adapter!!.notifyDataSetChanged()
                }
            })
        }
    }
}