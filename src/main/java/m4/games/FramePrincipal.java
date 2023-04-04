package m4.games;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textJug1;
	private JTextField textJug2;
	private ButtonGroup jugador1 = new ButtonGroup();
	private ButtonGroup jugador2 = new ButtonGroup();
	private ArrayList<JToggleButton> listaBotones = new ArrayList<JToggleButton>();
	JToggleButton[][] tablero = new JToggleButton[3][3];
	JLabel lblAccion;
	JRadioButton rdbtnCPU_1, rdbtnCPU_2;

	private int turn = 0;

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setTitle("3 en raya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textJug2 = new JTextField();
		textJug2.setColumns(10);
		textJug2.setBounds(505, 309, 96, 20);
		contentPane.add(textJug2);

		textJug1 = new JTextField();
		textJug1.setBounds(510, 162, 96, 20);
		contentPane.add(textJug1);
		textJug1.setColumns(10);

		lblAccion = new JLabel("Introduce los nombres de los jugadores");
		lblAccion.setBounds(427, 80, 226, 14);
		contentPane.add(lblAccion);

		gameBoardGenerator();

		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(inicio_partida);
		btnNuevaPartida.setBounds(505, 25, 119, 23);
		contentPane.add(btnNuevaPartida);

		JLabel lblJugador1 = new JLabel("Jugador 1:");
		lblJugador1.setBounds(427, 124, 88, 14);
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
		separator.setBounds(427, 105, 250, 2);
		contentPane.add(separator);

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
			if (textJug1.getText().isEmpty() || textJug2.getText().isEmpty()) {
				lblAccion.setText("Introduce los nombres de los jugadores");
			}
			// else if (rdbtnCPU.isSelected && rdnbtn)
			else {
				for (int i = 0; i < listaBotones.size(); i++) {
					listaBotones.get(i).setSelected(false);
					listaBotones.get(i).setText("");
					listaBotones.get(i).setEnabled(true);
					check_cpu_turn();
				}
				turn = 0;
			}
		}

	};

	public boolean ganador() {
		// si hay un ganador lo mustra por pantalla y reorna true
		// si no hay ganador retorna false
		return true;
	}

	public void check_cpu_turn() {
		// si es el turno de CPU, tuira CPU
	}

	private void xo(JToggleButton b) {
		b.setFont(new Font("Arial", Font.BOLD, 70));
		if (b.isSelected()) {
			if (turn % 2 == 0 && turn <= 5) {
				lblAccion.setText("Turno de jugador " + textJug2.getText());
				b.setText("X");
				// b.setEnabled(false);
				turn++;
			} else if (turn % 2 != 0 && turn <= 5) {
				lblAccion.setText("Turno de jugador " + textJug1.getText());
				b.setText("O");
				// b.setEnabled(false);
				turn++;
			} else if (turn % 2 == 0 && turn == 6) {
				for (int i = 0; i < listaBotones.size(); i++) {

					if (listaBotones.get(i).getText() == "X") {
						listaBotones.get(i).setEnabled(true);
						listaBotones.get(i).setSelected(false);
						

					} else {
						listaBotones.get(i).setEnabled(false);
					}

				}

			} else if (turn % 2 != 0 && turn == 7) {
				for (int i = 0; i < listaBotones.size(); i++) {
					if (listaBotones.get(i).getText() == "O") {
						listaBotones.get(i).setEnabled(true);
						listaBotones.get(i).setSelected(false);
						

					} else {
						listaBotones.get(i).setEnabled(false);
					}
				}
				
					
				}
//				else if( turn%2 ==0 && turn> 6) {
//			if(b.isSelected()) {
//				System.out.println("prueba");
//				b.setText("");
//				for (int i = 0; i < listaBotones.size(); i++) {
//					listaBotones.get(i).setEnabled(true);
//				}
//			}
//
//			}
			
			
		}
		if (ganador())
			return;
		check_cpu_turn();
	}

}