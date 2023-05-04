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

    @Query("SELECT * FROM question left join concept on question.concept_id = concept.id ORDER BY CASE concept.tag WHEN 'Maitrise' THEN 1 WHEN 'Compréhension' THEN 2 WHEN 'Innitiation' THEN 3 WHEN 'Non commencé' THEN 4 END DESC,random() DESC LIMIT 10")
    fun getWithoutFilterHome() : List<Question>

    @Query("SELECT * FROM question left join concept on question.concept_id = concept.id ORDER BY CASE concept.tag WHEN 'Non commencé' THEN 1 WHEN 'Innitiation' THEN 2 WHEN 'Compréhension' THEN 3 WHEN 'Maitrise' THEN 4 END DESC,random() DESC LIMIT 10")
    fun getWithoutFilterConcept() : List<Question>

    @Query("SELECT * FROM question left join concept on question.concept_id = concept.id ORDER BY CASE concept.tag WHEN 'Non commencé' THEN 1 WHEN 'Innitiation' THEN 2 WHEN 'Compréhension' THEN 3 WHEN 'Maitrise' THEN 4 END DESC,random() DESC LIMIT 10")
    fun getWithoutFilterCours() : List<Question>

    @Query("SELECT * FROM cours co LEFT JOIN themecours tc ON co.id = tc.cours LEFT JOIN theme t ON tc.theme = t.id LEFT JOIN concepttheme ct ON t.id = ct.theme LEFT JOIN concept c ON ct.concept = c.id LEFT JOIN question q ON c.id = q.concept_id WHERE co.id=:param ORDER BY random() LIMIT 10")
    fun getQuestionsByCoursId(param:Long?) : List<Question>

    @Query("SELECT * FROM question WHERE concept_id in (:param) ORDER BY random() LIMIT 10")
    fun getQuestionsByConceptId(param:String?) : List<Question>

    @Query("SELECT * FROM question WHERE concept_id in (:param) ORDER BY random() LIMIT 10")
    fun getQuestionsByConceptIdArray(param:Array<Long?>?) : List<Question>

    @Query("Select count(*) from question")
    fun countQuestion(): Int

    @Insert
    fun insertAll(vararg questions: Question)

    @Update
    fun update(question: Question)
}