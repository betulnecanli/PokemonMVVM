package com.betulnecanli.pokemonmvvm.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.betulnecanli.pokemonmvvm.data.remote.responses.Result
import com.betulnecanli.pokemonmvvm.network.PokedexApi
import com.betulnecanli.pokemonmvvm.utils.Constants
import javax.inject.Inject


class PokedexPagingSource @Inject constructor(
    val api : PokedexApi
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
            return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
       return try {
           val responseData = mutableListOf<Result>()
           val offset = params.key ?: Constants.STARTING_PAGE_INDEX
           val response = api.getPokedexList(limit = Constants.SEARCH_SIZE,offset = offset)
           val data = response.body()?.results ?: emptyList()

           responseData.addAll(data)
           LoadResult.Page(
               data = responseData,
               prevKey = if (offset == Constants.STARTING_PAGE_INDEX) null else offset - Constants.SEARCH_SIZE,
               nextKey = if (response.body()?.next == null) null else offset + Constants.SEARCH_SIZE
           )

       }
       catch (e : Exception){
            LoadResult.Error(e)
       }
    }
}