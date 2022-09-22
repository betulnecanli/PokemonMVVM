package com.betulnecanli.pokemonmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.betulnecanli.pokemonmvvm.data.remote.responses.Result
import com.betulnecanli.pokemonmvvm.databinding.PokeItemBinding
import com.betulnecanli.pokemonmvvm.utils.getImageOfPoke

class PokedexListPagingAdapter : PagingDataAdapter<Result, PokedexListPagingAdapter.PokedexViewHolder>(diffCallback = diffCallBack)  {


    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
               return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }
    inner class PokedexViewHolder(val binding : PokeItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(result: Result){
            binding.apply {
                characterName.text=result.name
                val imgLink = result.url.getImageOfPoke()
                characterImg.load(imgLink){
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }




    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
       val currentItem = getItem(position)
        if(currentItem!= null){
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        return PokedexViewHolder(
                PokeItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                )
    }
}