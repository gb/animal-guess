package adapter

import javax.swing.JOptionPane
import domain.Questionable

class SwingAdapter extends Object with UIAdapter {
  
  def makeQuestion(questionable: Questionable) : Boolean =
    JOptionPane.showConfirmDialog(null, questionable.question(), GAME_NAME, JOptionPane.YES_NO_OPTION) == 0

	def makeTextQuestion(question: String) =
    JOptionPane.showInputDialog(question)
	
	def displayMessage(message : String) =
    JOptionPane.showMessageDialog(null, message, GAME_NAME, JOptionPane.PLAIN_MESSAGE)

}