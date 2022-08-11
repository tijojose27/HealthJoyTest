package com.example.healthjoy.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.healthjoy.Model.GliphyResponseModel
import com.example.healthjoy.Services.RetroFiitInstance
import com.example.healthjoy.Util.Constants.Companion.API_KEY
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class GliphyViewModel: ViewModel() {

    val gliphyLiveData : MutableLiveData<List<GliphyResponseModel.GliphyData>> = MutableLiveData()
    val gliphyError : MutableLiveData<Boolean> = MutableLiveData(false)

    fun getGliphySearch(search: String, offset: Int){
        viewModelScope.launch {
            val response = try {
                RetroFiitInstance.api.getSearchGliphys(apiKey = API_KEY, search = search, limit = 10, offset = offset )
            } catch (e: Exception) {
                Log.e("Exception", "$e")
                return@launch
            }

            if (response.isSuccessful && response.body() !=null ){
                filterResponse(response)
            } else {
                gliphyError.value = true
            }
        }
    }

    fun filterResponse(response: Response<GliphyResponseModel>){
        val data = response.body()?.listData
        if (!data.isNullOrEmpty()){
            val tempList: ArrayList<GliphyResponseModel.GliphyData> = ArrayList()
            if (!gliphyLiveData.value.isNullOrEmpty()){
                tempList.addAll(gliphyLiveData.value!!)
            }
            for (eachData in data){
                tempList.add(eachData)
            }
            gliphyLiveData.value = tempList
        } else {
            gliphyLiveData.value = emptyList()
        }
    }

    fun resetError(){
        gliphyError.value = false
    }


}