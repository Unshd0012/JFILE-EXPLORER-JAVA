package com.uns.files;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Acciones {

	public Image buscarIcono(String name) {
		Image imagen=null;
		
		if(name.isBlank()||name.isEmpty()) {
			
		}else {
			if(name.contains(".xls")) {
				imagen = new ImageIcon(getClass().getResource("/res/excel.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
			if(name.contains(".docx")||name.contains(".doc")||name.contains(".DOC")) {
				imagen = new ImageIcon(getClass().getResource("/res/word.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
			if(name.contains(".pdf")) {
				imagen = new ImageIcon(getClass().getResource("/res/pdf.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
			if(name.contains(".jpg")||name.contains(".png")||name.contains(".jpeg")||name.contains(".gif")) {
				imagen = new ImageIcon(getClass().getResource("/res/imagen.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".xml")) {
					imagen = new ImageIcon(getClass().getResource("/res/xml.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".exe")) {
					imagen = new ImageIcon(getClass().getResource("/res/exe.jpeg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".java")) {
					imagen = new ImageIcon(getClass().getResource("/res/jar.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".pptx")) {
					imagen = new ImageIcon(getClass().getResource("/res/pptx.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".html")||name.contains(".HTML")) {
					imagen = new ImageIcon(getClass().getResource("/res/html.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".jar")) {
					imagen = new ImageIcon(getClass().getResource("/res/jar.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else
				if(name.contains(".mp4")||name.contains(".mkv")||name.contains(".wmv")) {
					imagen = new ImageIcon(getClass().getResource("/res/video.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}else {
					imagen = new ImageIcon(getClass().getResource("/res/x.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			}
			
			
			
		}
		
		return imagen;
	}
	
	
	public static boolean esImagen(String ruta) {
		boolean b = false;
		
		
		if(ruta.contains(".png")) {
			b=true;
		}else if(ruta.contains(".jpeg")) {
			b=true;
		}else if(ruta.contains(".jpg")) {
			b=true;
		}else if(ruta.contains(".bmp")) {
			b=true;
		}else if(ruta.contains(".gif")) {
			b=true;
		}else if(ruta.contains(".jpeg")) {
			b=true;
		}else if(ruta.contains(".jpeg")) {
			b=true;
		}else if(ruta.contains(".jpeg")) {
			b=true;
		}else if(ruta.contains(".jpeg")) {
			b=true;
		}
		
		
		return b;
	}
}
