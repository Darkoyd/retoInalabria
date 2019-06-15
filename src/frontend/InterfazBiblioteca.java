/**
 * Clase principal de la biblioteca.
 */
package frontend;

import javax.swing.JFrame;

import backend.Biblioteca;

/**
 * @author Nicolás Londoño
 */
public class InterfazBiblioteca extends JFrame 
{
	//----------------------------------------------------------------------------------
	//Atributos y Constantes
	//----------------------------------------------------------------------------------

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------------------
	//Métodos
	//----------------------------------------------------------------------------------
	/*
	 * Método constructor de la interfáz
	 */
	public InterfazBiblioteca(Biblioteca servidorCupiBlog)
	{

	}
	/**
	 * Método principal de la aplicación
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			String archivoPropiedades = "./data/config.properties";
			Biblioteca biblioteca = new Biblioteca(archivoPropiedades);
			InterfazBiblioteca interfaz = new InterfazBiblioteca(biblioteca);
			interfaz.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
