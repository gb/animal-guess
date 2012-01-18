package domain

import adapter.UIAdapter

abstract class Questionable(val label: String) {
  
	protected var answer : Boolean = false
  
	def question() : String
	def yes(adapter: UIAdapter) : Questionable
	def no(adapter: UIAdapter) : Questionable
	
	def makeQuestion(adapter: UIAdapter) = {
		answer = adapter.makeQuestion(this)
		if (answer) yes(adapter) else no(adapter)
	}
	
	override def toString() = getClass().getSimpleName() + " : " + label
	
	override def equals(obj: Any) = 
		obj.getClass() == getClass() && obj.asInstanceOf[Questionable].label == label
  
}