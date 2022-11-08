package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.AddProductoRequest;
import com.grupo8.app.dto.MesaDTO;
import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.tipos.EstadoMesa;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Font;
import java.awt.FlowLayout;

public class VistaNuevaMesa extends JFrame implements MouseListener{

	private JPanel General;
	private ActionListener actionListener;
	private JTextField textFieldCantSillas;
	private JTextField textFieldNumeroMesas;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JList<MozoDTO> listaMozos;	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevaMesa frame = new VistaNuevaMesa();
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
	public VistaNuevaMesa() {
		setTitle("Nueva Mesa");
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
		panel_1.setBounds(28, 46, 349, 64);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Ingrese cantidad de sillas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		textFieldCantSillas = new JTextField();
		panel_1.add(textFieldCantSillas);
		textFieldCantSillas.setColumns(5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 196, 377, 64);
		panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Ingrese numero de mesa ");
		lblNewLabel_5.setBounds(74, 5, 229, 25);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_11.add(lblNewLabel_5);
		
		textFieldNumeroMesas = new JTextField();
		textFieldNumeroMesas.setBounds(308, 7, 46, 20);
		textFieldNumeroMesas.setColumns(5);
		panel_11.add(textFieldNumeroMesas);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 354, 377, 232);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
	    listaMozos = new JList();
		listaMozos.setBounds(10, 11, 360, 210);
		panel_13.add(listaMozos);
		
		JLabel lblNewLabel_5_1 = new JLabel("Asigne Mozo: ");
		lblNewLabel_5_1.setBounds(0, 298, 302, 30);
		panel.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	    JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnAceptar);
		
	}

	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		this.btnVolver.addActionListener(actionListener);
        this.btnAceptar.addActionListener(actionListener);
       /* this.listaMozos.addActionListener(actionListener);*/
       
       
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
			this.btnFinalizar.setEnabled(true); */
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
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
	
	public MesaDTO getFormulario() {
		MesaDTO request = new MesaDTO();
		request.setCantSillas(Integer.parseInt(this.textFieldCantSillas.getText()));
		request.setNroMesa(Integer.parseInt(this.textFieldNumeroMesas.getText()));
		request.setMozo((MozoDTO)this.listaMozos.getSelectedValue());
		request.setEstadoMesa(EstadoMesa.LIBRE);
		return request;
	}

	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
		
	}
	
}
