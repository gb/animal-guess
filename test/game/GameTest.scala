package game

import org.junit.Assert.assertEquals
import org.scalatest.junit.AssertionsForJUnit
import adapter.MockAdapter
import org.junit.Test
import domain.Characteristic
import domain.Animal

class GameTest extends AssertionsForJUnit {
  
  	private val adapter = new MockAdapter()
  	private val game = new AnimalGuess(adapter)
  	
  	@Test
  	def correctAnswerInTheFirstAttempOnTheYesFlow() {
  		adapter.recordAnswer(CORRECT_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		game.start()
  		
  		theThoughtAnimal("Live in the Water");
  		correctAnswer()
  		
  		isTheAnimal("Shark")
  		correctAnswer()
  		
  		machineWins()
  	}
  	
  	@Test
  	def correctAnswerInTheFirstAttempOnTheNoFlow() {
  		adapter.recordAnswer(WRONG_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		game.start()
  		
  		theThoughtAnimal("Live in the Water");
  		wrongAnswer()
  		
  		isTheAnimal("Monkey")
  		correctAnswer()
  		
  		machineWins()
  	}
  	
  	@Test
  	def machineLearningOnTheYesFlow() {
  		adapter.recordAnswer(CORRECT_ANSWER)
  		adapter.recordAnswer(WRONG_ANSWER)
  		adapter.recordAnswer("Fish")
  		adapter.recordAnswer("is ate by Humans")
  		game.start()
  		
  		adapter.resetLog()
  		
  		adapter.recordAnswer(CORRECT_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		game.start()
  		
  		theThoughtAnimal("Live in the Water")
  		correctAnswer()
  		
  		theThoughtAnimal("is ate by Humans")
  		correctAnswer()
  		
  		isTheAnimal("Fish")
  		correctAnswer()
  		
  		machineWins()
  	}
  	
  	@Test
  	def machineLearningOnTheNoFlow() {
  		adapter.recordAnswer(WRONG_ANSWER)
  		adapter.recordAnswer(WRONG_ANSWER)
  		adapter.recordAnswer("Dog")
  		adapter.recordAnswer("Bark")
  		game.start()
  		
  		adapter.resetLog()
  		
  		adapter.recordAnswer(WRONG_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		adapter.recordAnswer(CORRECT_ANSWER)
  		game.start()
  		
  		theThoughtAnimal("Live in the Water")
  		wrongAnswer()
  		
  		theThoughtAnimal("Bark")
  		correctAnswer()
  		
  		isTheAnimal("Dog")
  		correctAnswer()
  		
  		machineWins()
  	}
  	
  	def theThoughtAnimal(characteristic: String) = 
  		assertEquals(new Characteristic(characteristic, null, null), adapter.log.dequeue())
  	
  	def isTheAnimal(animal: String) = assertEquals(new Animal(animal), adapter.log.dequeue())
  	def correctAnswer() = assertEquals(true, adapter.log.dequeue())
  	def wrongAnswer() = assertEquals(false, adapter.log.dequeue())
  	def machineWins() = assertEquals("I knew it all along! :-)", adapter.log.dequeue())
  	
  	private val CORRECT_ANSWER = true
  	private val WRONG_ANSWER = false

}