package com.grupo8.app.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.grupo8.app.dto.PromoFijaDTO;
import com.grupo8.app.dto.PromoTemporalDTO;
import com.grupo8.app.dto.PromoTemporalRequest;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class VistaNuevaPromoPorMedioDePago extends JFrame {

	private final JCheckBox chckbxLunes;
	private final JCheckBox chckbxMartes;
	private final JCheckBox chckbxMiercoles;
	private final JCheckBox chckbxJueves;
	private final JCheckBox chckbxViernes;
	private final JCheckBox chckbxSabado;
	private final JCheckBox chckbxDomingo;

	private JPanel General;
	private ActionListener actionListener;
	private JButton btnVolver;
	private JTextField textFieldNombrePromocion;
	private JTextField textFieldMedioDePago;
	private JTextField textFieldPorcentajeDescuento;
	private JButton btnAceptar;
	private JCheckBox chkBtnAcumulable;
	private JCheckBox chkBtnActivo;
	
	public VistaNuevaPromoPorMedioDePago() {
		setTitle("Nuevo Promocion por Medio de Pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 428, 587);
		General.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre de la promo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		textFieldNombrePromocion = new JTextField();
		panel_1.add(textFieldNombrePromocion);
		textFieldNombrePromocion.setColumns(10);
		
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Medio de pago");
		lblNewLabel_5.setBounds(85, 11, 133, 25);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_11.add(lblNewLabel_5);
		
		textFieldMedioDePago = new JTextField();
		textFieldMedioDePago.setColumns(10);
		textFieldMedioDePago.setBounds(242, 17, 86, 20);
		panel_11.add(textFieldMedioDePago);
		
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblrDelProducto = new JLabel("Porcentaje de descuento");
		lblrDelProducto.setBounds(85, 11, 220, 25);
		lblrDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblrDelProducto);
		
		textFieldPorcentajeDescuento = new JTextField();
		textFieldPorcentajeDescuento.setColumns(10);
		textFieldPorcentajeDescuento.setBounds(315, 17, 56, 20);
		panel_1_1.add(textFieldPorcentajeDescuento);
		
		JPanel panel_1_2 = new JPanel();
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		chkBtnActivo = new JCheckBox("Activo");
		chkBtnActivo.setBounds(71, 7, 351, 48);
		chkBtnActivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_2.add(chkBtnActivo);
		
		chkBtnAcumulable = new JCheckBox("Acumulable");
		chkBtnAcumulable.setBounds(71, 71, 340, 48);
		chkBtnAcumulable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_2.add(chkBtnAcumulable);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnAceptar);

		chckbxMartes = new JCheckBox("MARTES");
		chckbxMartes.setBounds(182, 56, 97, 23);
		panel_1_1.add(chckbxMartes);

		chckbxViernes = new JCheckBox("VIERNES");
		chckbxViernes.setBounds(293, 37, 97, 23);
		panel_1_1.add(chckbxViernes);

		chckbxSabado = new JCheckBox("SABADO");
		chckbxSabado.setBounds(293, 63, 97, 23);
		panel_1_1.add(chckbxSabado);

		chckbxLunes = new JCheckBox("LUNES");
		chckbxLunes.setBounds(182, 30, 97, 23);
		panel_1_1.add(chckbxLunes);

		chckbxMiercoles = new JCheckBox("MIERCOLES");
		chckbxMiercoles.setBounds(182, 79, 97, 23);
		panel_1_1.add(chckbxMiercoles);

		chckbxJueves = new JCheckBox("JUEVES");
		chckbxJueves.setBounds(182, 105, 97, 23);
		panel_1_1.add(chckbxJueves);

		chckbxDomingo = new JCheckBox("DOMINGO");
		chckbxDomingo.setBounds(293, 89, 97, 23);
		panel_1_1.add(chckbxDomingo);
		
	}


 public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
        this.btnVolver.addActionListener(actionListener);
        this.btnAceptar.addActionListener(actionListener);
        this.chkBtnAcumulable.addActionListener(actionListener);
        this.chkBtnActivo.addActionListener(actionListener);
        this.actionListener = actionListener;
        
	}

	

	
	public void limpiaCampos() {
		
	}

	public void mostrar() {
		this.setVisible(true);
		
	}

	public void esconder() {
		this.setVisible(false);
		
	}

	public void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void mensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		
	}

	public PromoTemporalRequest getFormulario() {
	    PromoTemporalRequest request = new PromoTemporalRequest();
		request.setFormaPago(this.textFieldMedioDePago.getText());
		request.setPorcentajeDescuento(Integer.parseInt(this.textFieldPorcentajeDescuento.getText()));
		request.setAcumulable(this.chkBtnAcumulable.isSelected());
		request.setDiasPromo(this.getDiasSelecccionados());
		request.setActiva(this.chkBtnActivo.isSelected());
		return request;
	}

	public List<DayOfWeek> getDiasSelecccionados() {
		List<DayOfWeek> dias = new ArrayList<DayOfWeek>();
		if(this.chckbxLunes.isSelected()) {
			dias.add(DayOfWeek.MONDAY);
		}
		if(this.chckbxMartes.isSelected()) {
			dias.add(DayOfWeek.TUESDAY);
		}
		if(this.chckbxMiercoles.isSelected()) {
			dias.add(DayOfWeek.WEDNESDAY);
		}
		if(this.chckbxJueves.isSelected()) {
			dias.add(DayOfWeek.THURSDAY);
		}
		if(this.chckbxViernes.isSelected()) {
			dias.add(DayOfWeek.FRIDAY);
		}
		if(this.chckbxSabado.isSelected()) {
			dias.add(DayOfWeek.SATURDAY);
		}
		if(this.chckbxDomingo.isSelected()) {
			dias.add(DayOfWeek.SUNDAY);
		}

		return dias;
	}

	
}
