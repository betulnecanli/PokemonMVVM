package com.betulnecanli.pokemonmvvm.ui.list

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
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


        setupMenu()

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


    private fun setupMenu(){
        (requireActivity() as MenuHost).addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                val inflater = menuInflater
                inflater.inflate(R.menu.search_menu, menu)

                val searchItem = menu?.findItem(R.id.search)
                val searchView = searchItem?.actionView as SearchView

                val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
                searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                         if(query != null){
                        //                    binding.recyclerView.scrollToPosition(0)
                        //                    viewModel.searchCharacter(query)
                        //                    binding.charSearchView.clearFocus()
                        //                    filterButtonClicked = false
                                       }
                                      return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                          if(newText != null){
                        //                    binding.recyclerView.scrollToPosition(0)
                        //                    viewModel.searchCharacter(newText)
                        //                    filterButtonClicked = false
                        //
                                       }
                        return true
                    }

                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.search -> {
                        // clearCompletedTasks()
                        true
                    }
                    else -> false
                }
            }



        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }



}