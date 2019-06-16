/**
 * Clase principal de el Back End
 */
package backend;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Nicol�s Londo�o
 *
 */
public class Biblioteca 
{

	//-------------------------------------------------------------------------
		//Atributos y Constantes
	//-------------------------------------------------------------------------
	
	/*
	 * Archivo de propiedades de la BD
	 */
	private Properties config;
	
	/*
	 * Asociaci�n con el administrador
	 */
	private Administrador admin;
	
	/**
	 * M�todo constructor de la biblioteca.
	 * @param archivoPropiedades Archivo con las propiedades de JDBC.
	 * @throws SQLException si encuentra un error de SQL.
	 * @throws Exception si falla al cargar las configuraciones.
	 */
	public Biblioteca(String archivoPropiedades) throws SQLException, Exception
	{
		cargarConfiguracion(archivoPropiedades);
		admin = new Administrador( config );
		admin.conectarABD( );
		admin.iniciarTablaLibros();
		admin.iniciarTablaPrestamos();
		admin.iniciarTablaUsuarios();
	}
	
	/*
	 * Metodo que carga la configuracion a partir de un archivo.
	 * @param archivoPropiedades Archivo con las propiedades de JDBC.
	 */
	private void cargarConfiguracion(String archivoPropiedades) throws Exception 
	{
		FileInputStream fis = new FileInputStream( archivoPropiedades );
		config = new Properties( );
		config.load( fis );
		fis.close( );
	}
	
	/**
	 * M�todo que retorna el administrador de conexi�n con la BD.
	 * @return El administrados de comunicaci�n.
	 */
	public Administrador darAdmin()
	{
		return admin;
	}
}
