package com.blackcows.butakaeyak.ui.take

import com.blackcows.butakaeyak.domain.take.GetTodayMedicineUseCase
import com.blackcows.butakaeyak.ui.example.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.util.date.WeekDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyTakeViewModel @Inject constructor(
    private val getTodayMedicineUseCase: GetTodayMedicineUseCase
) {
    private val _uiState = MutableStateFlow<TakeUiState>(TakeUiState.Init)
    val uiState = _uiState.asStateFlow()

    fun loadTodayMedicines(dayWeekDay: WeekDay) {
        getTodayMedicineUseCase.invoke(dayWeekDay) { medicineAtTimes ->
            if(medicineAtTimes.isNotEmpty()) {
                _uiState.value = TakeUiState.GetTodayMedicinesSuccess(medicineAtTimes)
            } else {
                _uiState.value = TakeUiState.Failure
            }
        }
    }


}