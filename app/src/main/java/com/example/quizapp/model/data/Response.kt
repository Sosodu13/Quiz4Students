package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Response(
    @PrimaryKey(autoGenerate = true) var id:Long? = null,
    val libel: String,
    val good_response: Boolean,
    val id_question: Long) : Serializable {

    }
