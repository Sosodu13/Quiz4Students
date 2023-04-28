package com.example.quizapp.model.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    indices = [ Index(value = ["id"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = Concept::class,
            parentColumns = ["id"],
            childColumns = ["concept"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Theme::class,
            parentColumns = ["id"],
            childColumns = ["theme"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ConceptTheme(@PrimaryKey(autoGenerate = true) var id:Long? = null,
                       val concept : Long,
                       val theme : Long) : Serializable {
}
