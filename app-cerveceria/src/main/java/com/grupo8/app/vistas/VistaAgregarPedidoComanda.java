package com.grupo8.app.vistas;

import com.grupo8.app.dto.ComandaDTO;
import com.grupo8.app.dto.PedidoRequest;
import com.grupo8.app.dto.ProductoDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaAgregarPedidoComanda extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField textFieldCantProd;
	private JList <ComandaDTO> listComandas;
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
		btnAgregar.setActionCommand("AGREGAR");
		btnAgregar.setBounds(251, 228, 173, 23);
		panel.add(btnAgregar);
		
		listProductos = new JList();
		listProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProductos.setBounds(170, 36, 140, 181);
		panel.add(listProductos);
		listProductos.addMouseListener(this);
		
		JLabel lbl = new JLabel("Seleccione productos");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(182, 11, 135, 14);
		panel.add(lbl);
		
		listComandas = new JList();
		listComandas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listComandas.setBounds(10, 36, 140, 181);
		panel.add(listComandas);
		listComandas.addMouseListener(this);
		
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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(0, 228, 89, 23);
		panel.add(btnVolver);
	}

	public void setActionListener(ActionListener lis){
		btnAgregar.addActionListener(lis);
	}
	public void mostrar() {
		btnAgregar.setEnabled(false);
		this.setVisible(true);
	}

	public void setListComandas(ComandaDTO[] comandas){
		listComandas.setListData(comandas);
	}

	public void setListProductos(ProductoDTO[] productos){
		listProductos.setListData(productos);
	}

	public ProductoDTO getProductoSelec() {
		return this.listProductos.getSelectedValue();
	}
	
	public ComandaDTO getComandaDTO() {
		return this.listComandas.getSelectedValue();
	}
	
	public int getCantProd() {
		return Integer.parseInt(textFieldCantProd.getText());
	}

	public void esconder() {
        this.setVisible(false);
    }

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public PedidoRequest getPedido() {
		PedidoRequest pedido = new PedidoRequest();
		pedido.setCantidad(this.getCantProd());
		pedido.setIdComanda(this.getComandaDTO().getId());
		pedido.setIdProducto(this.getProductoSelec().getId());
		return pedido;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (listProductos.getSelectedIndex() != -1 && listComandas.getSelectedIndex() != -1) {
			btnAgregar.setEnabled(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
