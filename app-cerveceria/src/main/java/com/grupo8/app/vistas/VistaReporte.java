package com.grupo8.app.vistas;

import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.dto.ReporteMesaDto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaReporte extends JFrame implements MouseListener {

	private ActionListener actionListener;

	private JPanel contentPane;
	private JTextPane txtMinimo;
	private JTextPane txtMaximo;
	private JTextPane textIndividual;
	private JList<ReporteMesaDto> listMesa;
	private JList<MozoDTO> listMozos;
	private JButton btnVolver;
	private JButton btnVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReporte frame = new VistaReporte();
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
	public VistaReporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(204, 397, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Reportes de venta");
		lblTitulo.setBounds(176, 11, 164, 22);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblTitulo);
		
		JLabel lblMax = new JLabel("Mozo con mayores ventas");
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMax.setBounds(10, 69, 148, 14);
		contentPane.add(lblMax);
		
		JLabel lblMin = new JLabel("Mozo con menores ventas");
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMin.setBounds(346, 69, 148, 14);
		contentPane.add(lblMin);
		
		txtMaximo = new JTextPane();
		txtMaximo.setBounds(10, 94, 148, 69);
		contentPane.add(txtMaximo);
		
		txtMinimo = new JTextPane();
		txtMinimo.setBounds(346, 94, 148, 69);
		contentPane.add(txtMinimo);
		
		JLabel lblEstadisticasIndividuales = new JLabel("Estadisticas individuales:");
		lblEstadisticasIndividuales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstadisticasIndividuales.setBounds(10, 196, 148, 14);
		contentPane.add(lblEstadisticasIndividuales);
		
		textIndividual = new JTextPane();
		textIndividual.setBounds(346, 235, 148, 91);
		contentPane.add(textIndividual);
		
		listMozos = new JList<>();
		listMozos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMozos.setBounds(10, 235, 241, 91);
		contentPane.add(listMozos);
		
		btnVer = new JButton("Ver");
		btnVer.setActionCommand("VER");
		btnVer.setBounds(261, 267, 68, 23);
		contentPane.add(btnVer);
		
		JLabel lblMesa = new JLabel("Estadisticas de mesas");
		lblMesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMesa.setBounds(189, 69, 124, 14);
		contentPane.add(lblMesa);
		
		listMesa = new JList<>();
		listMesa.setBounds(176, 94, 148, 69);
		contentPane.add(listMesa);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btnVolver.addActionListener(actionListener);
		this.btnVer.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void setListMesa(ReporteMesaDto[] mesas) {
		this.listMesa.setListData(mesas);
	}

	public void setListMozos(MozoDTO[] mozos) {
		this.listMozos.setListData(mozos);
	}

	public void setTxtMaximo(String txtMaximo) {
		this.txtMaximo.setText(txtMaximo);
	}

	public void setTxtMinimo(String txtMinimo) {
		this.txtMinimo.setText(txtMinimo);
	}

	public void setTextIndividual(String textIndividual) {
		this.textIndividual.setText(textIndividual);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void mostrar() {
		this.setVisible(true);

	}

	public void esconder() {
		this.setVisible(false);
	}

	public MozoDTO getMozoSeleccionado() {
		return this.listMozos.getSelectedValue();
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
