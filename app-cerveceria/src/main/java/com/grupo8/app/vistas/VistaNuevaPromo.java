package com.grupo8.app.vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaNuevaPromo extends JFrame {
    private JPanel contentPane;
    private JButton btnPromoProducto;
    private JButton btnPromoCant;

    private JButton btnVolver;
    private JButton btnPromoMedioPago;

    public VistaNuevaPromo() {
        setTitle("Crear promociones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 532, 464);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_4 = new JPanel();
        panel.add(panel_4);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lblNewLabel_1);

        btnPromoCant = new JButton("Promocion por cantidad");
        btnPromoCant.setActionCommand("PROMO_CANTIDAD");
        btnPromoCant.setPreferredSize(new Dimension(250, 45));
        btnPromoCant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel_4.add(btnPromoCant);
        btnPromoCant.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        btnPromoMedioPago = new JButton("Promocion por medio de pago");
        btnPromoMedioPago.setActionCommand("PROMO_MEDIO_PAGO");
        btnPromoMedioPago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnPromoMedioPago.setPreferredSize(new Dimension(250, 45));
        panel_6.add(btnPromoMedioPago);
        btnPromoMedioPago.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);

        btnPromoProducto = new JButton("Promocion por producto");
        btnPromoProducto.setActionCommand("PROMO_PRODUCTO");
        btnPromoProducto.setPreferredSize(new Dimension(250, 45));
        panel_1.add(btnPromoProducto);
        btnPromoProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BorderLayout(0, 0));

        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER");
        btnVolver.setPreferredSize(new Dimension(250, 45));
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_3.add(btnVolver);
    }

    public void setActionListener(ActionListener actionListener) {

        this.btnVolver.addActionListener(actionListener);
        this.btnPromoProducto.addActionListener(actionListener);
        this.btnPromoCant.addActionListener(actionListener);
        this.btnPromoMedioPago.addActionListener(actionListener);

    }
    public void mostrar() {
        this.setVisible(true);

    }

    public void esconder() {
        this.setVisible(false);

    }
}
