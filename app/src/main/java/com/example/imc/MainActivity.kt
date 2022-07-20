package com.example.imc

import android.app.Dialog
import android.app.ProgressDialog.show
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var height = 150
    private var weight = 75
    private var doubleheight = 2.25
    private var IMC = 33.33
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.sbAltura.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {
                binding.tvAltura2.text = seekbar?.progress.toString().plus("/200")
                height = progress
            }


            override fun onStartTrackingTouch(seek: SeekBar?) {
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                resultado()
                }
            })
        binding.sbPeso.setOnSeekBarChangeListener(object:
                SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekbar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {
                    binding.tvPeso2.text = seekbar?.progress.toString().plus("/150")
                    weight = progress
                }
                override fun onStartTrackingTouch(seek: SeekBar?) {

                }

                override fun onStopTrackingTouch(seek: SeekBar?) {
                    resultado()
                }
            })

        }

    fun resultado(){
        doubleheight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleheight)
            .times(100))
            .div(100.0)
        binding.tvResultado.text = IMC.toString()
        calcObesidad()
    }
    fun calcObesidad(){
        var msj = when(IMC){
            in 0.0.. 16.00 -> Snackbar.make(binding.root, "Delgazez severa", Snackbar.LENGTH_LONG).setBackgroundTint(ContextCompat.getColor(this,R.color.Lila))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!)
                        .setView(customLayout)
                        .setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }.show()



            in 16.00.. 16.99 -> Snackbar.make(binding.root, "Delgazez Moderada", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.AzulOscuro))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!)
                        .setView(customLayout)
                        .setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            in 17.00.. 18.49-> Snackbar.make(binding.root, "Delgadez Leve", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.AzulClaro))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!)
                        .setView(customLayout)
                        .setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            in 18.50.. 24.99-> Snackbar.make(binding.root, "Peso Normal", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.VerdeOscuro))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!).setView(customLayout).setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            in 25.00.. 29.99-> Snackbar.make(binding.root, "Preobesidad", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.VerdeClaro))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!).setView(customLayout).setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            in 30.00.. 34.99-> Snackbar.make(binding.root, "Obesidad Leve", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.naranja))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!).setView(customLayout).setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            in 35.00.. 40.00-> Snackbar.make(binding.root, "Obesidad Media", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.naranjaOscuro))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!).setView(customLayout).setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }
                .show()

            else -> Snackbar.make(binding.root, "Obesidad Mórbida", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this,R.color.Rojo))
                .setAction("Ver Tabla"){
                    val inflater = this!!.layoutInflater
                    val customLayout= inflater.inflate(R.layout.tipos_de_peso,null)
                    AlertDialog.Builder(this!!).setView(customLayout).setPositiveButton("Aceptar") { dialog, id -> Snackbar.make(binding.root, R.string.Aceptar, Snackbar.LENGTH_SHORT).show()}.show()
                }.show()


        }


//        if (IMC < 16.00){
//            Snackbar.make(binding.root, "Degadez Severa", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 16.00 && IMC > 16.99){
//            Snackbar.make(binding.root, "Degadez Moderada", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 17.00 && IMC > 18.49){
//            Snackbar.make(binding.root, "Degadez Leve", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 18.50 && IMC > 24.99){
//            Snackbar.make(binding.root, "Peso Normal", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 25.00 && IMC > 29.99){
//            Snackbar.make(binding.root, "Preobesidad", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 30.00 && IMC > 34.99){
//            Snackbar.make(binding.root, "Obesidad Leve", Snackbar.LENGTH_LONG).show()
//        }else if (IMC < 35.00 && IMC > 40.00){
//            Snackbar.make(binding.root, "Obesidad Media", Snackbar.LENGTH_LONG).show()
//        }else {
//            Snackbar.make(binding.root, "Obesidad Mórbida", Snackbar.LENGTH_LONG).show()
//        }
    }
}


