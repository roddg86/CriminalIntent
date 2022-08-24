package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    /* Доступ к репозиторию в ViewModel */
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    /* Реакция на выбор команд */
    fun addCrime(crime: Crime){
        crimeRepository.addCrime(crime)
    }
}