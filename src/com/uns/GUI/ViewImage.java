package com.uns.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ViewImage extends JDialog {

	private JLabel viewImage;
	private Image imagen;
	private JPanel pane;
	
	public ViewImage(String ruta) {
		setTitle(ruta);
		
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.WHITE);
		
		JScrollPane scroll = new JScrollPane(pane);
		
		add(scroll);
		
		
		
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		viewImage = new JLabel("");
		viewImage.setBackground(Color.WHITE);
		viewImage.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(viewImage, BorderLayout.CENTER);
		setVisible(true);
		
		
	}
	
	
	public void setImage(Image imagen) {
		this.imagen=imagen;
		viewImage.setIcon(new ImageIcon(this.imagen));
		if(imagen!=null) {
			setSize(this.imagen.getWidth(null)*2, this.imagen.getHeight(null)*2);
			setLocationRelativeTo(null);
		}
	}

}
