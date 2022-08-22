package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    /* Доступ к репозиторию в ViewModel */
    private val crimeRepository = CrimeRepository.get()
    val crimes = crimeRepository.getCrimes()
}