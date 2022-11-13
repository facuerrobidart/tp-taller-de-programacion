package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaCerrarComanda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMonto;
	private JButton btnCerrarComanda;
	private JButton btnAtras;
	private JRadioButton rdbtnCdni;
	private JRadioButton rdbtnMP;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnTarjeta;
	private ActionListener actionListener;
	
	public VistaCerrarComanda() {
		setTitle("Cerrar comanda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnCerrarComanda = new JButton("Cerrar comanda");
		btnCerrarComanda.setActionCommand("CerrarComanda");
		btnCerrarComanda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrarComanda.setBounds(302, 334, 144, 23);
		contentPane.add(btnCerrarComanda);
		
		 btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setBounds(10, 334, 120, 23);
		contentPane.add(btnAtras);
		
		rdbtnCdni = new JRadioButton("Cuenta DNI");
		rdbtnCdni.setActionCommand("Cdni");
		rdbtnCdni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCdni.setBounds(27, 226, 109, 23);
		contentPane.add(rdbtnCdni);
		
		 rdbtnMP = new JRadioButton("Mercado Pago");
		rdbtnMP.setActionCommand("MP");
		rdbtnMP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMP.setBounds(184, 226, 144, 23);
		contentPane.add(rdbtnMP);
		
	    rdbtnTarjeta = new JRadioButton("Tarjeta");
		rdbtnTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnTarjeta.setBounds(184, 171, 109, 23);
		contentPane.add(rdbtnTarjeta);
		
		 rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnEfectivo.setBounds(27, 171, 109, 23);
		contentPane.add(rdbtnEfectivo);
		
		JLabel lblNewLabel = new JLabel("Elija el medio de pago ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 125, 144, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblElMontoA = new JLabel("El monto a pagar es : $  ");
		lblElMontoA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblElMontoA.setBounds(25, 71, 151, 23);
		contentPane.add(lblElMontoA);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setBounds(195, 74, 86, 20);
		contentPane.add(textFieldMonto);
		textFieldMonto.setColumns(10);
	}
	
	public void setActionListener(ActionListener ac) {
		this.actionListener=ac;
		this.rdbtnCdni.addActionListener(ac);
		this.rdbtnMP.addActionListener(ac);
		this.rdbtnEfectivo.addActionListener(ac);
		this.rdbtnTarjeta.addActionListener(ac);
		this.btnAtras.addActionListener(ac);
		this.btnCerrarComanda.addActionListener(ac);

	}
}
