package com.grupo8.app.vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaNuevaPromoProducto extends JFrame implements MouseListener{

	private JPanel General;
	private ActionListener actionListener;
	private JButton btnVolver;
	private JTextField textFieldNombrePromocion;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevaPromoProducto frame = new VistaNuevaPromoProducto();
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
	public VistaNuevaPromoProducto() {
		setTitle("Nuevo Promocion por Producto");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 1, 428, 64);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre de la promo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		textFieldNombrePromocion = new JTextField();
		panel_1.add(textFieldNombrePromocion);
		textFieldNombrePromocion.setColumns(10);
		
		
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 57, 428, 236);
		panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Producto");
		lblNewLabel_5.setBounds(80, 11, 78, 25);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_11.add(lblNewLabel_5);
		
		JList listaProductos = new JList();
		listaProductos.setBounds(0, 52, 428, 171);
		panel_11.add(listaProductos);
		
	
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 293, 428, 146);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblrDelProducto = new JLabel("Dias de promocion");
		lblrDelProducto.setBounds(10, 11, 166, 25);
		lblrDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblrDelProducto);
		
		JCheckBox chckbxMartes = new JCheckBox("MARTES");
		chckbxMartes.setBounds(182, 56, 97, 23);
		panel_1_1.add(chckbxMartes);
		
		JCheckBox chckbxViernes = new JCheckBox("VIERNES");
		chckbxViernes.setBounds(293, 37, 97, 23);
		panel_1_1.add(chckbxViernes);
		
		JCheckBox chckbxSabado = new JCheckBox("SABADO");
		chckbxSabado.setBounds(293, 63, 97, 23);
		panel_1_1.add(chckbxSabado);
		
		JCheckBox chckbxLunes = new JCheckBox("LUNES");
		chckbxLunes.setBounds(182, 30, 97, 23);
		panel_1_1.add(chckbxLunes);
		
		JCheckBox chckbxMiercoles = new JCheckBox("MIERCOLES");
		chckbxMiercoles.setBounds(182, 79, 97, 23);
		panel_1_1.add(chckbxMiercoles);
		
		JCheckBox chckbxJueves = new JCheckBox("JUEVES");
		chckbxJueves.setBounds(182, 105, 97, 23);
		panel_1_1.add(chckbxJueves);
		
		JCheckBox chckbxDomingo = new JCheckBox("DOMINGO");
		chckbxDomingo.setBounds(293, 89, 97, 23);
		panel_1_1.add(chckbxDomingo);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 439, 428, 146);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JRadioButton rdbtnDescuentoPorCant = new JRadioButton("Descuento por cantidad");
		rdbtnDescuentoPorCant.setBounds(71, 7, 428, 48);
		rdbtnDescuentoPorCant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_2.add(rdbtnDescuentoPorCant);
		
		JRadioButton rdbtnDosPorUno = new JRadioButton("2x1");
		rdbtnDosPorUno.setBounds(71, 71, 428, 48);
		rdbtnDosPorUno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_2.add(rdbtnDosPorUno);
		
		
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
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
			this.btnFinalizar.setEnabled(true);*/
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void limpiaCampos() {
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
	}*/

	
	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
		
	}
	
}
