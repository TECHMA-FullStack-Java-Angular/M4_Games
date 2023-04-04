package m4.games;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class Game {

	public static void startGame(JLabel lblAccion, JToggleButton tglbtn) {
		lblAccion.setText("Inicio del juego.");
		
	}

	public static void buttonOff(JToggleButton tglbtn) {
		tglbtn.setEnabled(false);
		
	}

}
