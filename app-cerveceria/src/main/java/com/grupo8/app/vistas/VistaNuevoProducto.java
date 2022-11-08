package com.grupo8.app.vistas;

import com.grupo8.app.dto.AddProductoRequest;
import com.grupo8.app.dto.ProductoDTO;

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

public class VistaNuevoProducto extends JFrame implements  MouseListener{

	private JPanel General;
	private ActionListener actionListener;
	private JButton btnVolver;
	private JTextField textFieldNombreProducto;
	private JTextField textFieldCostoProducto;
	private JTextField textFieldPrecio;
	private JTextField textFieldStock;
	private ProductoDTO productoEditable;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoProducto frame = new VistaNuevoProducto(null);
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
	public VistaNuevoProducto(ProductoDTO productoEditable) {
		setTitle("Nuevo Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 428, 587);
		General.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre del producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		textFieldNombreProducto = new JTextField();
		panel_1.add(textFieldNombreProducto);
		textFieldNombreProducto.setColumns(10);
		
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JLabel lblNewLabel_5 = new JLabel("Costo del producto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_11.add(lblNewLabel_5);
		
		textFieldCostoProducto = new JTextField();
		textFieldCostoProducto.setColumns(10);
		panel_11.add(textFieldCostoProducto);
		
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JLabel lblrDelProducto = new JLabel("Precio de venta");
		lblrDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblrDelProducto);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		panel_1_1.add(textFieldPrecio);
		
		JPanel panel_1_2 = new JPanel();
		panel.add(panel_1_2);
		
		JLabel lblStockInicial = new JLabel("Stock inicial");
		lblStockInicial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_2.add(lblStockInicial);
		
		textFieldStock = new JTextField();
		textFieldStock.setColumns(10);
		panel_1_2.add(textFieldStock);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("ACEPTAR");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnAceptar);


		this.productoEditable = productoEditable;
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

	public void mouseReleased(MouseEvent e) {/*
		// TODO Auto-generated method stub
		
		if(this.GrupoEstudios.getSelection()!=null)
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
			this.btnFinalizar.setEnabled(true);
	*/}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
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
		this.pesoTipoDePuesto.setText("");
	*/}

	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
	}

	public String getIdEditable() {
		if (this.productoEditable != null) {
			return this.productoEditable.getId();
		} else {
			return null;
		}
	}

	public void setProductoEditable(ProductoDTO productoEditable) {
		this.productoEditable = productoEditable;
		this.textFieldNombreProducto.setText(productoEditable.getNombre());
		this.textFieldPrecio.setText(productoEditable.getPrecio().toString());
		this.textFieldStock.setText(productoEditable.getStock().toString());
		this.textFieldCostoProducto.setText(productoEditable.getCosto().toString());
	}

	public void resetearEditable() {
		this.productoEditable = null;
		this.textFieldNombreProducto.setText("");
		this.textFieldPrecio.setText("");
		this.textFieldStock.setText("");
		this.textFieldCostoProducto.setText("");
	}

	public ProductoDTO getFormulario() {
		ProductoDTO request = new ProductoDTO();
		request.setNombre(this.textFieldNombreProducto.getText());
		request.setPrecio(Float.parseFloat(this.textFieldPrecio.getText()));
		request.setCosto(Float.parseFloat(this.textFieldCostoProducto.getText()));
		request.setStock(Integer.parseInt(this.textFieldStock.getText()));
		return request;
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
