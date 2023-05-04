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

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param AND  q.watched = 1")
    fun getCountWatchedQuestion(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param")
    fun getCountQuestionByConceptd(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param AND q.validated = 1")
    fun getCountQuestionValidated(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM concept WHERE tag =:param")
    fun getSumByTag(param:String?) : Int

    @Update
    fun update(concept: Concept)
}