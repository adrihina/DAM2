package evaluable2;

import java.io.*;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modelo {
	private String fichero_lectura;
	private String fichero_escritura;

	public Modelo() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "ficheroEscritura.txt";
	}

	//EL SIGUIENTE METODO DEVUELVE EL CONTENIDO DEL FICHERO QUE SE LE PASE:
	public ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return contenidoFichero;
	}

	public String ficheroLectura() {
		return fichero_lectura;
	}

	public String ficheroEscritura() {
		return fichero_escritura;
	}

	//METODO PARA BUSCAR EN EL TEXTO EL STRING QUE SE LE PASE POR PARAMETRO
	//DEVUELVE EL NUMERO DE VECES QUE SALE EL STRING:
	public int buscarTexto(String textoBuscar) {
		int contador = 0;
		String[] lineaAux;
		File f = new File(fichero_lectura);
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while(linea != null) {
				contenidoFichero.add(linea);
				lineaAux = linea.split(" ");
				for(int i = 0; i < lineaAux.length; i++) {
				if(lineaAux[i].equals(textoBuscar)) {
					contador++;
				}
			}	
			linea = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return contador;

	}

	//METODO QUE REEMPLAZA EL STRING QUE SE BUSCA POR EL QUE SELECCIONA EN LA OTRA CASILLA:
	public void reemplazarTexto(String textoBuscar, String textoReemplazar) {
		File f = new File(fichero_lectura);
		File f2 = new File(fichero_escritura);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine();
			
			while(linea != null) {	
			linea = linea.replaceAll(textoBuscar, textoReemplazar) + "\n";
			bw.write(linea);
			linea = br.readLine();
			}
			br.close();
			bw.close();
			fr.close();
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}
}
