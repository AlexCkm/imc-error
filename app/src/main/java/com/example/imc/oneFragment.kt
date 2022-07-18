package com.example.imc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.imc.databinding.FragmentOneBinding


class oneFragment : Fragment() {
    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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


