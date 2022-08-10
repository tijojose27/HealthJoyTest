package com.example.healthjoy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthjoy.RecyclerView.GlifyAdapter
import com.example.healthjoy.ViewModel.GliphyViewModel
import com.example.healthjoy.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var adapter: GlifyAdapter

    private val gliphyViewModel by lazy {
        ViewModelProvider(this)[GliphyViewModel::class.java]
    }

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root


        setupUI()
        observe()

    }

    private fun observe() {
        gliphyViewModel.gliphyLiveData.observe(viewLifecycleOwner){ gliphyList ->
            if (!gliphyList.isNullOrEmpty()){
                adapter.submitList(gliphyList)
            }
        }
    }

    private fun setupUI() {
        binding.textInputEditText.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ) {
                gliphyViewModel.getGliphySearch("cat")
                return@OnEditorActionListener true
            }
            false
        })

        adapter = GlifyAdapter(requireContext())
        binding.gliphyRV.layoutManager = LinearLayoutManager(requireContext())
        binding.gliphyRV.adapter = adapter


    }


    fun search(){
        gliphyViewModel.getGliphySearch("cat")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}