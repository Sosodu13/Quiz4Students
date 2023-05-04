package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Concept(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    val libel: String,
    var tag: String,
): Serializable {

}
