package com.doodleblue.application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.doodleblue.application.model.DeveloperModel
import com.doodleblue.application.repository.DeveloperRepository


class DeveloperViewModel(application: Application) : AndroidViewModel(application) {
    private val mDeveloperRepository: DeveloperRepository

    val allDeveloper: LiveData<List<DeveloperModel>>
        get() = mDeveloperRepository.getMutableLiveData()

    init {
        mDeveloperRepository = DeveloperRepository()
    }
}
