package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Cours(
    @PrimaryKey(autoGenerate = true) var id:Long? = null,
    val libel: String,
    val tag: String,
) : Serializable {

}