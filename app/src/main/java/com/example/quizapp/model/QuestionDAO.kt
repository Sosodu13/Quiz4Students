package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quizapp.model.data.Question

@Dao
interface QuestionDAO {
    @Query("SELECT * FROM question ORDER BY random() LIMIT 10")
    fun getAll() : List<Question>

    @Query("SELECT * FROM question \n" +
            "left join concept on question.concept_id = concept.id \n" +
            "ORDER BY \n" +
            "CASE \n" +
            "WHEN concept.tag = 'Non commencé' \n" +
            "THEN 1 \n" +
            "WHEN concept.tag = 'Oublié' \n" +
            "THEN 1 \n" +
            "WHEN concept.tag = 'Initiation' \n" +
            "THEN 2 \n" +
            "WHEN concept.tag = 'Compréhension' \n" +
            "THEN 3 \n" +
            "WHEN concept.tag = 'Maîtrise' \n" +
            "THEN 4 END ASC, random() \n" +
            "LIMIT 10")
    fun getWithoutFilter() : List<Question>


    @Query("SELECT * FROM cours co LEFT JOIN themecours tc ON co.id = tc.cours LEFT JOIN theme t ON tc.theme = t.id LEFT JOIN concepttheme ct ON t.id = ct.theme LEFT JOIN concept c ON ct.concept = c.id LEFT JOIN question q ON c.id = q.concept_id WHERE co.id=:param ORDER BY CASE WHEN c.tag = 'Non commencé' THEN 1 WHEN c.tag = 'Oublié' THEN 2 WHEN c.tag = 'Initiation' THEN 3 WHEN c.tag = 'Compréhension' THEN 4 WHEN c.tag = 'Maitrise' THEN 5 END ASC, random() LIMIT 10")
    fun getQuestionsByCoursId(param:Long?) : List<Question>

    @Query("SELECT * FROM question WHERE concept_id in (:param) ORDER BY random() LIMIT 10")
    fun getQuestionsByConceptId(param:String?) : List<Question>

    @Query("SELECT * FROM question left join concept on question.concept_id = concept.id WHERE concept_id in (:param) ORDER BY CASE WHEN concept.tag = 'Non commencé' THEN 1 WHEN concept.tag = 'Oublié' THEN 2 WHEN concept.tag = 'Initiation' THEN 3 WHEN concept.tag = 'Compréhension' THEN 4 WHEN concept.tag = 'Maitrise' THEN 5 END ASC, random() LIMIT 10")
    fun getQuestionsByConceptIdArray(param:Array<Long?>?) : List<Question>

    @Query("Select count(*) from question")
    fun countQuestion(): Int

    @Insert
    fun insertAll(vararg questions: Question)

    @Update
    fun update(question: Question)
}