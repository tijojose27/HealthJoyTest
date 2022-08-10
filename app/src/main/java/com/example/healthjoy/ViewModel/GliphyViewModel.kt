package com.example.healthjoy.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthjoy.Model.GliphyModel
import com.example.healthjoy.Model.GliphyResponseModel
import com.example.healthjoy.Services.RetroFiitInstance
import com.example.healthjoy.Util.Constants.Companion.API_KEY
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class GliphyViewModel: ViewModel() {

    val gliphyLiveData : MutableLiveData<List<GliphyResponseModel.GliphyData>> = MutableLiveData()


    fun getGliphySearch(search: String){
        viewModelScope.launch {
            val response = try {
                RetroFiitInstance.api.getSearchGliphys(apiKey = API_KEY, search = search, limit = 10, offset = 0 )
            } catch (e: Exception) {
                Log.e("Exception", "$e")
                return@launch
            }

            if (response.isSuccessful && response.body() !=null ){
                Log.e("GREAT", response.body().toString())
                filterResponse(response)
            }
        }
    }

    fun filterResponse(response: Response<GliphyResponseModel>){
        val data = response.body()?.listData
        if (!data.isNullOrEmpty()){
            val tempList: ArrayList<GliphyResponseModel.GliphyData> = ArrayList()
            for (eachData in data){
                tempList.add(eachData)
            }
            gliphyLiveData.value = tempList
        }
    }


}