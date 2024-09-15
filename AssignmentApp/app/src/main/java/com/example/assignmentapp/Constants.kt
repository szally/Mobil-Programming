package com.example.assignmentapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_launcher_foreground,
            "Argentina",
            "Hungary",
            "Austria",
            "USA",
        1)

        questionList.add(question1)

        val question2 = Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_launcher_foreground,
            "Argentina",
            "Hungary",
            "Austria",
            "USA",
            4)

        questionList.add(question2)

        return questionList
    }
}