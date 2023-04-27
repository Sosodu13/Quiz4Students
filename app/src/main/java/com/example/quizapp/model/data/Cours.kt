package com.example.quizapp.model.data

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Cours(
    val id: Long? = null,
    val libel: String,
) : Serializable {

}