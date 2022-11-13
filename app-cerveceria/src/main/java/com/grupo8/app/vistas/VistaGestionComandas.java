package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.ComandaDTO;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;

public class VistaGestionComandas extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList<ComandaDTO> listComandas;
	private JButton btnAtras;
	private JLabel lblNewLabel;
	private JButton btnAgregarPedido;
	private JButton btnCerrar;

	public VistaGestionComandas() {
		setTitle("Gestion Comandas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 43, 378, 337);
		contentPane.add(scrollPane);
		
		listComandas = new JList<>();
		scrollPane.setViewportView(listComandas);
		
		btnCerrar = new JButton("Cerrar comanda");
		btnCerrar.setActionCommand("Cerrar");
		btnCerrar.setBounds(197, 398, 116, 23);
		contentPane.add(btnCerrar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(61, 398, 89, 23);
		contentPane.add(btnAtras);
		
		lblNewLabel = new JLabel("Gestion comandas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(68, 11, 153, 21);
		contentPane.add(lblNewLabel);
		
		btnAgregarPedido = new JButton("Agregar pedido");
		btnAgregarPedido.setActionCommand("Agregar");
		btnAgregarPedido.setBounds(344, 398, 116, 23);
		contentPane.add(btnAgregarPedido);
		
		

	}
	
	public ComandaDTO getComanda() {
		return this.listComandas.getSelectedValue();
	}
	
	public void mostrar() {
		this.setVisible(true);
	}

	public void setListComandas(ComandaDTO[] comandas) {
		this.listComandas.setListData(comandas);
	}


	public void esconder() {
        this.setVisible(false);
    }

	public void setActionListener(ActionListener ac) {
		this.btnAgregarPedido.addActionListener(ac);
		this.btnCerrar.addActionListener(ac);
		this.btnAtras.addActionListener(ac);
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
	public void mouseReleased(MouseEvent e) {
		this.btnCerrar.setEnabled(this.listComandas.getSelectedValue() != null );
		this.btnAgregarPedido.setEnabled(this.listComandas.getSelectedValue() != null);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
