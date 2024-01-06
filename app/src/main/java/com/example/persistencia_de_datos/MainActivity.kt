package com.example.persistencia_de_datos

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.persistencia_de_datos.adapters.TarjetaAdapter
import com.example.persistencia_de_datos.databinding.ActivityMainBinding
import com.example.persistencia_de_datos.ui.TarjetaDialogFragment
import com.example.persistencia_de_datos.viewmodel.TarjetaDialogViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var adapter : TarjetaAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        adapter = TarjetaAdapter(this)

        var recycleDatos = findViewById<RecyclerView>(R.id.rcvDatos)
        var fabiconAgregar = findViewById<FloatingActionButton>(R.id.fabAgregar)

        recycleDatos.layoutManager = LinearLayoutManager(this)
        recycleDatos.adapter = adapter

        fabiconAgregar.setOnClickListener{
            val fragmentManager: FragmentManager = this.supportFragmentManager
            val dialogFragment = TarjetaDialogFragment()
            dialogFragment.show(fragmentManager, "NuevaTarjetaDialogFragment")
        }

        ListarTarjetasViewModel()

    }

    private fun ListarTarjetasViewModel(){
        val viewModel:TarjetaDialogViewModel = ViewModelProvider(this)
            .get(TarjetaDialogViewModel::class.java)
        viewModel.listarTarjetas().observe(this, {tarjetaEntities ->
            adapter!!.setListarTarjetas(tarjetaEntities)
        })
    }


}