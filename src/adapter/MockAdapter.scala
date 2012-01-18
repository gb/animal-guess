package adapter

import scala.collection.mutable.Queue
import java.util.LinkedList
import scala.collection.mutable.ArrayStack
import domain.Questionable

class MockAdapter extends UIAdapter {
  
	val answers : Queue[_ >: Any] = new Queue();
	val log : Queue[_ >: Any] = new Queue();

  	def makeQuestion(questionable: Questionable) : Boolean = {
  		displayCurrentAskAndAnswer(questionable)
  		return answers.dequeue().asInstanceOf[Boolean]
  	}

	def makeTextQuestion(question: String) : String = {
  		displayCurrentAskAndAnswer(question)
  		answers.dequeue().asInstanceOf[String];
	}
	
	private def displayCurrentAskAndAnswer(question: Object) {
	    log += question
	    log += answers.first
	}

	def displayMessage(message: String) = log += message;
	
	def recordAnswer(answer: Any) = answers += answer;
	
	def resetLog() = log.clear()
  
}