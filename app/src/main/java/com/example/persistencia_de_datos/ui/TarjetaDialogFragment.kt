package com.example.persistencia_de_datos.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.persistencia_de_datos.R
import com.example.persistencia_de_datos.db.entity.TarjetaEntity
import com.example.persistencia_de_datos.viewmodel.TarjetaDialogViewModel

class TarjetaDialogFragment: DialogFragment() {

    private lateinit var viewModel: TarjetaDialogViewModel
    private lateinit var textTitulo : EditText
    private lateinit var textContenido : EditText
    private lateinit var radioGrbColor : RadioGroup
    private lateinit var radiobtnAmarillo : RadioButton
    private lateinit var radiobtnVerde : RadioButton
    private lateinit var radiobtnRojo : RadioButton
    private lateinit var switchImportant : Switch

    companion object{
        fun newInstance() = TarjetaDialogFragment()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModel = ViewModelProvider(requireActivity()).get(TarjetaDialogViewModel::class.java)
        val inflater:LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.tarjeta_dialog_fragment, null)

        textTitulo = view.findViewById(R.id.txtTitulo)
        textContenido = view.findViewById(R.id.txtContenido)
        radioGrbColor = view.findViewById(R.id.rbtContenedor)
        radiobtnAmarillo = view.findViewById(R.id.rbtAmarillo)
        radiobtnRojo = view.findViewById(R.id.rbtRojo)
        radiobtnVerde = view.findViewById(R.id.rbtVerde)
        switchImportant = view.findViewById(R.id.swImportante)

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)

        builder.setTitle("Nueva Tarjeta")
        builder.setMessage("Introduzca los datos de la tarjeta")
            .setPositiveButton("Guardar", DialogInterface.OnClickListener{
                dialog, which ->

                val titulo = textTitulo.text.toString()
                val contenido = textContenido.text.toString()
                var color = "Amarillo"
                when(radioGrbColor.checkedRadioButtonId){
                    R.id.rbtRojo -> color = "Rojo"
                    R.id.rbtVerde -> color = "Verde"
                }

                val swInportant: Boolean = switchImportant.isChecked
                viewModel.insertar(
                    TarjetaEntity(0, titulo, contenido, swInportant, color)
                )
                dialog.dismiss()
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener{
                dialog, which -> dialog.dismiss()
            })

        builder.setView(view)
        return builder.create()


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        viewModel = ViewModelProvider(this).get(TarjetaDialogViewModel::class.java)
    }

}