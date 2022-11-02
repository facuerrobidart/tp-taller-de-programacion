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

public class VistaEliminarProducto extends JFrame implements MouseListener {

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
					VistaEliminarProducto frame = new VistaEliminarProducto();
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
	public VistaEliminarProducto() {
		setTitle("Eliminar producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 428, 587);
		General.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el producto a eliminar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 26, 307, 77);
		panel.add(lblNewLabel);
		
		JList listProductosElim = new JList();
		listProductosElim.setBounds(10, 142, 408, 434);
		panel.add(listProductosElim);
		
		
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

	
	public void mostrar() {
		this.setVisible(true);
		
	}

	
	public void esconder() {
		this.setVisible(false);
		
	}

	
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
        this.btnVolver.addActionListener(actionListener);
        
        this.actionListener = actionListener;
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	/*	if(this.GrupoEstudios.getSelection()!=null)
			this.Estudios = this.GrupoEstudios.getSelection().getActionCommand();
		if(this.GrupoRemuneracion.getSelection()!=null)
			this.Remuneracion = this.GrupoRemuneracion.getSelection().getActionCommand();
		if(this.GrupoHorario.getSelection()!=null)
			this.Horario = this.GrupoHorario.getSelection().getActionCommand();
		if(this.GrupoPuesto.getSelection()!=null)
			this.Puesto = this.GrupoPuesto.getSelection().getActionCommand();
		if(this.GrupoREtario.getSelection()!=null)
			this.REtario = this.GrupoREtario.getSelection().getActionCommand();
		if(this.GrupoExperiencia.getSelection()!=null)
			this.Experiencia = this.GrupoExperiencia.getSelection().getActionCommand();
		if(this.GrupoLocacion.getSelection()!=null)
			this.Locacion = this.GrupoLocacion.getSelection().getActionCommand();
		if(this.GrupoEstudios.getSelection()!=null && this.GrupoRemuneracion.getSelection()!=null && this.GrupoHorario.getSelection()!=null
				&& this.GrupoPuesto.getSelection()!=null && this.GrupoREtario.getSelection()!=null  && this.GrupoExperiencia.getSelection()!=null
				&& this.GrupoLocacion.getSelection()!=null)
			this.btnFinalizar.setEnabled(true);*/
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void limpiaCampos() {/*
		this.GrupoEstudios.clearSelection();
		this.GrupoExperiencia.clearSelection();
		this.GrupoHorario.clearSelection();
		this.GrupoLocacion.clearSelection();
		this.GrupoPuesto.clearSelection();
		this.GrupoRemuneracion.clearSelection();
		this.GrupoREtario.clearSelection();
		
		this.pesocargaHoraria.setText("");
		this.pesoEstudios.setText("");
		this.pesoExperiencia.setText("");
		this.pesoLocacion.setText("");
		this.pesoRangoEtario.setText("");
		this.pesoRemuneracion.setText("");
		this.pesoTipoDePuesto.setText("");*/
	}

	
	public void success(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	
	/*public TicketDeEmpleadoRequest getFormulario(){
		
		TicketDeEmpleadoRequest ticketDeEmpleadoRequest=null;
		int pesos = -1; //Esta variable se usa para corroborar que anden los parseos
		
		try {
			
		 ticketDeEmpleadoRequest = new TicketDeEmpleadoRequest(this.Locacion, Integer.parseInt(this.pesoLocacion.getText()), 
																					  this.Estudios, Integer.parseInt(this.pesoEstudios.getText()),
																					  this.Experiencia, Integer.parseInt(this.pesoExperiencia.getText()), 
																					  this.Horario,Integer.parseInt(this.pesocargaHoraria.getText()), 
																					  this.REtario, Integer.parseInt(this.pesoRangoEtario.getText()),
																					  this.Remuneracion, Integer.parseInt(this.pesoRemuneracion.getText()), 
																					  this.Puesto, Integer.parseInt(this.pesoTipoDePuesto.getText()));
		}
		catch(Exception e) {

				JOptionPane.showMessageDialog(null, "No ingreso correctamente uno o mas pesos", "Error", JOptionPane.ERROR_MESSAGE);
				this.pesoLocacion.setText("");
				this.pesoEstudios.setText("");
				this.pesoExperiencia.setText("");
				this.pesocargaHoraria.setText("");
				this.pesoRangoEtario.setText("");
				this.pesoRemuneracion.setText("");
				this.pesoTipoDePuesto.setText("");
				
		}
		
		return ticketDeEmpleadoRequest;
		
	}*/

	
}
