package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

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

public class VistaGestionComandas extends JFrame {

	private JPanel contentPane;
	private JList<ComandaDTO> listComandas;
	private JButton btnAgregarPedido;
	private JButton btnCerrar;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;


	public VistaGestionComandas() {
		setTitle("Gestion Comandas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAgregarPedido = new JButton("Agregar pedido");
		btnAgregarPedido.setActionCommand("AGREGAR");
		btnAgregarPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregarPedido.setBounds(338, 76, 142, 32);
		panel.add(btnAgregarPedido);
		
		btnCerrar = new JButton("Cerrar comanda");
		btnCerrar.setActionCommand("CERRAR");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrar.setBounds(338, 211, 142, 32);
		panel.add(btnCerrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(348, 374, 122, 37);
		panel.add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 318, 354);
		panel.add(scrollPane);
		
		listComandas = new JList<>();
		scrollPane.setViewportView(listComandas);
		listComandas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblNewLabel = new JLabel("Gestionar Comandas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(49, 11, 154, 26);
		panel.add(lblNewLabel);
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
		this.btnVolver.addActionListener(ac);
	}
	
}
