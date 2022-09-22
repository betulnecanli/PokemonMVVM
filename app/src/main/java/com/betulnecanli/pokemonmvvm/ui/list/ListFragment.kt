package com.betulnecanli.pokemonmvvm.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.betulnecanli.pokemonmvvm.R
import com.betulnecanli.pokemonmvvm.databinding.FragmentListBinding
import com.betulnecanli.pokemonmvvm.ui.adapter.PokedexListPagingAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {


    private lateinit var binding : FragmentListBinding
    private lateinit var mAdapter : PokedexListPagingAdapter
    private val viewModel : ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListBinding.bind(view)

        mAdapter = PokedexListPagingAdapter()
        binding.pokedexRecyc.apply {
            adapter = mAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

       viewModel.pokedexList.observe(viewLifecycleOwner){
           mAdapter.submitData(viewLifecycleOwner.lifecycle,it)


       }
    }


}