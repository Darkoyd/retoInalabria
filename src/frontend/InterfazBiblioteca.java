/**
 * Clase principal de la biblioteca.
 */
package frontend;

import javax.swing.JFrame;

import backend.Biblioteca;

/**
 * @author Nicol�s Londo�o
 */
public class InterfazBiblioteca extends JFrame 
{
	//----------------------------------------------------------------------------------
	//Atributos y Constantes
	//----------------------------------------------------------------------------------

	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------------------
	//M�todos
	//----------------------------------------------------------------------------------
	/*
	 * M�todo constructor de la interf�z
	 */
	public InterfazBiblioteca(Biblioteca servidorCupiBlog)
	{

	}
	/**
	 * M�todo principal de la aplicaci�n
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
