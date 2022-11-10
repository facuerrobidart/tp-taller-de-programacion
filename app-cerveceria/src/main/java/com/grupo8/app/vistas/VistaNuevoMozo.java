package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.AddMozoRequest;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

public class VistaNuevoMozo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombreCompleto;
	private JTextField textFieldFechaNac;
	private JTextField textFieldCantHijos;
	private JButton btnListo;
	private JButton btnAtras;
	private ActionListener actionListener;


	public VistaNuevoMozo() {
		setTitle("Agregar Mozo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 23, 142, 19);
		contentPane.add(lblNewLabel);
		
		textFieldNombreCompleto = new JTextField();
		textFieldNombreCompleto.setBounds(156, 24, 183, 20);
		contentPane.add(textFieldNombreCompleto);
		textFieldNombreCompleto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de nacimiento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 89, 142, 19);
		contentPane.add(lblNewLabel_1);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(156, 90, 183, 20);
		contentPane.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadDeHijos.setBounds(10, 156, 142, 19);
		contentPane.add(lblCantidadDeHijos);
		
		textFieldCantHijos = new JTextField();
		textFieldCantHijos.setColumns(10);
		textFieldCantHijos.setBounds(156, 157, 39, 20);
		contentPane.add(textFieldCantHijos);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setBounds(0, 234, 225, 27);
		contentPane.add(btnAtras);
		
		btnListo = new JButton("Listo");
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListo.setBounds(220, 234, 214, 27);
		contentPane.add(btnListo);
	}
	
	public void mostrar() {
		this.setVisible(true);
	}

	
	public void esconder() {
		this.setVisible(false);
	}
	
	
	public void setActionListener(ActionListener actionListener) {
		this.actionListener=actionListener;
		this.btnAtras.addActionListener(actionListener);
		this.btnListo.addActionListener(actionListener);
		
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public AddMozoRequest getFormulario() {
		AddMozoRequest request = new AddMozoRequest();
		request.setNombreCompleto(this.textFieldNombreCompleto.getText());
		request.setCantidadHijos(Integer.parseInt(this.textFieldCantHijos.getText()));
		request.setFechaNacimiento(Date.parseDate(this.textFieldFechaNacimiento.getText()));
		return request;
	}


}
