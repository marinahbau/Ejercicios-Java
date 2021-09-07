package controlador;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Vista.vistaHundirFlota;
import Vista.vistaLog;
import Vista.vistaTablero;
import hundirlaflota.Juego;

public class ControladorHundirFlota implements ActionListener {
	private vistaHundirFlota vista;
	private vistaTablero miTablero;
	private vistaLog miLog;
	private Juego miModelo;
	
	public ControladorHundirFlota(vistaHundirFlota v, vistaTablero mt, vistaLog log) {
		this.vista = v;
		this.miTablero = mt;
		this.miLog = log;
		this.vista.btn1.addActionListener(this);
		this.vista.btn2.addActionListener(this);
		this.vista.btn3.addActionListener(this);
	}
	
	public void cargarTablero(int tamanio) {
		this.vista.setVisible(false);
		this.miLog.setVisible(true);
		//Creamos el juego
		this.miModelo = new Juego(tamanio);
		//Cargamos la nueva vista
		this.miTablero.getContentPane().setLayout(new GridLayout(tamanio,tamanio,0,0));
		//Cargamos el tablero
		for(int i=0; i<tamanio; i++) {
			for(int j=0; j<tamanio; j++) {
			
					this.miTablero.botones.add(new JButton(""));
					this.miTablero.botones.get(i*tamanio+j).setForeground(Color.BLACK);
					this.miTablero.botones.get(i*tamanio+j).addActionListener(this);
					this.miTablero.botones.get(i*tamanio+j).setOpaque(false);
					this.miTablero.botones.get(i*tamanio+j).setContentAreaFilled(false);
					this.miTablero.botones.get(i*tamanio+j).setBorder(new LineBorder(Color.WHITE));
					this.miTablero.getContentPane().add(this.miTablero.botones.get(i*tamanio+j));
					
			}
		}
		this.miLog.barcos.setText(Integer.toString(3));
		this.miLog.vidas.setText(Integer.toString(miModelo.getVidas()));
		this.miTablero.setVisible(true);
	}

	private void actualizarTablero() {
		for(int i=0; i<this.miModelo.getTamanio(); i++) {
			for(int j=0; j<this.miModelo.getTamanio(); j++) {
				if(this.miModelo.getTablero2()[i][j]=="agua") {
					this.miTablero.botones.get(i*this.miModelo.getTamanio()+j).setIcon(this.miTablero.iconoFallo);
					this.miTablero.botones.get(i*this.miModelo.getTamanio()+j).setText("");
				}
				if(this.miModelo.getTablero2()[i][j]=="herido") {
					this.miTablero.botones.get(i*this.miModelo.getTamanio()+j).setIcon(this.miTablero.iconoBarco);
					this.miTablero.botones.get(i*this.miModelo.getTamanio()+j).setText("");
				}
			}
				
		}
		this.miLog.barcos.setText(Integer.toString(3-this.miModelo.mostrarBarcosHundidos()));
		this.miLog.vidas.setText(Integer.toString(miModelo.getVidas()));
		
		if(this.miModelo.getVidas() == 0) {
			this.miLog.barcos.setText("Game Over");
			this.miTablero.setEnabled(false);
		}
		if(this.miLog.barcos.getText().equals("0")) {
			this.miLog.barcos.setText("Has ganado!!");
			this.miTablero.setEnabled(false);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Botones de eleccion de tablero
		if(e.getSource().equals(vista.btn1)) {
			this.cargarTablero(4);
		}
		if(e.getSource().equals(vista.btn2)) {
			this.cargarTablero(6);
		}
		if(e.getSource().equals(vista.btn3)) {
			this.cargarTablero(8);
		}
		
		for(int i=0; i<this.miModelo.getTamanio(); i++) {
			for(int j=0; j<this.miModelo.getTamanio(); j++) {
				if(e.getSource().equals(this.miTablero.botones.get(i*this.miModelo.getTamanio()+j))) {
					if(!this.miModelo.disparar(i,j)) {
						this.miModelo.setVidas(this.miModelo.getVidas()-1);
					}
					this.actualizarTablero();
				}
			}
		}
	}
	
	
}
