package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

@Dao
interface CoursDAO {
    @Query("SELECT * FROM cours ORDER BY CASE WHEN cours.tag = 'Non commencé' THEN 1 WHEN cours.tag = 'Initiation' THEN 2 WHEN cours.tag = 'Compréhension' THEN 3 WHEN cours.tag = 'Maitrise' THEN 4 END ASC, random()")
    fun getAll() : List<Cours>

    @Query("SELECT * FROM cours ORDER BY CASE WHEN cours.tag = 'Maitrise' THEN 1 WHEN cours.tag = 'Compréhension' THEN 2 WHEN cours.tag = 'Initiation' THEN 3 WHEN cours.tag = 'Non commencé' THEN 4 END ASC, random()")
    fun getAllHome() : List<Cours>

    @Insert
    fun insertAll(vararg cours: Cours)

    @Query("SELECT * FROM cours LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int): Cours?

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param AND  q.watched = 1")
    fun getCountWatchedQuestion(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param")
    fun getCountQuestionByConceptd(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q LEFT JOIN concept co ON q.concept_id = co.id LEFT JOIN concepttheme ct ON co.id = ct.concept LEFT JOIN theme t ON t.id = ct.theme LEFT JOIN themecours tc ON tc.theme = t.id LEFT JOIN Cours c ON c.id = tc.cours WHERE c.id =:param AND q.validated = 1")
    fun getCountQuestionValidated(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM cours WHERE tag =:param")
    fun getSumByTag(param:String?) : Int

    @Query("SELECT COUNT(*) FROM cours c LEFT JOIN themecours tc ON tc.cours = c.id LEFT JOIN theme t ON t.id = tc.theme LEFT JOIN concepttheme ct ON t.id = ct.theme LEFT JOIN concept co ON ct.concept = co.id WHERE c.id =:param and co.tag = 'Oublié'")
    fun getCountConceptOublie(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM cours c LEFT JOIN themecours tc ON tc.cours = c.id LEFT JOIN theme t ON t.id = tc.theme LEFT JOIN concepttheme ct ON t.id = ct.theme LEFT JOIN concept co ON ct.concept = co.id WHERE c.id =:param")
    fun getCountConcept(param:Long?) : Int

    @Update
    fun update(cours: Cours)
}