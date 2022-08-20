package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel:ViewModel() {
    /* Генерирование преступлений */
    val crimes = mutableListOf<Crime>()

    /* запоним список фиктивными данными из 100 обьектов */
    init {
        for (i in 0 until 100){
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }
}