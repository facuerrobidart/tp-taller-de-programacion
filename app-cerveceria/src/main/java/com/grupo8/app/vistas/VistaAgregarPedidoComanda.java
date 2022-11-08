package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;

import com.grupo8.app.dto.ComandaDTO;
import com.grupo8.app.dto.ProductoDTO;
import java.awt.Font;
import javax.swing.JTextField;

public class VistaAgregarPedidoComanda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCantProd;
	private JList <ComandaDTO> listComanda;
	private JButton btnAgregar;
	private JList<ProductoDTO> listProductos;

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
		
		btnAgregar = new JButton("Agregar pedido a la comanda");
		btnAgregar.setBounds(127, 228, 173, 23);
		panel.add(btnAgregar);
		
		listProductos = new JList();
		listProductos.setBounds(170, 36, 140, 181);
		panel.add(listProductos);
		
		JLabel lbl = new JLabel("Seleccione productos");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(182, 11, 135, 14);
		panel.add(lbl);
		
		listComanda = new JList();
		listComanda.setBounds(10, 36, 140, 181);
		panel.add(listComanda);
		
		JLabel lblNewLabel = new JLabel("Seleccione comanda ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 122, 14);
		panel.add(lblNewLabel);
		
		textFieldCantProd = new JTextField();
		textFieldCantProd.setBounds(328, 106, 86, 20);
		panel.add(textFieldCantProd);
		textFieldCantProd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese cantidad");
		lblNewLabel_1.setBounds(332, 62, 92, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("de productos");
		lblNewLabel_2.setBounds(334, 82, 80, 14);
		panel.add(lblNewLabel_2);
	}
	public void mostrar() {
        this.setVisible(true);

    }


    public void esconder() {
        this.setVisible(false);
    }
}
