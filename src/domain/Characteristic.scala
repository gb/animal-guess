package domain

import adapter.UIAdapter

class Characteristic(override val label : String, var yes : Questionable, var no : Questionable) extends Questionable(label) {
  
	override def question() = "The animal thought: " + label + " ?"
  
	def yes(adapter: UIAdapter) = {
		yes = yes.makeQuestion(adapter)
		this
	}
	
	def no(adapter: UIAdapter) = {
		no = no.makeQuestion(adapter)
		this
	}
	
}