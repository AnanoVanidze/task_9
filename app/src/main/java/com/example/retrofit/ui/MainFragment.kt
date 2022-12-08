package com.example.retrofit.ui


import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.Resource
import com.example.retrofit.databinding.FragmentMainBinding
import com.example.retrofit.model.Item
import com.example.retrofit.viewModel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {


    private val itemViewModel: ItemViewModel by viewModels()
    private lateinit var itemAdapter: ItemAdapter



    override fun start() {
        itemViewModel.getData()
        initRecycler()
        observe()
    }

    private fun observe() {

        itemViewModel.itemsLivedata.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Resource.Success-> {
                    binding.progressBar.isVisible = false

                    itemAdapter.differ.submitList(state.data as MutableList<Item>?)

                }
                is Resource.Error -> {

                    binding.progressBar.isVisible = false

                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading-> {
                    binding.progressBar.isVisible = true

                }
            }

        }

    }


    private fun initRecycler() {

        itemAdapter = ItemAdapter()

        binding.recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }



}