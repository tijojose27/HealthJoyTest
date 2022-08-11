package com.example.healthjoy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthjoy.Model.GliphyResponseModel
import com.example.healthjoy.R
import com.example.healthjoy.RecyclerView.GlifyAdapter
import com.example.healthjoy.Util.KeyBoardUtil
import com.example.healthjoy.ViewModel.GliphyViewModel
import com.example.healthjoy.databinding.FragmentSecondBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SecondFragment : Fragment() {
    private lateinit var adapter: GlifyAdapter
    lateinit var currGliphyList: List<GliphyResponseModel.GliphyData>

    private val gliphyViewModel by lazy {
        ViewModelProvider(this)[GliphyViewModel::class.java]
    }

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private var offSet = 0
    private var currSearchText = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        setupUI()
        observe()

        return binding.root

    }

    private fun observe() {
        gliphyViewModel.gliphyLiveData.observe(viewLifecycleOwner){ gliphyList ->
            currGliphyList = gliphyList
            adapter.submitList(gliphyList)
            progressBarVisibility(false)
        }

        gliphyViewModel.gliphyError.observe(viewLifecycleOwner) {
            if (it){
                showErrorMessage()
            }
        }
    }

    private fun setupUI() {
        binding.textField.setOnEditorActionListener{ _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    val searchTxt = binding.textField.text.toString()
                    search(searchTxt)

                    KeyBoardUtil.hideKeyboard(requireActivity())
                    true
                }
                else -> false
            }
        }

        adapter = GlifyAdapter(requireContext())
        val layoutmanager = LinearLayoutManager(requireContext())
        binding.gliphyRV.layoutManager = layoutmanager
        binding.gliphyRV.adapter = adapter

        binding.gliphyRV.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (layoutmanager.findLastCompletelyVisibleItemPosition() == currGliphyList.size -1 ){
                    offSet += 10
                    progressBarVisibility(true)
                    search(currSearchText)
                }
            }
        })


    }

    fun showErrorMessage(){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("ERROR")
            .setMessage("Something went wrong please try again")
            .setNeutralButton(resources.getString(R.string.ok)) { dialog, which ->
                gliphyViewModel.resetError()
                dialog.dismiss()
            }
            .show()
        progressBarVisibility(false)
    }

    fun progressBarVisibility(isShown: Boolean){
        if (isShown)
            binding.progressCircular.visibility = View.VISIBLE
        else
            binding.progressCircular.visibility = View.INVISIBLE
    }


    fun search(searchTxt: String) {
        progressBarVisibility(true)
        if (searchTxt.isNotEmpty()) {
            currSearchText = searchTxt
            gliphyViewModel.getGliphySearch(searchTxt, offSet)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}