package ru.zhukov.quizbot.db

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime


// Таблица для хранения вопросов
object QuizQuestions : IntIdTable() {
    val questionText = text("question_text")
    val optionA = text("option_a")
    val optionB = text("option_b")
    val optionC = text("option_c")
    val optionD = text("option_d")
    val correctAnswer = char("correct_answer")
}

// Таблица для хранения комнат
object QuizRooms : IntIdTable() {
    val roomName = varchar("room_name", 50).uniqueIndex()
    val currentQuestionId = integer("current_question_id").nullable()
    val startTime = datetime("start_time")
}

// Таблица для участников комнаты
object QuizRoomParticipants : IntIdTable() {
    val roomId = reference("room_id", QuizRooms)
    val userId = long("user_id")
    val score = integer("score").default(0)
    val answered = bool("answered").default(false)
}

// Таблица для результатов комнаты
object QuizRoomResults : IntIdTable() {
    val roomId = reference("room_id", QuizRooms)
    val userId = long("user_id")
    val score = integer("score").default(0)
}
