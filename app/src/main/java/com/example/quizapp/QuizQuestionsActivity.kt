package com.example.quizapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.model.QuizDatabase
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Question
import com.example.quizapp.model.data.Response
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import java.util.*
import kotlin.collections.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: Array<Question>? = null
    private var mResponseList: List<Response>? = null
    private var mSelectedOptionPosition: Int = 0
    private var goodResponse: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val db = QuizDatabase.getDatabase(this)

        mQuestionList = intent.getSerializableExtra("Questions") as Array<Question> ?: null
        findViewById<ProgressBar>(R.id.progressBar).max = mQuestionList!!.size

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        tv_option_five.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val db = QuizDatabase.getDatabase(this)

        val question = mQuestionList!!.get(mCurrentPosition - 1)

        val responses = db.responsedao().getResponsesByIdQuestion(question.id!!)
        mResponseList = responses

        defaultOptionsView()

        findViewById<LinearLayout>(R.id.ll_good_answer).visibility= View.GONE
        findViewById<LinearLayout>(R.id.ll_response).visibility= View.VISIBLE

        btn_submit.text = "Répondre"

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question.question

        tv_option_one.text = responses[0].libel
        tv_option_two.text = responses[1].libel
        tv_option_three.text = responses[2].libel
        tv_option_four.text = responses[3].libel
        tv_option_five.text = responses[4].libel
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)
        options.add(4, tv_option_five)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(v: View?) {
        val db = QuizDatabase.getDatabase(this)
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.tv_option_five -> {
                selectedOptionView(tv_option_five, 5)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    if (btn_submit.text == "Répondre") {
                        val dlg = AlertDialog.Builder(this)

                        dlg.setTitle("Attention !")
                        dlg.setMessage("Il faut saisir une réponse !")
                        dlg.setPositiveButton(R.string.close) { dialog, _ ->
                            dialog.dismiss()
                        }
                        dlg.show()
                    } else {
                        mCurrentPosition++
                    }
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            if (btn_submit.text == "Terminer") {
                                val conceptList = db.conceptdao().getAll()

                                conceptList.forEach {
                                    val total_watched = db.conceptdao().getCountWatchedQuestion(it.id)
                                    var concept_watched = false
                                    if (total_watched > 0) {
                                        concept_watched = true
                                    }

                                    if(concept_watched){
                                        val total_question = db.conceptdao().getCountQuestionByConceptd(it.id)
                                        val total_validated = db.conceptdao().getCountQuestionValidated(it.id)
                                        val purcentage = (total_validated * 100) / total_question

                                        if (purcentage < 50){
                                            it.tag = "Initiation"
                                        } else if (purcentage >= 50 && purcentage < 70){
                                            it.tag = "Compréhension"
                                        } else if (purcentage >= 70) {
                                            it.tag = "Maîtrise"
                                        }
                                        //update tag
                                        db.conceptdao().update(it)
                                    }
                                }

                                val coursList = db.coursdao().getAll()

                                coursList.forEach {
                                    val total_watched = db.coursdao().getCountWatchedQuestion(it.id)
                                    var cours_watched = false
                                    if (total_watched > 0) {
                                        cours_watched = true
                                    }

                                    if(cours_watched){
                                        val total_question = db.coursdao().getCountQuestionByConceptd(it.id)
                                        val total_validated = db.coursdao().getCountQuestionValidated(it.id)
                                        val purcentage = (total_validated * 100) / total_question

                                        if (purcentage < 50){
                                            it.tag = "Initiation"
                                        } else if (purcentage >= 50 && purcentage < 70){
                                            it.tag = "Compréhension"
                                        } else if (purcentage >= 70) {
                                            it.tag = "Maîtrise"
                                        }
                                        //update tag
                                        db.coursdao().update(it)
                                    }
                                }

                                Toast.makeText(
                                    this,
                                    "Vous avez terminé ce quizz !", Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                findViewById<LinearLayout>(R.id.ll_response).visibility = View.GONE
                                findViewById<LinearLayout>(R.id.ll_question).visibility = View.GONE
                                findViewById<LinearLayout>(R.id.ll_good_answer).visibility =
                                    View.GONE
                                findViewById<LinearLayout>(R.id.ll_resume).visibility = View.VISIBLE
                                btn_submit.text = "Terminer"
                            }

                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    val response = mResponseList?.get(mSelectedOptionPosition - 1)

                    for (res in mResponseList!!){
                        if (res.good_response)
                        {
                            tv_good_response.text = res.libel
                        }
                    }


                    question?.watched = true;
                    System.out.println(Date().time)
                    question?.date_response = Date().time
                    System.out.println(question?.date_response)
                    if (response!!.good_response) {
                        question?.validated = true
                        goodResponse++
                        findViewById<TextView>(R.id.tv_title_feedback).text = "Bonne réponse"
                        findViewById<TextView>(R.id.tv_title_feedback).setTextColor(
                            getResources().getColor(
                                R.color.colorGoodResponse
                            )
                        )
                    } else {
                        question?.validated = false
                        findViewById<TextView>(R.id.tv_title_feedback).text = "Mauvaise réponse"
                        findViewById<TextView>(R.id.tv_title_feedback).setTextColor(
                            getResources().getColor(
                                R.color.colorBadResponse
                            )
                        )
                    }
                    db.questiondao().update(question!!)

                    findViewById<LinearLayout>(R.id.ll_response).visibility = View.GONE
                    findViewById<LinearLayout>(R.id.ll_good_answer).visibility = View.VISIBLE

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "Résumé"
                        if (goodResponse != 0) {
                            findViewById<TextView>(R.id.tv_pourcentage).text =
                                "Quizz correcte à " + (goodResponse * 100 / mQuestionList!!.size) + "%"
                        } else {
                            findViewById<TextView>(R.id.tv_pourcentage).text = "Quizz correcte à 0%"
                        }
                        findViewById<TextView>(R.id.tv_total_good_response).text =
                            goodResponse.toString() + " bonnes réponses"
                        findViewById<TextView>(R.id.tv_total_bad_response).text =
                            (mQuestionList!!.size - goodResponse).toString() + " mauvaises réponses"
                    } else {
                        btn_submit.text = "Prochaine question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            5 -> {
                tv_option_five.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}