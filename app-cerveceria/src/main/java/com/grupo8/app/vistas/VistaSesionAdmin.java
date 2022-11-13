package com.grupo8.app.vistas;

import java.awt.BorderLayout;
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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class VistaSesionAdmin extends JFrame {

	private JPanel contentPane;
	private JButton btnABMProductos;
	private JButton btnIniciarTurno;
	private JButton btnPromociones;
	private JButton btnEstadisticas;
	private JButton btnCerrarSesion;
	private JButton btnAbmMesas;
	private JButton btnAbmUsuarios;
	private JButton btnAgregarMozo;
	private ActionListener actionListener;
	private JButton btnEliminarMozo;

	public VistaSesionAdmin() {
		setTitle("Sesion Admin");
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
		
		btnIniciarTurno = new JButton("Iniciar turno");
		btnIniciarTurno.setActionCommand("IniciarTurno");
		btnIniciarTurno.setPreferredSize(new Dimension(200, 35));
		btnIniciarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnIniciarTurno);
		btnIniciarTurno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		btnAbmMesas = new JButton("ABM mesas");
		btnAbmMesas.setActionCommand("ABMMesas");
		btnAbmMesas.setPreferredSize(new Dimension(200, 35));
		panel_6.add(btnAbmMesas);
		btnAbmMesas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnABMProductos = new JButton("ABM productos");
		panel_6.add(btnABMProductos);
		btnABMProductos.setActionCommand("ABMProductos");
		btnABMProductos.setPreferredSize(new Dimension(200, 35));
		btnABMProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnAgregarMozo = new JButton("Agregar mozo");
		btnAgregarMozo.setActionCommand("AgregarMozo");
		btnAgregarMozo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAgregarMozo.setPreferredSize(new Dimension(200, 35));
		btnAgregarMozo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnAgregarMozo);
		
		btnEliminarMozo = new JButton("Eliminar mozo");
		btnEliminarMozo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarMozo.setPreferredSize(new Dimension(200, 35));
		btnEliminarMozo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminarMozo.setActionCommand("EliminarMozo");
		panel_1.add(btnEliminarMozo);
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		btnPromociones = new JButton("Promociones");
		btnPromociones.setPreferredSize(new Dimension(200, 35));
		btnPromociones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1_1.add(btnPromociones);
		btnPromociones.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPromociones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1_2.getLayout();
		panel.add(panel_1_2);
		
		btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.setPreferredSize(new Dimension(200, 35));
		panel_1_2.add(btnEstadisticas);
		btnEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1_2_1 = new JPanel();
		panel.add(panel_1_2_1);
		
		btnAbmUsuarios = new JButton("ABM operarios");
		btnAbmUsuarios.setPreferredSize(new Dimension(200, 35));
		btnAbmUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAbmUsuarios.setActionCommand("ABMUsuarios");
		panel_1_2_1.add(btnAbmUsuarios);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setActionCommand("CERRAR");
		btnCerrarSesion.setPreferredSize(new Dimension(200, 35));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(btnCerrarSesion);
	}

	
	public void mostrar() {
		this.setVisible(true);
	}

	public void esconder() {
		this.setVisible(false);
	}
	
	
	public void setActionListener(ActionListener actionListener) {
		
		this.actionListener=actionListener;
		
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnABMProductos.addActionListener(actionListener);
		this.btnPromociones.addActionListener(actionListener);
		this.btnAbmUsuarios.addActionListener(actionListener);
		this.btnIniciarTurno.addActionListener(actionListener);
		this.btnAbmMesas.addActionListener(actionListener);
		this.btnAgregarMozo.addActionListener(actionListener);
		this.btnEstadisticas.addActionListener(actionListener);
		this.btnEliminarMozo.addActionListener(actionListener);
	}

	
	public void failure(String error, String titulo) {
		JOptionPane.showMessageDialog(null, titulo, error, JOptionPane.ERROR_MESSAGE);
	}

	
	public void success(String ok, String titulo) {
		JOptionPane.showMessageDialog(null, titulo, ok, JOptionPane.INFORMATION_MESSAGE);
	}

}
