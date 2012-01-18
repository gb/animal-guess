package game

import adapter.UIAdapter

import domain.Characteristic
import domain.Animal

class AnimalGuess(val adapter : UIAdapter) {
  
	private val firstQuestion = new Characteristic("Live in the Water", new Animal("Shark"), new Animal("Monkey"))

	def start() = firstQuestion.makeQuestion(adapter)

}