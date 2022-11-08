package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.ComandaDTO;

import javax.swing.JList;
import javax.swing.JButton;

public class VistaGestionComandas extends JFrame {

	private JPanel contentPane;
	private JList<ComandaDTO> listComandas;
	private JButton btnAgregarComanda;
	private JButton btnCerrar;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionComandas frame = new VistaGestionComandas();
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
	public VistaGestionComandas() {
		setTitle("Gestion Comandas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		listComandas = new JList();
		listComandas.setBounds(10, 47, 262, 179);
		panel.add(listComandas);
		
		btnAgregarComanda = new JButton("Agregar Comanda");
		btnAgregarComanda.setBounds(282, 85, 132, 23);
		panel.add(btnAgregarComanda);
		
	    btnCerrar = new JButton("Cerrar comanda");
		btnCerrar.setBounds(282, 161, 132, 23);
		panel.add(btnCerrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 228, 89, 23);
		panel.add(btnVolver);
	}
	
	public void mostrar() {
        this.setVisible(true);

    }


    public void esconder() {
        this.setVisible(false);
    }
	
}
