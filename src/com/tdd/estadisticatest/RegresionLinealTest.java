package com.tdd.estadisticatest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.Test;

import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.RegresionLineal;
import com.tdd.estadisticadev.Sumatorias;
import com.tdd.listas.ListaEnlazada;

public class RegresionLinealTest {

	@Test
	public void testCalcularBeta1(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		String direccionX = rutaArchivo();
		String direccionY = rutaArchivo();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double sumatoriaXY = sumatoria.calcularSumatoriaXYLista(l1, l2);
		double n = sumatoria.calcularDatosLista(l1);
		double sumatoriaX = sumatoria.calcularSumatoriaLista(l1);
		double promedioX = sumatoria.calcularMediaLista(n, sumatoriaX); 
		double sumatoriaY = sumatoria.calcularSumatoriaLista(l2);
		double promedioY = sumatoria.calcularMediaLista(n, sumatoriaY);
		double sumatoriaXCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l1);
		double resultado = regresion.calcularBeta1(sumatoriaXY, n, promedioX, promedioY, sumatoriaXCuadrado);
		assertEquals(1.727932, resultado, 0.005);
	}
	
	@Test
	public void testCalcularBeta0(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		String direccionX = rutaArchivo();
		String direccionY = rutaArchivo();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double sumatoriaXY = sumatoria.calcularSumatoriaXYLista(l1, l2);
		double n = sumatoria.calcularDatosLista(l1);
		double sumatoriaX = sumatoria.calcularSumatoriaLista(l1);
		double promedioX = sumatoria.calcularMediaLista(n, sumatoriaX); 
		double sumatoriaY = sumatoria.calcularSumatoriaLista(l2);
		double promedioY = sumatoria.calcularMediaLista(n, sumatoriaY);
		double sumatoriaXCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l1);
		double beta1 = regresion.calcularBeta1(sumatoriaXY, n, promedioX, promedioY, sumatoriaXCuadrado);
		double resultado = regresion.calcularBeta0(beta1, promedioX, promedioY);
		assertEquals(-22.5525, resultado, 0.005);
		
	}
	
	@Test
	public void testCalcularRxy(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		String direccionX = rutaArchivo();
		String direccionY = rutaArchivo();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double sumatoriaXY = sumatoria.calcularSumatoriaXYLista(l1, l2);
		double n = sumatoria.calcularDatosLista(l1);
		double sumatoriaX = sumatoria.calcularSumatoriaLista(l1);
		double sumatoriaY = sumatoria.calcularSumatoriaLista(l2);
		double sumatoriaXCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l1);
		double sumatoriaYCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l2);
		double resultado = regresion.calcularRxy(n, sumatoriaXY, sumatoriaX, sumatoriaY, sumatoriaXCuadrado, sumatoriaYCuadrado);
		assertEquals(0.9545, resultado, 0.005);		
	}
	
	@Test
	public void testCalcularRCuadrado(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		String direccionX = rutaArchivo();
		String direccionY = rutaArchivo();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double sumatoriaXY = sumatoria.calcularSumatoriaXYLista(l1, l2);
		double n = sumatoria.calcularDatosLista(l1);
		double sumatoriaX = sumatoria.calcularSumatoriaLista(l1);
		double sumatoriaY = sumatoria.calcularSumatoriaLista(l2);
		double sumatoriaXCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l1);
		double sumatoriaYCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l2);
		double r = regresion.calcularRxy(n, sumatoriaXY, sumatoriaX, sumatoriaY, sumatoriaXCuadrado, sumatoriaYCuadrado);
		double resultado = regresion.calcularRCuadrado(r);
		System.out.println(resultado);
		assertEquals(0.9110637099775758, resultado, 0);
	}
	
	@Test
	public void testCalcularYk(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		String direccionX = rutaArchivo();
		String direccionY = rutaArchivo();
		try {
			l1 = lectorArchivo.leerArchivoDouble(direccionX);
			l2 = lectorArchivo.leerArchivoDouble(direccionY);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		double xk=386;//valor de proxy size LOC
		double sumatoriaXY = sumatoria.calcularSumatoriaXYLista(l1, l2);
		double n = sumatoria.calcularDatosLista(l1);
		double sumatoriaX = sumatoria.calcularSumatoriaLista(l1);
		double promedioX = sumatoria.calcularMediaLista(n, sumatoriaX); 
		double sumatoriaY = sumatoria.calcularSumatoriaLista(l2);
		double promedioY = sumatoria.calcularMediaLista(n, sumatoriaY);
		double sumatoriaXCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l1);
		double beta1 = regresion.calcularBeta1(sumatoriaXY, n, promedioX, promedioY, sumatoriaXCuadrado);
		double beta0 = regresion.calcularBeta0(beta1, promedioX, promedioY);
		double resultado = regresion.calcularYk(beta1, beta0, xk);
		assertEquals(644.4294, resultado, 0.005);
	}
	
	public String rutaArchivo() {
		String ruta = "";
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			ruta = chooser.getSelectedFile().getPath();
		}
		return ruta;
	}

}
