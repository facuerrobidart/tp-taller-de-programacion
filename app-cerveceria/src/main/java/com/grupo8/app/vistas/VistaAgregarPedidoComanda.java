package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class VistaAgregarPedidoComanda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgregarPedidoComanda frame = new VistaAgregarPedidoComanda();
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
	public VistaAgregarPedidoComanda() {
		setTitle("Agregar pedido a comanda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar pedido a la comanda");
		btnAgregar.setBounds(126, 228, 173, 23);
		panel.add(btnAgregar);
		
		JList listProductos = new JList();
		listProductos.setBounds(49, 36, 334, 181);
		panel.add(listProductos);
		
		JLabel lbl = DefaultComponentFactory.getInstance().createTitle("Seleccione productos del pedido");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setBounds(114, 11, 211, 14);
		panel.add(lbl);
	}
}
