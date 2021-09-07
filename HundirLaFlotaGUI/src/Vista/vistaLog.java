package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.GridLayout;

public class vistaLog extends JFrame {

	private JPanel contentPane;
	public JLabel vidas;
	private JLabel lblNewLabel_1;
	public JLabel barcos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaLog frame = new vistaLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vistaLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 456, 160);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Vidas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Barcos");
		lblNewLabel_1.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1);
		
		vidas = new JLabel("hola");
		vidas.setForeground(Color.WHITE);
		vidas.setFont(new Font("Source Code Pro", Font.BOLD, 12));
		contentPane.add(vidas);
		
		barcos = new JLabel("aa");
		barcos.setForeground(Color.WHITE);
		contentPane.add(barcos);
	}

}
