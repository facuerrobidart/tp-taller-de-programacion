package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;

import com.grupo8.app.dto.MozoDTO;
import java.awt.Font;

public class VistaAsistenciaMozos extends JFrame {

	private JPanel contentPane;
	private JButton btnListo;
	private JButton btnPresente;
	private JButton btnFranco ;
	private JButton btnAusente;
	private JList<MozoDTO> listaMozos;
	

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
		
		 btnListo = new JButton("Listo");
		btnListo.setBounds(126, 228, 173, 23);
		panel.add(btnListo);
		
	    listaMozos = new JList();
		listaMozos.setBounds(0, 36, 300, 181);
		panel.add(listaMozos);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Asistencia Mozos");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesTitle.setBounds(10, 11, 138, 14);
		panel.add(lblNewJgoodiesTitle);
		
		 btnPresente = new JButton("Presente");
		btnPresente.setBounds(310, 54, 89, 23);
		panel.add(btnPresente);
		
		 btnFranco = new JButton("Franco");
		btnFranco.setBounds(310, 106, 89, 23);
		panel.add(btnFranco);
		
		 btnAusente = new JButton("Ausente");
		btnAusente.setBounds(310, 158, 89, 23);
		panel.add(btnAusente);
	}
	public void mostrar() {
        this.setVisible(true);

    }


    public void esconder() {
        this.setVisible(false);
    }
}
