package com.betulnecanli.pokemonmvvm.ui.adapter

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.betulnecanli.pokemonmvvm.R
import com.betulnecanli.pokemonmvvm.data.remote.responses.Result
import com.betulnecanli.pokemonmvvm.databinding.PokeItemBinding
import com.betulnecanli.pokemonmvvm.utils.getImageOfPoke
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

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

        var dominantColor: Int = 0

        fun bind(result: Result){
            binding.apply {
                characterName.text=result.name
                val imgLink = result.url.getImageOfPoke()

                /* characterImg.load(imgLink){
                     crossfade(true)
                     crossfade(1000)
                 }*/

                Glide.with(root)
                    .load(imgLink)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .listener(object : RequestListener<Drawable>{
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressCircular.isVisible = false
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                           val drawable = resource as BitmapDrawable
                            val bitmap = drawable.bitmap
                            Palette.Builder(bitmap).generate{
                                it?.let { palette ->
                                    dominantColor = palette.getDominantColor(
                                        ContextCompat.getColor(
                                            root.context,
                                            R.color.white
                                        )
                                    )
                                    characterImg.setBackgroundColor(dominantColor)
                                }
                            }
                            progressCircular.isVisible = false
                            return false
                        }

                    })
                    .into(characterImg)


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