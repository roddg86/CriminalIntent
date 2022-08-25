package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/* Превращаем Crime в сущность */
@Entity
data class Crime(
    /* первичный ключ */
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var suspect: String = ""
){
    val photoFileName
    get() = "IMG_$id.jpg"
}