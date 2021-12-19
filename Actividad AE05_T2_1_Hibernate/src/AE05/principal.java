package AE05;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class principal {
	
	
		public Session conexion() {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			configuration.addClass(Libro.class);
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
			// Abre una nueva session de la session factory
			Session session = sessionFactory.openSession();
			return session;
			
		}
		
		
		public void mostrarLibro( int id) {
			//Metodo para mostrar un libro pasandole por larametro el ID del mismo
			//Si no encuentra ninguno se pasa por pantalla dicho resultado
			Session session = conexion();
			session.beginTransaction();
			Libro libro1 = (Libro) session.get(Libro.class, id);
			if(libro1 == null) {
				System.out.println("No hay libro con id = " + id);
			}else {
				System.out.println("Titulo del libro: " + libro1.getTitulo());
			}
			session.getTransaction().commit();
			session.close();
			
		}
		
		public void listaLibros() {
			//Metodo que muestra la lista de libros que hay en la base de datos
			Session session = conexion();
			session.beginTransaction();
			List listaLibros = new ArrayList();
			listaLibros = session.createQuery("FROM Libro").list();
			for (Object obj : listaLibros) {
				Libro lib = (Libro) obj;
				System.out.println(lib.toString());
			}
			session.getTransaction().commit();
			session.close();
		}
		
		public void crearLibro(String titulo, String autor, String anyoNacimiento, String anyoPublicacion, String editorial, String numPaginas) {
			//Metodo que crea un libro pasandole los parametros necesarios para la creacion del mismo
			//Al terminar se pasa por pantalla un mensaje con el identificador del libro creado
			Session session = conexion();
			session.beginTransaction();
			Libro libro2 = new Libro(titulo, autor, anyoNacimiento, anyoPublicacion, editorial, numPaginas);
			Serializable identificador = session.save(libro2);
			System.out.println("Libro creado con id: " + identificador);
			session.getTransaction().commit();
			session.close();
		}
		
		public void modificarLibro(int id) {
			//Metodo que modifica un libro en la base de datos, pasandole por parametros su ID
			//Si la creacion del libro es erronea, se pasa un mensaje indicandolo
			Session session = conexion();
			session.beginTransaction();
			Scanner teclado2 = new Scanner(System.in);
			
			try {
				Libro lib = (Libro) session.load(Libro.class, id);
				System.out.print("Titulo: ");
				String titulo = teclado2.nextLine();
				lib.setTitulo(titulo);
				System.out.print("Autor: ");
				String autor = teclado2.nextLine();
				lib.setAutor(autor);
				System.out.print("Anyo nacimiento: ");
				String anyoNacimiento = teclado2.nextLine();
				lib.setanyoNacimiento(anyoNacimiento);
				System.out.print("Anyo publicacion: ");
				String anyoPublicacion = teclado2.nextLine();
				lib.setanyoPublicacion(anyoPublicacion);
				System.out.print("Editorial: ");
				String editorial = teclado2.nextLine();
				lib.setEditorial(editorial);
				System.out.print("Numero paginas: ");
				String numPaginas = teclado2.nextLine();
				lib.setnumPaginas(numPaginas);
				
				session.update(lib);
				
			} catch(Exception e) {
				System.out.println("ERROR en la creacion del libro");
			}
			session.getTransaction().commit();
			session.close();
		}
		
		public void borrarLibro(int id) {
			//Metodo que a partir del ID borra el libro que coincida con el mismo
			//Al terminar se pasa un mensaje por pantalla de si ha sido exisoto o no
			Session session = conexion();
			session.beginTransaction();
			
			try {
				Libro lib1 = new Libro();
				lib1.setId(id);
				session.delete(lib1);
				System.out.println("Borrado");
				
			} catch(Exception e) {
				System.out.println("ERROR no se ha borrado el libro");
			}
			session.getTransaction().commit();
			session.close();
		}

		public static void main(String[] args) {
			
			boolean menu = false;
			principal prin = new principal();
			Scanner teclado = new Scanner(System.in);
			
			
			//Menu donde se elige la accion que se quiera realizar
			//Hasta que no se pulse el 6 para salir del menu, seguira pidiendo una opcion
			while(!menu){
				System.out.println("----MENU----");
				System.out.println("1. Mostrar todos los titulos de la biblioteca:");
				System.out.println("2. Mostrar la informacion detallada de un libro a partir de su id:");
				System.out.println("3. Anyadir un nuevo libro a la biblioteca:");
				System.out.println("4. Modificar atributos de un libro a partir de su id:");
				System.out.println("5. Borrar un libro a partir de su id:");
				System.out.println("6. Salir.");
				System.out.print("Elige una de las anteriores opciones: ");
				int seleccion = teclado.nextInt();
			
				switch (seleccion) {
					case 1:
						prin.listaLibros();
						break;
					case 2:
						System.out.print("Escribe la id:");
						int identificador = teclado.nextInt();
						prin.mostrarLibro(identificador);
						break;
					case 3:
						Scanner tecladoExtra = new Scanner(System.in);
						System.out.print("Titulo: ");
						String titulo = tecladoExtra.nextLine();
						System.out.print("Autor: ");
						String autor = tecladoExtra.nextLine();
						System.out.print("Anyo nacimiento: ");
						String anyoNacimiento = tecladoExtra.nextLine();
						System.out.print("Anyo publicacion: ");
						String anyoPublicacion = tecladoExtra.nextLine();
						System.out.print("Editorial: ");
						String editorial = tecladoExtra.nextLine();
						System.out.print("Numero paginas: ");
						String numPaginas = tecladoExtra.nextLine();
						
						prin.crearLibro(titulo, autor, anyoNacimiento, anyoPublicacion, editorial, numPaginas);
						break;
					case 4:
						System.out.print("ID del libro a modificar: ");
						int ident = teclado.nextInt();
						prin.modificarLibro(ident);
						break;
					case 5:
						System.out.print("ID del libro que queire borrar: ");
						int idLibroBorrar = teclado.nextInt();
						prin.mostrarLibro(idLibroBorrar);
						prin.borrarLibro(idLibroBorrar);
						System.out.println("Libro borrado.");
						break;
					case 6:
						menu = true;
						
						break;
				}
			}
			
			
		

		


		}
}

