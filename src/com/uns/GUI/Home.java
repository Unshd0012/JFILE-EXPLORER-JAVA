package com.uns.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.uns.files.Acciones;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Home extends JFrame implements Runnable{

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	GridLayout grid;
	private JTextField inRuta;
	private JPopupMenu pop;
	private String archivoClick;
	private Thread t;

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("JExplorer");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		panelNorte.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panelNorte.getLayout();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		inRuta = new JTextField();
		inRuta.setBackground(Color.WHITE);
		inRuta.setEditable(false);
		panelNorte.add(inRuta);
		inRuta.setColumns(65);
		
		
		
		pop = new JPopupMenu();
		
		JMenuItem menu1 = new JMenuItem("Abrir");
		Image img1 = new ImageIcon(getClass().getResource("/res/abrir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu1.setIcon(new ImageIcon(img1));
		menu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				abrir(archivoClick);
				
				
			}
		});
		JMenuItem menu2 = new JMenuItem("Copiar");
		Image img2 = new ImageIcon(getClass().getResource("/res/copiar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu2.setIcon(new ImageIcon(img2));
		menu2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				copiarArchivo(archivoClick);
				
			}
		});
		
		JMenuItem menu3 = new JMenuItem("Mover");
		Image img3 = new ImageIcon(getClass().getResource("/res/move.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu3.setIcon(new ImageIcon(img3));
		menu3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moverArchivo(archivoClick);
				
			}
		});
		
		JMenuItem menu4 = new JMenuItem("Cambiar Nombre");
		Image img4 = new ImageIcon(getClass().getResource("/res/html.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu4.setIcon(new ImageIcon(img4));
		menu4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarNombre(archivoClick);
				
			}
		});
		
		JMenuItem menu5 = new JMenuItem("Crear Nueva Carpeta");
		Image img5 = new ImageIcon(getClass().getResource("/res/folder.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu5.setIcon(new ImageIcon(img5));
		menu5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getActionCommand());
				String nombre = JOptionPane.showInputDialog(contentPane,"ingresa nombre para la carpeta");
				if(nombre==null||nombre.isBlank()||nombre.isBlank()) {
					
				}else {
				crearCarpeta(inRuta.getText(), nombre);
				}
			}
		});
		JMenuItem menu6 = new JMenuItem("Eliminar");
		Image img6 = new ImageIcon(getClass().getResource("/res/borrar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu6.setIcon(new ImageIcon(img6));
		menu6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar(archivoClick);
				
			}
		});
		
		JMenuItem menu7 = new JMenuItem("Crear Nuevo Archivo");
		Image img7 = new ImageIcon(getClass().getResource("/res/nuevo.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		menu7.setIcon(new ImageIcon(img7));
		menu7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				crearArchivo(inRuta.getText());
			}
		});
		
		
		menu1.setFont(new Font("Arial", Font.BOLD, 20));
		menu2.setFont(new Font("Arial", Font.BOLD, 20));
		menu3.setFont(new Font("Arial", Font.BOLD, 20));
		menu4.setFont(new Font("Arial", Font.BOLD, 20));
		menu5.setFont(new Font("Arial", Font.BOLD, 20));
		menu6.setFont(new Font("Arial", Font.BOLD, 20));
		menu6.setFont(new Font("Arial", Font.BOLD, 20));
		menu7.setFont(new Font("Arial", Font.BOLD, 20));
		
		pop.add(menu1);
		pop.add(menu2);
		pop.add(menu3);
		pop.add(menu4);
		pop.add(menu5);
		pop.add(menu6);
		pop.add(menu7);
		
		JButton btnBuscar = new JButton("...");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarRuta(btnBuscar);
			}
		});
		panelNorte.add(btnBuscar);
		
	    panelSur = new JPanel();
	    panelSur.setBackground(Color.WHITE);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnAtras = new JButton("Regresar");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresarDirectorio();
			}
		});
		panelSur.add(btnAtras);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox==null) {}else{
					
					//System.out.println("combo box: "+ comboBox.getSelectedItem().toString());
					if(comboBox.getSelectedItem()==null) {
						
					}else {
					inRuta.setText(comboBox.getSelectedItem().toString());
				    mostrarArchivos(comboBox.getSelectedItem().toString());
				    validate();
				    
					}
			
				
				}
			}
		});
		comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comboBox.setMaximumRowCount(100);
		comboBox.setPreferredSize(new Dimension(500, 30));
		panelSur.add(comboBox);
		
		btnNewButton_1 = new JButton("New button");
		panelSur.add(btnNewButton_1);
		
		totalElementos = new JLabel("New label");
		totalElementos.setFont(new Font("SimSun", Font.PLAIN, 20));
		panelSur.add(totalElementos);
		
		panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(panelCentro);
		contentPane.add(scroll, BorderLayout.CENTER);
		grid = new GridLayout(10, 2, 5, 5);
		panelCentro.setLayout(grid);
		
		
	}
	
	public void buscarRuta(JButton boton) {
		
		String dir = inRuta.getText();
		JFileChooser chooser;
		if(dir==null||dir.isEmpty()||dir.isBlank()) {
			chooser= new JFileChooser("c:\\"+"\\");
		}else {
			chooser= new JFileChooser(dir);
		}
		
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int seleccion = chooser.showOpenDialog(contentPane);
		comboBox.removeAllItems();
		
		if(seleccion == 0) {
			inRuta.setText(chooser.getSelectedFile().getAbsolutePath());
			System.out.println("nombre: " + chooser.getSelectedFile().getAbsolutePath());
			mostrarArchivos(inRuta.getText());
			if(t==null) {
				t=new Thread(this);
				t.start();
			}else {
				
			}
			
		}else {
			
		}
	}
	
	
	public void mostrarArchivos(String ruta) {
		
		
		panelCentro.removeAll();
		File file = new File(ruta);
		inRuta.setText(file.getAbsolutePath()+"\\");
		comboBox.addItem(inRuta.getText());
		System.out.println("mostrar archivos: "+ file.getAbsolutePath());
		String archivos[] = file.list();
		
		if(archivos==null) {
			
		}else {
			int i = 0, filas=0;
			filas = (archivos.length/4);
			grid.setColumns(2);
			System.out.println("total de elementos: " +archivos.length);
			grid.setRows(filas);
			System.out.println("total de filas: " + filas);
		for(String f : archivos) {
			JButton boton = new JButton(f);
			boton.setBackground(Color.WHITE);
			boton.setBorderPainted(false);
			boton.setToolTipText(f);
			boton.setActionCommand((inRuta.getText()+f));
			boton.setComponentPopupMenu(pop);
			boton.setPreferredSize(new Dimension(200, 200));
			boton.addMouseListener(mousePressed);
			
			if(new File((inRuta.getText()+f)).isFile()) {
				boton.setIcon(new ImageIcon(new Acciones().buscarIcono(f)));
			}
			if(new File((inRuta.getText()+f)).isDirectory()) {
				Image img = new ImageIcon(getClass().getResource("/res/carpeta.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
				boton.setIcon(new ImageIcon(img));
			}
			
			i++;
			panelCentro.add(boton);
		}
		
		
		
		}
		panelCentro.setComponentPopupMenu(pop);
		validate();
		panelCentro.validate();
		int w = getWidth();
		setSize((w-2), getHeight());
		setSize(w, getHeight());
	}
	
	
	public void crearCarpeta(String ruta, String nombre) {
		
		File carpeta = new File(ruta+"\\"+nombre);
		boolean b = carpeta.exists();
		
		if(b) {
			JOptionPane.showMessageDialog(contentPane, "la carpeta: " + nombre+" ya existe en: " + ruta);
		}else {
			boolean bb = carpeta.mkdir();
			if(bb) {
				
				mostrarArchivos(ruta);
				
			}else {
				JOptionPane.showMessageDialog(contentPane, "Error al crear la carpeta");
			}
		}
		
		
	}
	
	public void eliminar(String ruta) {
		
		File file = new File(ruta);
		System.out.println("ruta en file: " + ruta);
		if(ruta==null||ruta.isBlank()||ruta.isEmpty()) {
			System.out.println("archivo null");
		}else {
			if(file.exists()) {
				try {
					int i = JOptionPane.showConfirmDialog(contentPane, "desea eliminar: " + ruta,"Eliminar",JOptionPane.YES_NO_OPTION);
					if(i==JOptionPane.YES_OPTION) {
				file.delete();
				System.out.println("archivo borrado: ");
					}
				mostrarArchivos(inRuta.getText());
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		}
		
	}
	
	public void regresarDirectorio() {
		String actual = inRuta.getText();
		String historial[]=new String[comboBox.getItemCount()];
		for(int j=0;j<comboBox.getItemCount();j++) {
		historial[j] = comboBox.getItemAt(j).toString();
		}
		int found=-1;
		System.out.println("tamaño de combo: " +historial.length);
		for(int i =0; i<historial.length;i++) {
			boolean b = actual.equals(historial[i]);
			System.out.println(historial[i].toString());
			if(b) {
				found=i;
				System.out.println("coincidencia encontrada en: "+i);
				if(i==0) {
					JOptionPane.showMessageDialog(contentPane, "Ya no hay mas directorios para regresar");
				}
				if(i!=0 ) {
				mostrarArchivos(comboBox.getItemAt((i-1)).toString());
				}
				break;
			}
			
		}
		if(found==-1) {
			JOptionPane.showMessageDialog(contentPane, "Ya no hay mas directorios para regresar");
		}
	}
	
	
	public void crearArchivo(String ruta) {
		
		String nombre = JOptionPane.showInputDialog(contentPane, "nombre para el archivo con extension");
		
		if(nombre==null||nombre.isBlank()||nombre.isEmpty()) {
			
		}else {
		
		File file = new File(ruta+nombre);
		System.out.println("nombre del archivo a crear: " + ruta+nombre);
		
		boolean b = file.exists();
		if(b) {
			JOptionPane.showMessageDialog(contentPane, "el archivo ya existe");
		}else {
			try {
				file.createNewFile();
				System.out.println("se creo archivo: " + ruta+nombre);
				file=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
	
	//ruta es la direccion donde se encuentra el archivo a renombrar
	public void cambiarNombre(String ruta) {
		
		//aqui se ingresa el nombre que remplazara al antiguo
		String nombre = JOptionPane.showInputDialog(contentPane, "Nuevo nombre");
		
if(nombre==null||nombre.isBlank()||nombre.isEmpty()) {
			
		}else {
		
		File file = new File(ruta);
		System.out.println("nombre del archivo a renombrar: " + ruta);
		
		boolean b = file.exists();
		if(b) {
			//inRuta es la ruta actual donde esta trabajando actualmente y se añade el nombre que llevara
			file.renameTo(new File(inRuta.getText()+nombre));
			file=null;
		}else {
			
		}
		}
		
		
	}
		
	public void moverArchivo(String archivo) {
		
		if(new File(archivo).isDirectory()) {
			JOptionPane.showMessageDialog(contentPane, "Aun no puedo mover directorios, pronto lo hare :)");
			return;
		}
		
		try {
		FileInputStream in = new FileInputStream(archivo);
		byte b[] = in.readAllBytes();
		System.out.println("tamaño de bytes: "+ b.length);
		
		JFileChooser cho = new JFileChooser(archivo);
		
		cho.setSelectedFile(new File(archivo));
		
		int ii = cho.showDialog(contentPane,"Mover Aqui");
		
		if(ii==JFileChooser.APPROVE_OPTION) {
			FileOutputStream out = new FileOutputStream(cho.getSelectedFile().getAbsoluteFile());
			
			for(int i = 0; i<b.length;i++) {
				out.write(b[i]);
			}
			System.out.println("escritura terminada: " + cho.getSelectedFile().getAbsolutePath());
			JOptionPane.showMessageDialog(contentPane, "Se movio el archivo con exito: "+cho.getSelectedFile().getAbsolutePath());
			out.close();
			b=null;
		}else {
			return;
		}
		
		in.close();
		new File(archivo).delete();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copiarArchivo(String archivo) {
		
		if(new File(archivo).isDirectory()) {
			JOptionPane.showMessageDialog(contentPane, "Aun no puedo copiar directorios, pronto lo hare :)");
			return;
		}
		
		try {
		FileInputStream in = new FileInputStream(archivo);
		byte b[] = in.readAllBytes();
		System.out.println("tamaño de bytes: "+ b.length);
		
		JFileChooser cho = new JFileChooser(archivo);
		cho.setSelectedFile(new File(archivo));
		
		int ii = cho.showDialog(contentPane,"Copiar Aqui");
		
		if(ii==JFileChooser.APPROVE_OPTION) {
			FileOutputStream out = new FileOutputStream(cho.getSelectedFile().getAbsoluteFile());
			
			for(int i = 0; i<b.length;i++) {
				out.write(b[i]);
			}
			System.out.println("copia terminada terminada: " + cho.getSelectedFile().getAbsolutePath());
			JOptionPane.showMessageDialog(contentPane, "Copia realizada con exito: "+cho.getSelectedFile().getAbsolutePath());
			out.close();
			b=null;
		}else {
			return;
		}
		
		in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void abrir(String ruta) {
		if(archivoClick==null||archivoClick.isEmpty()||archivoClick.isBlank()) {
			return;
		}
			
		if(new File(archivoClick).isDirectory()) {
				mostrarArchivos(archivoClick);
		}else {
				
		if(Acciones.esImagen(archivoClick)) {
					ViewImage view = new ViewImage(archivoClick);
					Image img = new ImageIcon(archivoClick).getImage();
					view.setImage(img);
					return;
				}else
		if(archivoClick.contains(".txt")) {
			ViewTxt view = new ViewTxt();
			view.setText(archivoClick);
			view.setTitle(archivoClick);
			return;
			
			
		}else {
		
		
		try {
			String cmd = "\""+archivoClick+"\"";
			System.out.println("cmd: start" + cmd);
		Process p = 	Runtime.getRuntime().exec(archivoClick);
		
		InputStreamReader in = new InputStreamReader(p.getInputStream());
		
		BufferedReader bu = new BufferedReader(in);
		
		boolean b = true;
		
		String salida;
		
		salida = bu.readLine();
		System.out.println("comando respuesta: " + salida);
		
		in.close();
		bu.close();
		
			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
				
			}
		
	}
	
	
	
MouseAdapter mousePressed = new MouseAdapter() {
	
	public void mousePressed(MouseEvent e) {
		
		//System.out.println("ruta pressed: " + ((JButton)e.getSource()).getActionCommand());
		archivoClick=((JButton)e.getSource()).getActionCommand();
		System.out.println("archivo click: " + archivoClick);
		if(e.getClickCount()==1) {
			Component botones[] = panelCentro.getComponents();
			for(Component c:botones) {
				c.setBackground(Color.WHITE);
			}
			((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
		}
       if(e.getClickCount()>=2) {
			
    	   String s = archivoClick;
    	   System.out.println("s: " + s);
    	   File file = new File(s);
			boolean dir = file.isDirectory();
			if(dir) {
				//directorios
			
				mostrarArchivos(file.toString());
				
			}else {
				//archivos
				abrir(archivoClick);
				
				
			}
		}
	}
};
	
	
	private JButton btnAtras;
	private JComboBox<String> comboBox;
	private JButton btnNewButton_1;
	private JLabel totalElementos;

	@Override
	public void run() {
		String lista[];
		Component listaMia[];
		boolean b = true;
		while(b) {
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				b=false;
			}
			
			lista = new File(inRuta.getText()).list();
			listaMia = panelCentro.getComponents();
			if(lista.length==listaMia.length) {
				//System.out.println("no se ha agregado ningun archivo");
				totalElementos.setText("elementos: " + listaMia.length);
				String nombre[]= new File(inRuta.getText()).list();
				String nombresMio[]=new String[listaMia.length];
				for(int i=0;i<listaMia.length;i++) {
					nombresMio[i]=((JButton)panelCentro.getComponent(i)).getText();
				}
				for(int j=0;j<listaMia.length;j++) {
					if(!nombre[j].equals(nombresMio[j])) {
						System.out.println("nombre distinto encontrado en elemento: " +j);
						mostrarArchivos(inRuta.getText());
						nombresMio[j]=nombre[j];
					}
				}
				
			}else {
				System.out.println("se agrego un archivo");
				mostrarArchivos(inRuta.getText());
				lista = new File(inRuta.getText()).list();
				listaMia = panelCentro.getComponents();
				totalElementos.setText("elementos: " + listaMia.length);
			}
		}
		
		
	}
}


