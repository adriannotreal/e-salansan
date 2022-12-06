package com.adrianmarino.e_salansan

object ConstantsQuestionsChapter1 {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions():ArrayList<QuestionsChapter1Challenge>{
        val questionsList = ArrayList<QuestionsChapter1Challenge>()

        val que1 = QuestionsChapter1Challenge(1,"It is the programmatic way of storing data so that data can be used efficiently.",
        "Algorithm","Data Structures", "Data", "Data Management", 2)
        questionsList.add(que1)

        val que2 = QuestionsChapter1Challenge(2,"It is sometimes called an abstract data type",
            "Interface","Array", "Object", "Implementation", 1)
        questionsList.add(que2)

        val que3 = QuestionsChapter1Challenge(3,"It provides the definition of the algorithms used in the operations of the data structure.",
            "Interface","Array", "Object", "Implementation", 4)
        questionsList.add(que3)

        val que4 = QuestionsChapter1Challenge(4,"A scenario wherein a particular data structure operation takes maximum amount of time.",
            "Brief Case","Best Case", "Average Case", "Worst Case", 4)
        questionsList.add(que4)

        val que5 = QuestionsChapter1Challenge(5,"It is one of the common problems that Data Structures can solve. It involves finding an element in a myriad of records.",
            "World Peace","Multiple Requests", "Data Search", "Processor Speed", 3)
        questionsList.add(que5)

        val que6 = QuestionsChapter1Challenge(6,"One of the common problems that tackles the simultaneous delivery of data through a server.",
            "Racism","Multiple Requests", "Data Search", "Processor Speed", 2)
        questionsList.add(que6)

        val que7 = QuestionsChapter1Challenge(7,"One of the three common problems that a device encounters in dealing with high amounts of data.",
            "Financial Problem","Multiple Requests", "Data Search", "Processor Speed", 4)
        questionsList.add(que7)

        val que8 = QuestionsChapter1Challenge(8,"One of its example will be finding the search element in the first location in a linear search.",
            "Civil Case","Best Case", "Average Case", "Worst Case", 2)
        questionsList.add(que8)

        val que9 = QuestionsChapter1Challenge(9,"This depicts the average execution time of an operation in Data Structure.",
            "Criminal Case","Best Case", "Average Case", "Worst Case", 3)
        questionsList.add(que9)

        val que10 = QuestionsChapter1Challenge(10,"It refers to the characteristic of data structure that deals with the memory usage of an operation.",
            "Space Complexity","Correctness", "Time Complexity", "Data Representation", 1)
        questionsList.add(que10)

        return questionsList
    }
}