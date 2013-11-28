package game

import org.junit.Assert.assertEquals
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import adapter.MockAdapter
import domain.Animal
import domain.Characteristic

class GameTest extends AssertionsForJUnit {
  
  	@Test
  	def correctAnswerInTheFirstAttempOnTheYesFlow() {
  		adapter.recordAnswer(YES)
  		adapter.recordAnswer(YES)
  		game start
  		
  		theThoughtAnimal("Live in the Water")
  		correctAnswer
  		
  		isTheAnimal("Shark")
  		correctAnswer

  		machineWins
  	}
  	
  	@Test
  	def correctAnswerInTheFirstAttempOnTheNoFlow() {
  		adapter.recordAnswer(NO)
  		adapter.recordAnswer(YES)
  		game start
  		
  		theThoughtAnimal("Live in the Water")
  		wrongAnswer
  		
  		isTheAnimal("Monkey")
  		correctAnswer
  		
  		machineWins
  	}
  	
  	@Test
  	def machineLearningOnTheYesFlow() {
  		adapter.recordAnswer(YES)
  		adapter.recordAnswer(NO)
  		adapter.recordAnswer("Fish")
  		adapter.recordAnswer("is ate by Humans")
  		game start
  		
  		adapter resetLog
  		
  		adapter.recordAnswer(YES)
  		adapter.recordAnswer(YES)
  		adapter.recordAnswer(YES)
  		game start
  		
  		theThoughtAnimal("Live in the Water")
  		correctAnswer
  		
  		theThoughtAnimal("is ate by Humans")
  		correctAnswer
  		
  		isTheAnimal("Fish")
  		correctAnswer
  		
  		machineWins
  	}
  	
  	@Test
  	def machineLearningOnTheNoFlow() {
  		adapter.recordAnswer(NO)
  		adapter.recordAnswer(NO)
  		adapter.recordAnswer("Dog")
  		adapter.recordAnswer("Bark")
  		game start
  		
  		adapter resetLog
  		
  		adapter.recordAnswer(NO)
  		adapter.recordAnswer(YES)
  		adapter.recordAnswer(YES)
  		game start
  		
  		theThoughtAnimal("Live in the Water")
  		wrongAnswer
  		
  		theThoughtAnimal("Bark")
  		correctAnswer
  		
  		isTheAnimal("Dog")
  		correctAnswer
  		
  		machineWins
  	}
  	
  	def theThoughtAnimal(characteristic: String) = 
  		assertEquals(new Characteristic(characteristic, null, null), adapter dequeue)
  	
  	def isTheAnimal(animal: String) = assertEquals(new Animal(animal), adapter dequeue)
  	def correctAnswer() = assertEquals(true, adapter dequeue)
  	def wrongAnswer() = assertEquals(false, adapter dequeue)
  	def machineWins() = assertEquals("I knew it all along! :-)", adapter dequeue)
  	
  	private val YES = true
  	private val NO = false
  	
  	private val adapter = new MockAdapter()
  	private val game = new AnimalGuess(adapter)

}