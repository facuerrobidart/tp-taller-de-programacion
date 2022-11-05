package com.grupo8.app.vistas;

import com.grupo8.app.dto.ProductoDTO;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Font;

public class VistaEditarProducto extends JFrame implements MouseListener {

    private JPanel General;
    private ActionListener actionListener;
    private JButton btnVolver;
    private JList<ProductoDTO> listaAEditar;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaEliminarProducto frame = new VistaEliminarProducto();
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
    public VistaEditarProducto() {
        setTitle("Editar producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 646, 665);
        General = new JPanel();
        General.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(General);
        General.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 428, 587);
        General.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Seleccione el producto a editar");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(55, 26, 307, 77);
        panel.add(lblNewLabel);

        listaAEditar = new JList<>();
        listaAEditar.setBounds(10, 142, 408, 434);
        panel.add(listaAEditar);


        JPanel panel_15 = new JPanel();
        panel_15.setBounds(5, 592, 620, 29);
        General.add(panel_15);
        panel_15.setLayout(new GridLayout(1, 0, 0, 0));
        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_15.add(btnVolver);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setActionCommand("EDITAR");
        btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_15.add(btnEditar);

    }


    public void mostrar() {
        this.setVisible(true);

    }


    public void esconder() {
        this.setVisible(false);
    }

    public String obtenerIdProducto() {
        return listaAEditar.getSelectedValue().getId();
    }

    public void setListaAEditar(ProductoDTO[] productos) {
        listaAEditar.setListData(productos);
    }


    public void setActionListener(ActionListener actionListener) {
        // TODO Auto-generated method stub
        this.btnVolver.addActionListener(actionListener);

        this.actionListener = actionListener;
    }


    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

	/*	if(this.GrupoEstudios.getSelection()!=null)
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


    public void success(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
