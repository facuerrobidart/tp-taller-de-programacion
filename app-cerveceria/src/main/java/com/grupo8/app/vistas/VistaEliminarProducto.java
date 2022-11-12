package com.grupo8.app.vistas;

import com.grupo8.app.dto.ProductoDTO;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;


public class VistaEliminarProducto extends JFrame implements MouseListener {

	private JPanel General;
	private ActionListener actionListener;
	private JButton btnVolver;

	
	public VistaEliminarProducto() {
		setTitle("Eliminar producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 620, 587);
		General.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el producto a eliminar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 11, 307, 77);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 600, 434);
		panel.add(scrollPane);
		
		JList<ProductoDTO> listProductosElim = new JList<ProductoDTO>();
		scrollPane.setViewportView(listProductosElim);
		listProductosElim.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
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

	public String obtenerIdProducto() {
		return listProductosElim.getSelectedValue().getId();
	}

	public void setListProductosElim(ProductoDTO[] productos) {
		listProductosElim.setListData(productos);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
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

	
	

	
}
