package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import com.grupo8.app.dto.MesaDTO;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VistaAgregarComanda extends JFrame {

	private JPanel contentPane;
	private JList<MesaDTO> listaMesas;
	private JButton btnConfirmar;
	private JButton btnAtras;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgregarComanda frame = new VistaAgregarComanda();
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
	public VistaAgregarComanda() {
		setTitle("Agregar Comanda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		listaMesas = new JList<MesaDTO>();
		listaMesas.setBounds(10, 66, 364, 442);
		panel.add(listaMesas);
		
		JLabel lblSeleccioneLaMesa = new JLabel("Seleccione la mesa donde agregar la comanda");
		lblSeleccioneLaMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeleccioneLaMesa.setBounds(10, 11, 426, 25);
		panel.add(lblSeleccioneLaMesa);
		
		
		 btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(202, 521, 172, 23);
		panel.add(btnConfirmar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 521, 172, 23);
		panel.add(btnAtras);
	}

	public void mostrar() {
        this.setVisible(true);

    }


    public void esconder() {
        this.setVisible(false);
    }
}
