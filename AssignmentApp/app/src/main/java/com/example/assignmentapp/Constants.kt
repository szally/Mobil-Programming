package com.example.assignmentapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
            "What is the largest country in the world by land area?",
            R.drawable.world_map,
            "China",
            "Canada",
            "Russia",
            "United States",
            3)

        val question2 = Question(2,
            "What is the tallest mountain in the world?",
            R.drawable.la_paz_skyline,
            "Lhotse",
            "K2",
            "Kangchenjunga",
            "Mount Everest",
            4)

        val question3 = Question(3,
            "What is the largest planet in our solar system?",
            R.drawable.planet_collage_to_scale,
            "Earth",
            "Jupiter",
            "Saturn",
            "Mars",
            2)

        val question4 = Question(4,
            "Who painted the Mona Lisa?",
            R.drawable.mona_lisa,
            "Leonardo da Vinci",
            "Michelangelo",
            "Pablo Picasso",
            "Vincent van Gogh",
            1)

        val question5 = Question(5,
            "What is the capital city of Australia?",
            R.drawable.flag_of_australia,
            "Melbourne",
            "Sydney",
            "Canberra",
            "Brisbane",
            3)

        val question6 = Question(6,
            "What is the chemical symbol for gold?",
            R.drawable.golden_crown,
            "Cu",
            "Ag",
            "Fe",
            "Au",
            4)

        val question7 = Question(7,
            "Which animal is the fastest land animal on Earth?",
            R.drawable.golden_retriever,
            "Lion",
            "Cheetah",
            "Gazelle",
            "Ostrich",
            2)

        val question8 = Question(8,
            "Who wrote the play Romeo and Juliet?",
            R.drawable.romeo_and_juliet_brown,
            "William Shakespeare",
            "Charles Dickens",
            "Jane Austen",
            "Mark Twain",
            1)

        questionList.addAll(listOf(question1, question2, question3, question4, question5, question6, question7, question8))
        return questionList
    }
}