package com.grupo8.app.vistas;

import com.grupo8.app.dto.MesaDTO;

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

public class VistaEliminarMesa extends JFrame implements MouseListener{

	private JPanel General;
	private ActionListener actionListener;
	private int idMesa;
	private JList<MesaDTO> listaMesasElim;
	private JButton btnVolver;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEliminarMesa frame = new VistaEliminarMesa();
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
	public VistaEliminarMesa() {
		setTitle("Eliminar Mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
	
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		JButton btnAceptar = new JButton("Eliminar");
		btnAceptar.setActionCommand("ELIMINAR");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnAceptar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 581);
		General.add(panel);
		panel.setLayout(null);
		
		listaMesasElim = new JList<MesaDTO>();
		listaMesasElim.setBounds(10, 128, 364, 442);
		panel.add(listaMesasElim);
		
		JLabel lblNewLabel = new JLabel("Seleccione la mesa a eliminar");
		lblNewLabel.setBounds(46, 48, 265, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
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

	public int obtenerIdSeleccionado() {
		return this.listaMesasElim.getSelectedValue().getNroMesa();
	}

	public void setListaMesasElim(MesaDTO[] mesas) {
		this.listaMesasElim.setListData(mesas);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		/*if(this.GrupoEstudios.getSelection()!=null)
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

	
	/*public void limpiaCampos() {
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


	public void success(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	

	
}
