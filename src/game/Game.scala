package game

import adapter.SwingAdapter
import scala.swing.Button
import scala.swing.MainFrame
import scala.swing.Swing
import scala.swing.BoxPanel
import scala.swing.event.ButtonClicked
import scala.swing.Orientation
import scala.swing.SimpleSwingApplication

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