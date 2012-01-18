package domain

import adapter.UIAdapter

abstract class Questionable(val label: String) {
  
	protected var answer : Boolean = false
  
	def makeQuestion(adapter: UIAdapter) = {
		answer = adapter.makeQuestion(this)
		if (answer) yes(adapter) else no(adapter)
	}

	def question() : String
	
	def yes(adapter: UIAdapter) : Questionable

	def no(adapter: UIAdapter) : Questionable
	
	override def toString() = getClass().getSimpleName() + " : " + label
	
	override def equals(obj: Any) = 
		obj.getClass() == getClass() && obj.asInstanceOf[Questionable].label == label
  
}