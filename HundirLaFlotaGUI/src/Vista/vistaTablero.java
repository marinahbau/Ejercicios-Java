package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class vistaTablero extends JFrame {

	private JPanel contentPane;
	public ArrayList<JButton> botones;
	public JLabel label1;
	public ImageIcon iconoFallo = new ImageIcon("src/images/drop.png");
	public ImageIcon iconoBarco = new ImageIcon("src/images/boat.png");
	public ImageIcon iconoEx = new ImageIcon("src/images/explosion.gif");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaTablero frame = new vistaTablero();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public vistaTablero() throws IOException {
		setForeground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		//new ImageIcon(ImageIO.read(new File("src/images/agua.jpg")
		setBounds(0, 100, 735, 545);
		JLabel background = new JLabel(new ImageIcon("src/images/gif.gif"));
		background.setForeground(Color.WHITE);
		
		botones = new ArrayList<>();
		//background.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(background);
		background.setLayout(new GridLayout(1, 0, 0, 0));
		
		
	}

}
