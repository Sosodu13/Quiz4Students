package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) var id:Long? = null,
    val question: String,
    val feedback: String,
    val validated: Boolean,
    val concept_id: Long,
): Serializable {

}

/*data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctOption: Int
)*/