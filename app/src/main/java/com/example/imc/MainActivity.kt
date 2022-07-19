package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.sbPeso.setOnSeekBarChangeListener(object:
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar,
                                               progress: Int,
                                               fromUser: Boolean) {
                    binding.tvPeso2.text = seekbar.progress.toString().plus("/200")
                }


                override fun onStartTrackingTouch(seek: SeekBar?) {
                    //write custom code for progress is starting
                }

                override fun onStopTrackingTouch(seek: SeekBar?) {
                    //write custom code for progress is stopped
                }
            })

            binding.sbAltura.setOnSeekBarChangeListener(object:
                SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekbar: SeekBar,
                                               progress: Int,
                                               fromUser: Boolean) {
                    binding.tvAltura2.text = seekbar.progress.toString().plus("/200")
                }
                override fun onStartTrackingTouch(seek: SeekBar?) {
                    //write custom code for progress is starting
                }

                override fun onStopTrackingTouch(seek: SeekBar?) {
                    //write custom code for progress is stopped
                }
            })
        }
}


