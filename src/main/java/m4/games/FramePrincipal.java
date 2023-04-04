package m4.games;

import java.awt.EventQueue;

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
import java.awt.event.ActionEvent;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textJug1;
	private JTextField textJug2;
	private ButtonGroup jugador = new ButtonGroup();



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
		
		JToggleButton tglbtn = new JToggleButton("");
		tglbtn.setBounds(72, 75, 94, 85);
		contentPane.add(tglbtn);
		
		JToggleButton tglbtn_1 = new JToggleButton("");
		tglbtn_1.setBounds(173, 75, 94, 85);
		contentPane.add(tglbtn_1);
		
		JToggleButton tglbtn_2 = new JToggleButton("");
		tglbtn_2.setBounds(277, 75, 94, 85);
		contentPane.add(tglbtn_2);
		
		JToggleButton tglbtn_3 = new JToggleButton("");
		tglbtn_3.setBounds(72, 170, 94, 85);
		contentPane.add(tglbtn_3);
		
		JToggleButton tglbtn_4 = new JToggleButton("");
		tglbtn_4.setBounds(173, 170, 94, 85);
		contentPane.add(tglbtn_4);
		
		JToggleButton tglbtn_5 = new JToggleButton("");
		tglbtn_5.setBounds(277, 171, 94, 85);
		contentPane.add(tglbtn_5);
		
		JToggleButton tglbtn_6 = new JToggleButton("");
		tglbtn_6.setBounds(72, 266, 94, 85);
		contentPane.add(tglbtn_6);
		
		JToggleButton tglbtn_7 = new JToggleButton("");
		tglbtn_7.setBounds(173, 266, 94, 85);
		contentPane.add(tglbtn_7);
		
		JToggleButton tglbtn_8 = new JToggleButton("");
		tglbtn_8.setBounds(277, 267, 94, 85);
		contentPane.add(tglbtn_8);
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(aL);
		btnNuevaPartida.setBounds(505, 25, 119, 23);
		contentPane.add(btnNuevaPartida);
		
		JLabel lblAccion = new JLabel("accion a realizar");
		lblAccion.setBounds(427, 80, 226, 14);
		contentPane.add(lblAccion);
		
		JLabel lblJugador1 = new JLabel("Jugador 1:");
		lblJugador1.setBounds(427, 124, 88, 14);
		contentPane.add(lblJugador1);
		
		textJug1 = new JTextField();
		textJug1.setBounds(510, 162, 96, 20);
		contentPane.add(textJug1);
		textJug1.setColumns(10);
		
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
		
		textJug2 = new JTextField();
		textJug2.setColumns(10);
		textJug2.setBounds(505, 309, 96, 20);
		contentPane.add(textJug2);
		
		JRadioButton rdbtnHumano_1 = new JRadioButton("Humano");
		rdbtnHumano_1.setBounds(427, 359, 111, 23);
		contentPane.add(rdbtnHumano_1);
		
		JRadioButton rdbtnCPU_1 = new JRadioButton("CPU");
		rdbtnCPU_1.setBounds(542, 359, 111, 23);
		contentPane.add(rdbtnCPU_1);
		
		
		
		
		setVisible(true);
	}

	ActionListener aL =new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		}
	};
}
