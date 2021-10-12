package evaluable2;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String ficheroLectura, ficheroEscritura;
	private String textoBuscar, textoReemplazar;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}
	
	//METODO DONDE SE ENLAZAN LOS METODOS CON LA INTERFAZ GRAFICA:
	public void control() {
		ficheroLectura = modelo.ficheroLectura();
		ficheroEscritura = modelo.ficheroEscritura();
		
		mostrarFichero(ficheroLectura, 1);
		
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				textoBuscar = vista.getTextFieldBuscar().getText();
				
				modelo.buscarTexto(textoBuscar);
				
				JOptionPane.showMessageDialog(null, modelo.buscarTexto(textoBuscar));
			}
		};
		
		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				textoBuscar = vista.getTextFieldBuscar().getText();
				textoReemplazar = vista.getTextFieldReemplazar().getText();
				modelo.reemplazarTexto(textoBuscar, textoReemplazar);
				mostrarFichero(ficheroEscritura,2);
			}
			
		};
		
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
		
	}
	
	//METODO PARA MOTRAR EN LA INTERFAZ GRAFICA LOS STRINGS GUARDADOS:
	private void mostrarFichero(String fichero, int numeroTextArea) {
		ArrayList<String> arrayLineas = modelo.contenidoFichero(fichero);
		for (String linea : arrayLineas) {
			if(numeroTextArea == 1) {
				vista.getTextAreaOriginal().append(linea+"\n");
			}else {
				vista.getTextAreaModificado().append(linea+"\n");
			}
		}
	}
}
