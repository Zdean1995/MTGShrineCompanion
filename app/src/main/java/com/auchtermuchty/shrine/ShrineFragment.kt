package com.auchtermuchty.shrine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.auchtermuchty.shrine.databinding.FragmentShrineBinding
import com.auchtermuchty.shrine.model.ShrineViewModel

class ShrineFragment : Fragment() {
    private var binding: FragmentShrineBinding? = null

    private val shrineViewModel: ShrineViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentShrineBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = shrineViewModel
            shrineFragment = this@ShrineFragment
        }
    }

    fun tokenChange() {
        if(binding!!.shrineTokenCount.text.toString() != ""){
            binding!!.viewModel!!.tokenCount(binding!!.shrineTokenCount.text.toString())
        } else{
            binding!!.viewModel!!.tokenCount("0")
        }
        binding!!.viewModel!!.titleVisibilityCheck()
    }

    fun reset(){
        binding!!.shrineTokenCount.setText("0")
        binding!!.viewModel!!.resetShrines()
    }


    fun tokenPlus() {
        val newValue = binding!!.shrineTokenCount.text.toString().toInt() + 1
        binding!!.shrineTokenCount.setText(newValue.toString())
        tokenChange()
    }

    fun tokenMinus() {
        var newValue = binding!!.shrineTokenCount.text.toString().toInt()
        if(newValue > 0){
            newValue--
            binding!!.shrineTokenCount.setText(newValue.toString())
            tokenChange()
        }
    }


    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}