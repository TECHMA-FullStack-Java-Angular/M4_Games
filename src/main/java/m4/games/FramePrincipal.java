package m4.games;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textJug1;
	private JTextField textJug2;
	private ButtonGroup jugador = new ButtonGroup();
	
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

			

		JLabel lblAccion = new JLabel("Empieza la partida, turno de");
		lblAccion.setBounds(427, 80, 226, 14);
		contentPane.add(lblAccion);
		
		/* TABLERO DE JUEGO */
		gameBoardGenerator(lblAccion);
				
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(aL);
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
		
		JRadioButton rdbtnHumano = new JRadioButton("Humano");
		rdbtnHumano.setBounds(427, 218, 111, 23);
		contentPane.add(rdbtnHumano);
		jugador.add(rdbtnHumano);
		
		JRadioButton rdbtnCPU = new JRadioButton("CPU");
		rdbtnCPU.setBounds(567, 218, 111, 23);
		contentPane.add(rdbtnCPU);
		jugador.add(rdbtnCPU);
		
		JLabel lblJugador2 = new JLabel("Jugador 2:");
		lblJugador2.setBounds(427, 284, 88, 14);
		contentPane.add(lblJugador2);
		
		JLabel lblNombre_2 = new JLabel("Nombre:");
		lblNombre_2.setBounds(427, 309, 49, 14);
		contentPane.add(lblNombre_2);
		
		
		
		JRadioButton rdbtnHumano_1 = new JRadioButton("Humano");
		rdbtnHumano_1.setBounds(427, 359, 111, 23);
		contentPane.add(rdbtnHumano_1);
		
		JRadioButton rdbtnCPU_1 = new JRadioButton("CPU");
		rdbtnCPU_1.setBounds(542, 359, 111, 23);
		contentPane.add(rdbtnCPU_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(427, 105, 250, 2);
		contentPane.add(separator);
		
		
		
		
		setVisible(true);
	}

	ActionListener aL =new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		}
	};
	
	public void xo(JToggleButton b, JLabel l) {
		b.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				b.setFont(new Font("Arial", Font.BOLD, 70));
				if(b.isSelected()) {
					if (turn%2 == 0) {
						l.setText("Turno de jugador 2");
						b.setText("X");
					} else {
						l.setText("Turno de jugador 1");
						b.setText("O");
					}
				}
				b.setEnabled(false);
				turn++;
				
			}
		});
	}
	
	public void gameBoardGenerator(JLabel l) {
		int px = 60;
		int py = 60;
		final int SIZE = 90;
		
		JToggleButton[][] tablero = new JToggleButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[j][i] = new JToggleButton(i + " " + j);
				tablero[j][i].setBounds(px, py, SIZE, SIZE);
				contentPane.add(tablero[j][i]);
				xo(tablero[j][i], l);
				px += 95;
			}
			px = 60;
			py += 95;
		}
	}
}
