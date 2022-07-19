package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var height = 150
    private var weight = 75
    private var doubleheight = 2.25
    private var imc = 33.33
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultado()


        binding.sbAltura.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {
                binding.tvAltura2.text = progress.toString().plus("/200")
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
                    binding.tvPeso2.text = progress.toString().plus("/150")
                }
                override fun onStartTrackingTouch(seek: SeekBar?) {

                }

                override fun onStopTrackingTouch(seek: SeekBar?) {
                    resultado()
                }
            })

        }
    fun resultado(){
        doubleheight = height.times(height)/1000.0
        imc =Math.round((weight/doubleheight)
            .times(100))
            .div(100.0)
        binding.tvresultado.text = imc.toString()
        calcObesidad()
    }
    fun calcObesidad(){

    }
}


