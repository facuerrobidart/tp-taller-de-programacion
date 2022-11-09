package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.MesaDTO;

import java.awt.Font;
import java.awt.event.ActionListener;

public class VistaAgregarComanda extends JFrame {

	private JPanel contentPane;
	private JList<MesaDTO> listaMesas;
	
	private JButton btnConfirmar;
	private JButton btnAtras;
	private ActionListener actionListener;
	
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
		listaMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMesas.setBounds(10, 66, 364, 442);
		panel.add(listaMesas);
		
		JLabel lblSeleccioneLaMesa = new JLabel("Seleccione la mesa donde agregar la comanda");
		lblSeleccioneLaMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeleccioneLaMesa.setBounds(10, 11, 426, 25);
		panel.add(lblSeleccioneLaMesa);
		
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand("CONFIRMAR");
		btnConfirmar.setBounds(202, 521, 172, 23);
		panel.add(btnConfirmar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setActionCommand("ATRAS");
		btnAtras.setBounds(10, 521, 172, 23);
		panel.add(btnAtras);
	}

	public void mostrar() {
        this.setVisible(true);

    }
	

	public MesaDTO getMesa() {
		return this.listaMesas.getSelectedValue();
	}

	public void setListaMesas(MesaDTO[] mesas) {
		this.listaMesas.setListData(mesas);
	}
	
    public void esconder() {
        this.setVisible(false);
    }

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		this.btnConfirmar.addActionListener(actionListener);
		this.btnAtras.addActionListener(actionListener);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
