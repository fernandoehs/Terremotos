package com.fernandoherrera.terremotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fernandoherrera.terremotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // conecta con activityMain.xml

        binding.eqReciclador.layoutManager = LinearLayoutManager(this) //conecta con eq_reciclador.xml

        val adapter = EqAdapter(this)
        binding.eqReciclador.adapter = adapter

        //63
        val viewModel : MainViewModel = ViewModelProvider(this,
            MainViewModelFactory(application)).get(MainViewModel::class.java)

        viewModel.eqList.observe(this, Observer {eqList -> adapter.submitList(eqList)
            //muestra aviso cuando esta vacia
            VerVistaVacia(eqList, binding)
        })



        //conecta con el adaptador usando binding

        //adapter.submitList(eqList)
        //aparece un toast por cada item
        adapter.onItemClickListener = {
            Toast.makeText(this,it.place,Toast.LENGTH_SHORT).show()
        }

        //retrofit con scalar q transforma a string
       // service.getLastTerremoto()
    }

    private fun VerVistaVacia(
        eqList: MutableList<Terremoto>,
        binding: ActivityMainBinding
    ) {
        if (eqList.isEmpty()) {
            binding.eqVacio.visibility = View.VISIBLE
        } else {
            binding.eqVacio.visibility = View.GONE
        }
    }


}