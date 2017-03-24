package com.tdd.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.tdd.archivosplanos.Chooser;
import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.RegresionLineal;
import com.tdd.estadisticadev.Sumatorias;
import com.tdd.listas.ListaEnlazada;

public class Main {

	static final String direccionX = Chooser.rutaArchivo();
	static final String direccionY = Chooser.rutaArchivo();
	
	public static void main(String[] args) {
		realizarCalculos();
	}
	
	public static void realizarCalculos(){
		RegresionLineal regresion = new RegresionLineal();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		Sumatorias sumatoria = new Sumatorias();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
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
		double sumatoriaYCuadrado = sumatoria.calcularSumatoriaCuadradaLista(l2);
		double beta1 = regresion.calcularBeta1(sumatoriaXY, n, promedioX, promedioY, sumatoriaXCuadrado);
		System.out.println("El resultado de Beta1 es: "+ beta1);
		double beta0 = regresion.calcularBeta0(beta1, promedioX, promedioY);
		System.out.println("El resultado de Beta0 es: "+ beta0);
		double rxy = regresion.calcularRxy(n, sumatoriaXY, sumatoriaX, sumatoriaY, sumatoriaXCuadrado, sumatoriaYCuadrado);
		System.out.println("El resultado de Rxy es: "+ rxy);
		double rCuadrado = regresion.calcularRCuadrado(rxy);
		System.out.println("El resultado de R cuadrado es: "+ rCuadrado);
		double yk = regresion.calcularYk(beta1, beta0, xk);
		System.out.println("El resultado de Yk es: "+ yk);
	}

}
