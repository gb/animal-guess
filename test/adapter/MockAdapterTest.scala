package adapter

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.assertEquals
import org.junit.Test
import domain.Animal

class MockAdapterTest extends AssertionsForJUnit {
  
	private val adapter = new MockAdapter()

    @Test
	def recordAnswersTest() {
		val answer = "The answer is 42!"
		
		adapter.recordAnswer(answer);
		assertEquals(1, adapter.answers.length);
		assertEquals(answer, adapter.answers.dequeue())
	}
	
	@Test
	def displayMessageTest() {
		var message = "Hello World, Scala rocks!"
		
		adapter.displayMessage(message);
		assertEquals(1, adapter.log.length)
		assertEquals(message, adapter.log.dequeue())
	}
	
	@Test
	def makeQuestionTest() {
		adapter.recordAnswer(true)
		assertEquals(true, adapter.makeQuestion(new Animal("Shark")))
	}
	
	@Test
	def makeTextQuestionTest() {
		adapter.recordAnswer("42!");
		assertEquals("42!", adapter.makeTextQuestion("Answer?"))
	}
	
	@Test
	def resetLogTest() {	
		adapter.displayMessage("log it")
		adapter.displayMessage("log again")
		assertEquals(2, adapter.log.length)
		
		adapter.resetLog()
		assertEquals(0, adapter.log.length)
	}
	

}