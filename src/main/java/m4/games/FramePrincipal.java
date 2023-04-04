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

		JToggleButton tglbtn = new JToggleButton("");
		tglbtn.setBounds(60, 40, 90, 90);
		contentPane.add(tglbtn);
		xo(tglbtn, lblAccion);
		listaBotones.add(tglbtn);

		JToggleButton tglbtn_1 = new JToggleButton("");
		tglbtn_1.setBounds(155, 40, 90, 90);
		contentPane.add(tglbtn_1);
		xo(tglbtn_1, lblAccion);
		listaBotones.add(tglbtn_1);

		JToggleButton tglbtn_2 = new JToggleButton("");
		tglbtn_2.setBounds(250, 40, 90, 90);
		contentPane.add(tglbtn_2);
		xo(tglbtn_2, lblAccion);
		listaBotones.add(tglbtn_2);

		JToggleButton tglbtn_3 = new JToggleButton("");
		tglbtn_3.setBounds(60, 135, 90, 90);
		contentPane.add(tglbtn_3);
		xo(tglbtn_3, lblAccion);
		listaBotones.add(tglbtn_3);

		JToggleButton tglbtn_4 = new JToggleButton("");
		tglbtn_4.setBounds(155, 135, 90, 90);
		contentPane.add(tglbtn_4);
		xo(tglbtn_4, lblAccion);
		listaBotones.add(tglbtn_4);

		JToggleButton tglbtn_5 = new JToggleButton("");
		tglbtn_5.setBounds(250, 135, 90, 90);
		contentPane.add(tglbtn_5);
		xo(tglbtn_5, lblAccion);
		listaBotones.add(tglbtn_5);

		JToggleButton tglbtn_6 = new JToggleButton("");
		tglbtn_6.setBounds(60, 230, 90, 90);
		contentPane.add(tglbtn_6);
		xo(tglbtn_6, lblAccion);
		listaBotones.add(tglbtn_6);

		JToggleButton tglbtn_7 = new JToggleButton("");
		tglbtn_7.setBounds(155, 230, 90, 90);
		contentPane.add(tglbtn_7);
		xo(tglbtn_7, lblAccion);
		listaBotones.add(tglbtn_7);

		JToggleButton tglbtn_8 = new JToggleButton("");
		tglbtn_8.setBounds(250, 230, 90, 90);
		contentPane.add(tglbtn_8);
		xo(tglbtn_8, lblAccion);
		listaBotones.add(tglbtn_8);

		Game.startGame(lblAccion, tglbtn);
		Game.buttonOff(tglbtn);
		Game.buttonOff(tglbtn_1);
		Game.buttonOff(tglbtn_2);
		Game.buttonOff(tglbtn_3);
		Game.buttonOff(tglbtn_4);
		Game.buttonOff(tglbtn_5);
		Game.buttonOff(tglbtn_6);
		Game.buttonOff(tglbtn_7);
		Game.buttonOff(tglbtn_8);

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
		jugador1.add(rdbtnHumano);

		JRadioButton rdbtnCPU = new JRadioButton("CPU");
		rdbtnCPU.setBounds(567, 218, 111, 23);
		contentPane.add(rdbtnCPU);
		jugador2.add(rdbtnCPU);

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

	ActionListener aL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < listaBotones.size(); i++) {
				listaBotones.get(i).setSelected(false);
				listaBotones.get(i).setText("");
			}

			for (int i = 0; i < listaBotones.size(); i++) {
				listaBotones.get(i).setEnabled(true);
				
			}
			turn=0;
		}

	};

	public void xo(JToggleButton b, JLabel l) {
		b.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				b.setFont(new Font("Arial", Font.BOLD, 70));
				if (b.isSelected()) {

					if (turn % 2 == 0 && turn < 5) {
						l.setText("Turno de jugador " + textJug2.getText());
						b.setText("X");
						b.setEnabled(false);
						turn++;
					} else if (turn % 2 != 0 && turn <=5) {
						l.setText("Turno de jugador " + textJug1.getText());
						b.setText("O");
						b.setEnabled(false);
						turn++;
					} else {
						for (int i = 0; i < listaBotones.size(); i++) {
							listaBotones.get(i).setEnabled(false);
							listaBotones.get(i).setSelected(false);
							
						}
						
						
						
						
						
					}
				}
				

			}
		});
	}
}
