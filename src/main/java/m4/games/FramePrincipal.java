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
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
		
		textJug1 = new JTextField();
		textJug1.setBounds(510, 162, 96, 20);
		contentPane.add(textJug1);
		textJug1.setColumns(10);
		
		JLabel lblAccion = new JLabel("Empieza la partida, turno de " + textJug1.getText());
		lblAccion.setBounds(427, 80, 226, 14);
		contentPane.add(lblAccion);
		
		JToggleButton tglbtn = new JToggleButton("");
		tglbtn.setBounds(60, 40, 90, 90);
		contentPane.add(tglbtn);
		xo(tglbtn, lblAccion);
		
		JToggleButton tglbtn_1 = new JToggleButton("");
		tglbtn_1.setBounds(155, 40, 90, 90);
		contentPane.add(tglbtn_1);
		xo(tglbtn_1, lblAccion);
		
		JToggleButton tglbtn_2 = new JToggleButton("");
		tglbtn_2.setBounds(250, 40, 90, 90);
		contentPane.add(tglbtn_2);
		xo(tglbtn_2, lblAccion);
		
		JToggleButton tglbtn_3 = new JToggleButton("");
		tglbtn_3.setBounds(60, 135, 90, 90);
		contentPane.add(tglbtn_3);
		xo(tglbtn_3, lblAccion);
		
		JToggleButton tglbtn_4 = new JToggleButton("");
		tglbtn_4.setBounds(155, 135, 90, 90);
		contentPane.add(tglbtn_4);
		xo(tglbtn_4, lblAccion);
		
		JToggleButton tglbtn_5 = new JToggleButton("");
		tglbtn_5.setBounds(250, 135, 90, 90);
		contentPane.add(tglbtn_5);
		xo(tglbtn_5, lblAccion);
		
		JToggleButton tglbtn_6 = new JToggleButton("");
		tglbtn_6.setBounds(60, 230, 90, 90);
		contentPane.add(tglbtn_6);
		xo(tglbtn_6, lblAccion);
		
		JToggleButton tglbtn_7 = new JToggleButton("");
		tglbtn_7.setBounds(155, 230, 90, 90);
		contentPane.add(tglbtn_7);
		xo(tglbtn_7, lblAccion);
		
		JToggleButton tglbtn_8 = new JToggleButton("");
		tglbtn_8.setBounds(250, 230, 90, 90);
		contentPane.add(tglbtn_8);
		xo(tglbtn_8, lblAccion);
		
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
	
	public void xo(JToggleButton b, JLabel l) {
		b.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				b.setFont(new Font("Arial", Font.BOLD, 70));
				if(b.isSelected()) {
					if (turn%2 == 0) {
						l.setText("Turno de jugador "+ textJug2.getText());
						b.setText("X");
					} else {
						l.setText("Turno de jugador "+ textJug1.getText());
						b.setText("O");
					}
				}
				b.setEnabled(false);
				turn++;
				
			}
		});
	}
}
