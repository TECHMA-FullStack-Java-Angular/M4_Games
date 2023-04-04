package m4.games;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textJug1;



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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(427, 168, 49, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		setVisible(true);
	}

}
