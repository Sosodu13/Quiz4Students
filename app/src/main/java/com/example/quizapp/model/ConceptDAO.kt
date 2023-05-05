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
    @Query("SELECT * FROM concept ORDER BY CASE WHEN concept.tag = 'Non commencé' THEN 1 WHEN concept.tag = 'Oublié' THEN 2 WHEN concept.tag = 'Initiation' THEN 3 WHEN concept.tag = 'Compréhension' THEN 4 WHEN concept.tag = 'Maîtrise' THEN 5 END ASC, random()")
    fun getAll() : List<Concept>

    @Query("SELECT * FROM concept ORDER BY CASE WHEN concept.tag = 'Oublié' THEN 1 WHEN concept.tag = 'Initiation' THEN 2 WHEN concept.tag = 'Compréhension' THEN 3 WHEN concept.tag = 'Maîtrise' THEN 4 WHEN concept.tag = 'Non commencé' THEN 5 END ASC, random()")
    fun getAllHome() : List<Concept>

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

    @Query("SELECT * FROM concept WHERE libel like(:params)")
    fun getConceptsByRecherche(params:String?) : List<Concept>


    @Query("SELECT COUNT(*) FROM question where concept_id =:param AND (question.date_response - strftime('%s', 'now') < 1681547220063)")
    fun getCountQuestionOublie(param:Long?) : Int

    @Update
    fun update(concept: Concept)
}