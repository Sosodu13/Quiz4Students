package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Cours::class,
            parentColumns = ["id"],
            childColumns = ["cours"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Theme::class,
            parentColumns = ["id"],
            childColumns = ["theme"],
            onDelete = ForeignKey.CASCADE
)])
data class Theme_Cours(@PrimaryKey(autoGenerate = true) var id:Long? = null,
                       val cours : Long,
                       val theme : Long) : Serializable {
}

