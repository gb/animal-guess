package domain

import scala.Boolean._
import adapter.UIAdapter

class Animal(override val label : String) extends Questionable(label) {
  
  	override def question() = "My guess is: " + label + "! Am I right?"

	def yes(adapter: UIAdapter) = {	
		adapter.displayMessage("I knew it all along! :-)")
		this
	}

	def no(adapter: UIAdapter) = {
		val animalName = adapter.makeTextQuestion("I Give up! What animal do you have thought?")
		val characteristic = adapter.makeTextQuestion("A(n) " + animalName + " ________ but not a(n) " + label)
		
		new Characteristic(characteristic, new Animal(animalName), this)
	}
	
}