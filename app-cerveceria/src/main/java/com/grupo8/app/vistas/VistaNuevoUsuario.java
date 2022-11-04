package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.grupo8.app.dto.AddOperarioRequest;

import dto.RegistroRequestEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaNuevoUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldNombreCompleto;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private String nombreCompleto;
	private String usuario;
	private String password;
	private ActionListener actionListener; 
	private JButton btnRegistrar ;
	private JButton btnAtras ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoUsuario frame = new VistaNuevoUsuario();
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
	public VistaNuevoUsuario() {
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textFieldNombreCompleto = new JTextField();
		textFieldNombreCompleto.setBounds(182, 34, 232, 20);
		panel.add(textFieldNombreCompleto);
		textFieldNombreCompleto.setColumns(10);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo");
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreCompleto.setBounds(10, 30, 157, 22);
		panel.add(lblNombreCompleto);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(185, 95, 164, 20);
		panel.add(textFieldUsuario);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setColumns(10);
		textFieldContrasena.setBounds(186, 156, 164, 20);
		panel.add(textFieldContrasena);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(10, 94, 157, 22);
		panel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(10, 156, 92, 22);
		panel.add(lblPassword);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(215, 228, 209, 23);
		panel.add(btnRegistrar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(0, 228, 209, 23);
		panel.add(btnAtras);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setActionListener(ActionListener actionListener) {
		   this.actionListener=actionListener;
		   this.btnAtras.addActionListener(actionListener);
	       this.btnRegistrar.addActionListener(actionListener);
		}

	
	public void keyReleased(KeyEvent e) {
		this.nombreCompleto=this.textFieldNombreCompleto.getText();
		this.usuario=this.textFieldUsuario.getText();
		this.password=this.textFieldContrasena.getText();
		
		this.btnRegistrar.setEnabled(
		nombreCompleto.length()>0 && usuario.length()>0 && password.length()>0);
	}
		
		/*public RegistroRequestUsuario getFormulario() {
			
			AddOperarioRequest req= new RegistroRequestEmpleado(this.nombre,this.apellido,this.telefono,
			this.usuario,this.contrasena,this.email,this.edadI);
			
			System.out.println(req.getNombreUsuario() + " | " + req.getNombre());
			
			return req;
		}*/
}
