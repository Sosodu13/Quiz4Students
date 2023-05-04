package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours
import com.example.quizapp.model.data.Question

@Dao
interface ConceptDAO {
    @Query("SELECT * FROM concept")
    fun getAll() : List<Concept>

    @Insert
    fun insertAll(vararg concepts: Concept)

    @Query("SELECT * FROM concept LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int): Concept?

    @Query("SELECT COUNT(*) FROM question q WHERE q.concept_id =:param AND  q.watched = 1")
    fun getCountWatchedQuestion(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q WHERE q.concept_id =:param")
    fun getCountQuestionByConceptd(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q  WHERE q.concept_id =:param AND q.validated = 1")
    fun getCountQuestionValidated(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM concept WHERE tag =:param")
    fun getSumByTag(param:String?) : Int

    @Update
    fun update(concept: Concept)
}