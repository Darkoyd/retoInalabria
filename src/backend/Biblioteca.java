/**
 * Clase principal de el Back End
 */
package backend;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Nicolás Londoño
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
	 * Asociación con el administrador
	 */
	private Administrador admin;
	
	/**
	 * Método constructor de la biblioteca.
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
	 * Método que retorna el administrador de conexión con la BD.
	 * @return El administrados de comunicación.
	 */
	public Administrador darAdmin()
	{
		return admin;
	}
}
