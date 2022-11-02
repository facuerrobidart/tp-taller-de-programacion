package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class VistaIniciarTurno extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregarPedido;
	private JButton btnAsistenciaMozos;
	private JButton btnVolver;
	private JButton btnGestionarMesas;

	public VistaIniciarTurno() {
		setTitle("Iniciar Turno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);
		
		btnAsistenciaMozos = new JButton("Asistencia Mozos");
		btnAsistenciaMozos.setPreferredSize(new Dimension(250, 45));
		btnAsistenciaMozos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnAsistenciaMozos);
		btnAsistenciaMozos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		btnGestionarMesas = new JButton("Gestionar mesas");
		btnGestionarMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionarMesas.setPreferredSize(new Dimension(250, 45));
		panel_6.add(btnGestionarMesas);
		btnGestionarMesas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnAgregarPedido = new JButton("Agregar pedido a la mesa");
		btnAgregarPedido.setPreferredSize(new Dimension(250, 45));
		panel_1.add(btnAgregarPedido);
		btnAgregarPedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1_2_1 = new JPanel();
		panel.add(panel_1_2_1);
		
		JButton btnCerrarTurno = new JButton("Cerrar turno");
		btnCerrarTurno.setPreferredSize(new Dimension(250, 45));
		btnCerrarTurno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCerrarTurno.setActionCommand("Ingresar");
		panel_1_2_1.add(btnCerrarTurno);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnVolver = new JButton("Volver");
		btnVolver.setPreferredSize(new Dimension(250, 45));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(btnVolver);
	}

	
	public void setActionListener(ActionListener actionListener) {
		this.btnVolver.addActionListener(actionListener);
		this.btnAgregarPedido.addActionListener(actionListener);
		
		this.btnAsistenciaMozos.addActionListener(actionListener);
		this.btnGestionarMesas.addActionListener(actionListener);
		
	}
	
	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
		
	}

	

}
