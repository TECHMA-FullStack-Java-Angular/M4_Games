package m4.games;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import java.util.Pair;

import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textJug1;
	private JTextField textJug2;
	private ButtonGroup jugador1 = new ButtonGroup();
	private ButtonGroup jugador2 = new ButtonGroup();
	private ButtonGroup modalidadJuego = new ButtonGroup();
	private ArrayList<JToggleButton> listaBotones = new ArrayList<JToggleButton>();
	JToggleButton[][] tablero = new JToggleButton[3][3];
	JLabel lblAccion;
	JRadioButton rdbtnCPU_1, rdbtnCPU_2, rdb3fichas, rdbLlenarTablero;

	private int turn = 0;
	boolean llenar_tablero = true;
	

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setTitle("3 en raya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textJug2 = new JTextField();
		textJug2.setColumns(10);
		textJug2.setBounds(505, 309, 96, 20);
		contentPane.add(textJug2);

		textJug1 = new JTextField();
		textJug1.setBounds(517, 170, 96, 20);
		contentPane.add(textJug1);
		textJug1.setColumns(10);

		lblAccion = new JLabel("Introduzca nombres a los jugadores");
		lblAccion.setBounds(427, 99, 226, 14);
		contentPane.add(lblAccion);

		gameBoardGenerator();

		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(inicio_partida);
		btnNuevaPartida.setBounds(506, 425, 119, 23);
		contentPane.add(btnNuevaPartida);

		JLabel lblJugador1 = new JLabel("Jugador 1:");
		lblJugador1.setBounds(427, 137, 88, 14);
		contentPane.add(lblJugador1);

		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(427, 170, 49, 14);
		contentPane.add(lblNombre);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(427, 170, 49, 14);
		contentPane.add(lblNewLabel_1);

		JRadioButton rdbtnHumano_1 = new JRadioButton("Humano");
		rdbtnHumano_1.setBounds(427, 218, 111, 23);
		contentPane.add(rdbtnHumano_1);
		jugador1.add(rdbtnHumano_1);
		rdbtnHumano_1.setSelected(true);

		rdbtnCPU_1 = new JRadioButton("CPU");
		rdbtnCPU_1.setBounds(567, 218, 111, 23);
		contentPane.add(rdbtnCPU_1);
		jugador1.add(rdbtnCPU_1);

		JLabel lblJugador2 = new JLabel("Jugador 2:");
		lblJugador2.setBounds(427, 284, 88, 14);
		contentPane.add(lblJugador2);

		JLabel lblNombre_2 = new JLabel("Nombre:");
		lblNombre_2.setBounds(427, 309, 49, 14);
		contentPane.add(lblNombre_2);

		JRadioButton rdbtnHumano_2 = new JRadioButton("Humano");
		rdbtnHumano_2.setBounds(427, 359, 111, 23);
		contentPane.add(rdbtnHumano_2);
		jugador2.add(rdbtnHumano_2);
		rdbtnHumano_2.setSelected(true);

		rdbtnCPU_2 = new JRadioButton("CPU");
		rdbtnCPU_2.setBounds(542, 359, 111, 23);
		contentPane.add(rdbtnCPU_2);
		jugador2.add(rdbtnCPU_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(427, 124, 250, 2);
		contentPane.add(separator);
		
		rdb3fichas = new JRadioButton("3 fichas");
		rdb3fichas.setSelected(true);
		rdb3fichas.setBounds(427, 56, 111, 23);
		contentPane.add(rdb3fichas);
		modalidadJuego.add(rdb3fichas);
		
		rdbLlenarTablero = new JRadioButton("Llenar tablero");
		rdbLlenarTablero.setSelected(true);
		rdbLlenarTablero.setBounds(567, 56, 111, 23);
		contentPane.add(rdbLlenarTablero);
		modalidadJuego.add(rdbLlenarTablero);
		
		JLabel lblModalidadJuego = new JLabel("Seleccione una modalidad de juego");
		lblModalidadJuego.setBounds(427, 24, 251, 14);
		contentPane.add(lblModalidadJuego);

		setVisible(true);
	}

	public void gameBoardGenerator() {
		int px = 60;
		int py = 60;
		final int SIZE = 90;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[j][i] = new JToggleButton();
				tablero[j][i].setBounds(px, py, SIZE, SIZE);
				contentPane.add(tablero[j][i]);
				listaBotones.add(tablero[j][i]);
				tablero[j][i].setEnabled(false);
				set_xo_listener(tablero[j][i]);
				px += 95;
			}
			px = 60;
			py += 95;
		}
	}

	public void set_xo_listener(JToggleButton b) {
		b.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				xo(b);
			}
		});
	}

	ActionListener inicio_partida = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//game mode selection
			llenar_tablero = rdbLlenarTablero.isSelected();
			
			//only start if you have the fields filled in
			if (textJug1.getText().isEmpty() || textJug2.getText().isEmpty()) {
				lblAccion.setText("¡Introduzca nombres a los jugadores!");
			}
			else if (rdbtnCPU_1.isSelected() && rdbtnCPU_2.isSelected()) {
				lblAccion.setText("Almenos un jugador debe ser humano");
			}
			else {
				lblAccion.setText("Turno de jugador " + textJug1.getText());
				
				//let's start the game
				for (int i = 0; i < listaBotones.size(); i++) {
					listaBotones.get(i).setSelected(false);
					listaBotones.get(i).setText("");
					listaBotones.get(i).setEnabled(true);
				}
				turn=0;
				check_cpu_turn();
			}
		}

	};

	/**
	 * This method checks of any player wins
	 * @return winner state
	 */
	public boolean ganador() {
		
		// Winner dafault state
		boolean winner = false;
		
		// WINNER PLAYER ONE
		for (int i = 0; i < 3; i++) {
			// Check rows
			if(tablero[i][0].getText().equals("X") && tablero[i][1].getText().equals("X") && tablero[i][2].getText().equals("X")){
				lblAccion.setText("El jugador " + textJug1.getText() + " ha ganado.");
				winner = true;
			}
			// Check columns
			if(tablero[0][i].getText().equals("X") && tablero[1][i].getText().equals("X") && tablero[2][i].getText().equals("X")){
				lblAccion.setText("El jugador " + textJug1.getText() + " ha ganado.");
				winner = true;
			}
		}
		// Check diagonals
		if (tablero[0][0].getText().equals("X") && tablero[1][1].getText().equals("X") && tablero[2][2].getText().equals("X")) {
			lblAccion.setText("El jugador " + textJug1.getText() + " ha ganado.");
			winner = true;
		}
		if (tablero[0][2].getText().equals("X") && tablero[1][1].getText().equals("X") && tablero[2][0].getText().equals("X")) {
			lblAccion.setText("El jugador " + textJug1.getText() + " ha ganado.");
			winner = true;
		}
		
		// WINNER PLAYER TWO
				for (int j = 0; j < 3; j++) {
					// Check rows
					if(tablero[j][0].getText().equals("O") && tablero[j][1].getText().equals("O") && tablero[j][2].getText().equals("O")){
						lblAccion.setText("El jugador " + textJug2.getText() + " ha ganado.");
						winner = true;
					}
					// Check columns
					if(tablero[0][j].getText().equals("O") && tablero[1][j].getText().equals("O") && tablero[2][j].getText().equals("O")){
						lblAccion.setText("El jugador " + textJug2.getText() + " ha ganado.");
						winner = true;
					}
				}
				// Check diagonals
				if (tablero[0][0].getText().equals("O") && tablero[1][1].getText().equals("O") && tablero[2][2].getText().equals("O")) {
					lblAccion.setText("El jugador " + textJug2.getText() + " ha ganado.");
					winner = true;
				}
				if (tablero[0][2].getText().equals("O") && tablero[1][1].getText().equals("O") && tablero[2][0].getText().equals("O")) {
					lblAccion.setText("El jugador " + textJug2.getText() + " ha ganado.");
					winner = true;
				}
		// Winner stop the game		
		if (winner) {
			for (JToggleButton btn : listaBotones) {
			    btn.setEnabled(false);
			}
		}
		
		// Return result
		return winner;
	}

	int threes[][][] = {{{0,0},{0,1},{0,2}}, {{1,0},{1,1},{1,2}}, {{2,0},{2,1},{2,2}},
						{{0,0},{1,0},{2,0}}, {{0,1},{1,1},{2,1}}, {{0,2},{1,2},{2,2}},
						{{0,0},{1,1},{2,2}}, {{0,2},{1,1},{2,0}}};
	
	private JToggleButton getFromTablero(int[] pos) {
		return tablero[pos[0]][pos[1]];
	}
	private boolean equals(int[] a, int[] b) {
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}
	private boolean contains(ArrayList<int[]> al, int[] a) {
		for (int[] a_al : al) {
			if (equals(a, a_al)) return true;
		}
		return false;
	}
	private class Choice {
		Choice(int score, JToggleButton button) {
			this.score = score;
			this.button = button;
		}
		int score;
		JToggleButton button;
	}
	private Choice cpu_choose(int player) {
		String me = player == 0 ? "X":"O";
		//String they = player == 1 ? "X":"0";
		int[] one2win = null;
		int[] one2lose = null;
		int[] doubleTwo2win = null;
		int[] doubleTwo2lose = null;
		ArrayList<int[]> two2win = new ArrayList<>();
		ArrayList<int[]> two2lose = new ArrayList<>();
		for (int[][] three : threes) {
			ArrayList<int[]> list_empty = new ArrayList<>();
			int n_empty = 0;
			int n_me = 0;
			int n_they = 0;
			for (int[] pos : three) {
				String status = getFromTablero(pos).getText();
				if (status == "") {
					n_empty++; 
					list_empty.add(pos);
				}
				else if (status == me) n_me++;
				else n_they++;
			}
			// If I move to the empty slot I win
			if (n_me == 2 && n_empty == 1) {one2win = list_empty.get(0); break;}
			// If they move to the empty slot, they'll win. So I have to block it.
			else if (n_they == 2 && n_empty == 1) one2lose = list_empty.get(0);
			else if (n_me == 1 && n_empty == 2) {
				for (int[] pos : list_empty) {
					// If I move to the empty slot I'll have 2 options to win
					// They can only bock one so I'll win
					if (contains(two2win, pos)) doubleTwo2win = pos;
					else two2win.add(pos);
				}
			} else if (n_they == 1 && n_empty == 2) {
				for (int[] pos : list_empty) {
					// If they moved to the empty slot they'd have 2 options to win
					// I could only bock one so I they'd win.
					// So I have to block the empty slot
					if (contains(two2lose, pos)) doubleTwo2lose = pos;
					else two2lose.add(pos);
				}
			}
		}
		if (one2win != null) return new Choice(1,getFromTablero(one2win));
		if (one2lose != null) return new Choice(3,getFromTablero(one2lose));
		if (doubleTwo2win != null) return new Choice(2,getFromTablero(doubleTwo2win));
		if (doubleTwo2lose != null) return new Choice(3,getFromTablero(doubleTwo2lose));
		int[][] priority = {{1,1},{0,0},{0,2},{2,0},{2,2},{0,1},{1,0},{1,2},{2,1}};
		for (int[] pos : priority) {
				if (getFromTablero(pos).getText() == "") 
					return new Choice(3,getFromTablero(pos));
		}
		return null;
	}

	public void cpu_move_new(int player) {
		JToggleButton b = cpu_choose(player).button;
		b.setSelected(true);
	}

	JToggleButton insertar_ficha_pendiente =  null;

	public void cpu_move_from_board(int player) {
		String mi_ficha = player == 0 ? "X":"O";
		ArrayList<JToggleButton> mis_fichas = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tablero[i][j].getText() == mi_ficha) 
					mis_fichas.add(tablero[i][j]);
			}
		}
		JToggleButton best_remove = null;
		JToggleButton best_insert = null;
		int best_score = 99;
		for (JToggleButton b : mis_fichas) {
			b.setText("");
			Choice choice = cpu_choose(player);
			if (choice.score < best_score) {
				best_remove = b;
				best_insert = choice.button;
				best_score = choice.score;
			}
			b.setText(mi_ficha);
		}
		best_remove.setSelected(false);
		best_insert.setSelected(true);
	}

	public void check_cpu_turn() {
		int player = turn%2;
		if ((player==0 ? rdbtnCPU_1 : rdbtnCPU_2).isSelected()) {
			if (turn >= 6 && !llenar_tablero) {
				cpu_move_from_board(player);
			}
			else if (turn < 9) {
				cpu_move_new(player);
			}
		}
		
	}

	//Method to make the plays
	private void xo(JToggleButton b) {
		b.setFont(new Font("Arial", Font.BOLD, 70));
		if (b.isSelected()) { //a token has been added to this spot
			if (turn%2 == 0) {
				b.setText("X"); // X for player 1
				b.setEnabled(false);
				lblAccion.setText("Turno de jugador " + textJug2.getText()); //player 2 turn
				turn++;
				if (turn >= 6 && !llenar_tablero) { //alredy 3 tokens per player
					for (JToggleButton btn : listaBotones) {
						btn.setEnabled(btn.getText() == "O"); // time to move one O token
					}
				}
				//If not,is the turn of the second player 
			} else {
				b.setText("O"); // O for player 2
				b.setEnabled(false);
				lblAccion.setText("Turno de jugador " + textJug1.getText()); //player 1 turn
				turn++; 
				if (turn >= 6 && !llenar_tablero) { //alredy 3 tokens per player
					for (JToggleButton btn : listaBotones) {
						btn.setEnabled(btn.getText() == "X"); // time to move one X token
					}
				}
			}
			if (ganador()) return;
			if(llenar_tablero && turn >=9)lblAccion.setText("El juego ha terminado.");
			check_cpu_turn();
		}
		else { //a token has been removed from this spot
			b.setText("");
			for (JToggleButton btn : listaBotones) {
				btn.setEnabled(btn.getText() == ""); //time to add a token to an empty slot
			}
		}
		
	}

}