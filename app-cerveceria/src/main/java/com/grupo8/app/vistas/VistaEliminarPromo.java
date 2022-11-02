package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

public class VistaEliminarPromo extends JFrame implements MouseListener{

	private JPanel General;
	private ActionListener actionListener;
	private JButton btnVolver;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEliminarPromo frame = new VistaEliminarPromo();
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
	public VistaEliminarPromo() {
		setTitle("Eliminar promocion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 428, 587);
		General.add(panel);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 0, 428, 587);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("Clickee sobre la promocion a eliminar: ");
		lblNewLabel_5_1.setBounds(0, 0, 428, 171);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_13.add(lblNewLabel_5_1);
		
		JList listaProductosElim = new JList();
		listaProductosElim.setBounds(0, 171, 428, 415);
		listaProductosElim.setVisibleRowCount(10);
		listaProductosElim.setBackground(Color.WHITE);
		panel_13.add(listaProductosElim);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Clickee sobre el producto a eliminar: ");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(0, 0, 428, 293);
		panel.add(lblNewLabel_5_1_1);
		
		
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		JButton btnAceptar = new JButton("Eliminar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnAceptar);
		
	}

	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
        this.btnVolver.addActionListener(actionListener);
        this.actionListener = actionListener;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
		
	}

	
	
	
	
}
