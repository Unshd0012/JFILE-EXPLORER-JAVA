package com.uns.GUI;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextPane;

public class ViewTxt extends JDialog {

	
	private JTextPane textPane;
	private JPanel panel;
	public ViewTxt() {
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		textPane = new JTextPane();
		JScrollPane scroll = new JScrollPane(textPane);
		
		panel.add(scroll);

	}
	
	
	public void setText(String ruta) {
		
		try {
			FileReader reader = new FileReader(ruta);
			int c =reader.read(); 
			StringBuilder s = new StringBuilder();
			BufferedReader re = new BufferedReader(reader);
			String linea;
			boolean b = true;
			
			while((linea=re.readLine())!=null) {
				s.append(linea+"\n");
			}
			    textPane.setText(s.toString());
			    validate();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
