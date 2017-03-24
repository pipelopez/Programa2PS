package com.tdd.estadisticatest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.tdd.archivosplanos.Chooser;
import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.Sumatorias;
import com.tdd.listas.ListaEnlazada;

public class SumatoriasTest {

	static final String direccionX = Chooser.rutaArchivo();
	static final String direccionY = Chooser.rutaArchivo();
	
	@Test
	public void testVerificarListas() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		boolean resultado = sumatoria.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de listas vacías es: "+ resultado);
		assertEquals(false, resultado);
	}

	@Test
	public void testCalcularDatosLista() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		for (int i = 0; i < 10; i++) {
			l1.insertarFin(2.0);
		}
		double total = sumatoria.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en la lista es: "+ total);
		assertEquals(10, total, 0);
	}

	@Test
	public void testCalcularSumatoriaLista() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		for (int i = 0; i < 10; i++) {
			l1.insertarFin(2.0);
		}
		double suma = sumatoria.calcularSumatoriaLista(l1);
		System.out.println("La sumatoria de datos en la lista es: "+ suma);
		assertEquals(20, suma, 0);
	}

	@Test
	public void testCalcularMediaLista() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		for (int i = 0; i < 5; i++) {
			l1.insertarFin(2.0);
		}
		for (int i = 0; i < 5; i++) {
			l1.insertarFin(4.0);
		}
		double numeroValores = sumatoria.calcularDatosLista(l1);
		double sumaValores = sumatoria.calcularSumatoriaLista(l1);
		double media = sumatoria.calcularMediaLista(numeroValores, sumaValores);
		System.out.println("La media de datos de la lista es: "+ media);
		assertEquals(3, media, 0);
	}

	@Test
	public void testCalcularSumatoriaCuadradaLista() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		for (int i = 0; i < 10; i++) {
			l1.insertarFin(2.0);
		}
		double suma = sumatoria.calcularSumatoriaCuadradaLista(l1);
		System.out.println("La sumatoria de datos al cuadrado en la lista es: "+ suma);
		assertEquals(40, suma, 0);
	}

	@Test
	public void testCalcularSumatoriaXYLista() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		for (int i = 0; i < 10; i++) {
			l1.insertarFin(2.0);
			l2.insertarFin(3.0);
		}
		double suma = sumatoria.calcularSumatoriaXYLista(l1, l2);
		System.out.println("La sumatoria de XY en las listas es: "+ suma);
		assertEquals(60, suma, 0);
	}

	
	@Test
	public void testVerificarListasArchivos() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado = sumatoria.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de las listas es: "+ resultado);
		assertEquals(true, resultado);
	}
	
	@Test
	public void testCalcularDatosArchivo() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double total = sumatoria.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en la lista es: "+ total);
		assertEquals(10, total, 0);
	}
	
	@Test
	public void testCalcularSumatoriaArchivo() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double suma = sumatoria.calcularSumatoriaLista(l1);
		System.out.println("La sumatoria de datos en la lista es: "+ suma);
		//para columna1.txt es 3828 y para columna2.txt es 6389
		assertEquals(6389, suma, 0);
	}
	
	@Test
	public void testMediaColumna1() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double numeroValores = sumatoria.calcularDatosLista(l1);
		double sumaValores = sumatoria.calcularSumatoriaLista(l1);
		double resultadoMedia = sumatoria.calcularMediaLista(numeroValores, sumaValores);
		System.out.println("La media de datos en la lista es: "+ resultadoMedia);
		//para columna1.txt es 382.8 y para columna2.txt es 638.9
		assertEquals(382.8, resultadoMedia, 0.005);
	}
	
	@Test
	public void testCalcularSumatoriaCuadradaArchivo() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double suma = sumatoria.calcularSumatoriaCuadradaLista(l1);
		System.out.println("La sumatoria de datos al cuadrado en la lista es: "+ suma);
		//para columna1.txt es 2540284 y para columna2.txt es 7604693
		assertEquals(7604693, suma, 0);
	}
	
	@Test
	public void testCalcularSumatoriaXYArchivo() {
		Sumatorias sumatoria = new Sumatorias();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double suma = sumatoria.calcularSumatoriaXYLista(l1, l2);
		System.out.println("La sumatoria de XY en las listas es: "+ suma);
		assertEquals(4303108, suma, 0);
	}

}
