package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;

public class vistaHundirFlota extends JFrame {

	private JPanel contentPane;
	public JPanel panelBotones;
	public JButton btn1;
	public JButton btn2;
	public JButton btn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaHundirFlota frame = new vistaHundirFlota();
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
	public vistaHundirFlota() {
		setTitle("Hundir la Flota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panelBotones = new JPanel();
		panelBotones.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de tablero: ");
		lblNewLabel.setBounds(45, 47, 263, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelBotones.add(lblNewLabel);
		
		btn2 = new JButton("6 x 6");
		btn2.setBounds(129, 152, 98, 23);
		panelBotones.add(btn2);
		
		btn3 = new JButton("8 x 8");
		btn3.setBounds(129, 203, 98, 23);
		panelBotones.add(btn3);
		
		btn1 = new JButton("4 x 4");
		
		btn1.setBounds(129, 98, 98, 23);
		panelBotones.add(btn1);
	}

}
