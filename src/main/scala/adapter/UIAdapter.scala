package adapter

import domain.Questionable

trait UIAdapter {
  
	val GAME_NAME = "Animal Guess"
  
	def makeQuestion(questionable: Questionable) : Boolean

	def makeTextQuestion(question: String) : String

	def displayMessage(message: String)

}