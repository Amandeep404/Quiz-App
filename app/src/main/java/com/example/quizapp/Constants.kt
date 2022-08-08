package com.example.quizapp

object Constants {

    val User_Name : String ="userName"
    val Total_Questions : String = "totalQuestions"
    val Correct_Answer : String ="Correct_Answer"

    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 =Question(
            1, "The Battle of Plassey was fought in", (R.drawable.battle_of_plassey),
            "1757",
            "1782",
            "1748",
            "1764",
            1
        )
        questionList.add(q1)

        val q2 =Question(
            1,
            "The territory of Porus who offered strong resistance to Alexander was situated between the rivers of",
            (R.drawable.porus),
            "Sutlej and Beas",
            "Jhelum and Chenab",
            "Ravi and Chenab",
            "Ganga and Yamuna",
            2
        )
        questionList.add(q2)

        val q3 =Question(
            1,
            "Tripitaka's are sacred books of", (R.drawable.tipitaka),
            "Buddhists",
            "Hindus",
            "Jains",
            "None of the above",
            1
        )
        questionList.add(q3)

        val q4 =Question(
            1,
            " In which year did the British passenger liner Titanic sink in the North Atlantic Ocean, which made more than 1,500 people die?",
            (R.drawable.titanic),
            " 1901",
            " 1912",
            "1923",
            "None of the above",
            2
        )
        questionList.add(q4)

        val q5 =Question(
            1,
            "What is the name of the first U.S. President on the right of this picture?",
            (R.drawable.abrahamlincoln),
            "George Washington",
            "Abraham Lincoln",
            "Thomas Jefferson",
            "Chacha Chaudhry",
            2
        )
        questionList.add(q5)

        val q6 =Question(
            1,
            "Which country is also known as the ‘Land of Thousand Lakes’",
            (R.drawable.finlandrivers),
            "Iceland",
            "Norway",
            "Finland",
            "Switzerland",
            3
        )
        questionList.add(q6)

        //RETURN
        return questionList
    }
}