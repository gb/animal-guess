package domain

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.assertEquals
import org.junit.Test
import adapter.MockAdapter

class AnimalTest extends AssertionsForJUnit {
  
	private val dog = new Animal("Dog")
	private val adapter = new MockAdapter()

    @Test
	def animalQuestionTest() {
		assertEquals("My guess is: Dog! Am I right?", dog.question())		  
	}
    
    @Test
    def animalCorrectAnswerTest() {
    	assertEquals(dog, dog.yes(adapter))
    }
    
    @Test
    def animalWrongAnswerTest() {
    	adapter.recordAnswer("Cat");
    	adapter.recordAnswer("eat mouses")
    	
    	assertEquals(new Characteristic("eat mouses", null, null), dog.no(adapter))
    }
  
}