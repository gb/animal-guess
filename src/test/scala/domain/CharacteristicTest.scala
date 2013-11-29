package domain

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.assertEquals
import org.junit.Test
import adapter.MockAdapter

class CharacteristicTest extends AssertionsForJUnit {
  
    private val mammal = new Characteristic("is Mammal", new Animal("Dog"), new Animal("Bird"))

    @Test
	def characteristicQuestionTest() {
		assertEquals("The animal thought: is Mammal ?", mammal.question)		  
	}

}
