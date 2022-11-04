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

public class VistaAsistenciaMozos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAsistenciaMozos frame = new VistaAsistenciaMozos();
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
	public VistaAsistenciaMozos() {
		setTitle("Asistencia mozos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Listo");
		btnAgregar.setBounds(126, 228, 173, 23);
		panel.add(btnAgregar);
		
		JList listaMozos = new JList();
		listaMozos.setBounds(49, 36, 334, 181);
		panel.add(listaMozos);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ASISTENCIA MOZOS");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesTitle.setBounds(148, 11, 138, 14);
		panel.add(lblNewJgoodiesTitle);
	}
}
