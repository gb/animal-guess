package game

import java.awt.event.ActionListener
import scala.swing.event.ActionEvent
import adapter.SwingAdapter
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import scala.swing.Button
import scala.swing.SimpleGUIApplication
import scala.swing.MainFrame
import scala.swing.event.EditDone
import scala.swing.FlowPanel
import scala.swing.TextField
import scala.swing.Label
import scala.swing.Swing
import scala.swing.BoxPanel
import scala.swing.event.ButtonClicked
import scala.swing.Orientation
import scala.swing.SimpleSwingApplication
import javax.swing.BorderFactory

object Game extends SimpleSwingApplication {

	private val game = new AnimalGuess(new SwingAdapter());

	game.adapter.displayMessage("Please think of an animal!")

	def top = new MainFrame {
		title = game.adapter.GAME_NAME;
		resizable = false

		val button = new Button {
			text = "Start Game!"
		}

		contents = new BoxPanel(Orientation.Vertical) {
			contents += button
			border = Swing.EmptyBorder(30, 30, 30, 30)
		}

		listenTo(button)
		reactions += {
			case ButtonClicked(b) => game.start();
		}

		this.peer.setLocationRelativeTo(null)
	}

}