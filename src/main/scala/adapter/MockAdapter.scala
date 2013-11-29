package adapter

import scala.collection.mutable.Queue
import java.util.LinkedList
import scala.collection.mutable.ArrayStack
import domain.Questionable
import scala.reflect.ClassTag

class MockAdapter extends UIAdapter {
  
	val answers, log : Queue[Any] = new Queue

  	def makeQuestion(questionable: Questionable) : Boolean = {
  		displayCurrentAskAndAnswer(questionable)
  		answers.dequeue().asInstanceOf[Boolean]
  	}

	def makeTextQuestion(question: String) : String = {
  		displayCurrentAskAndAnswer(question)
  		answers.dequeue().asInstanceOf[String]
	}
	
	private def displayCurrentAskAndAnswer(question: Any) {
  		log.enqueue(question)
  		log.enqueue(answers front)
	}

	def displayMessage(message: String) = log.enqueue(message)
	
	def recordAnswer(answer: Any) = answers.enqueue(answer)
	
	def dequeue = log dequeue
	
	def resetLog = log clear
  
}
