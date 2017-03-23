package com.tdd.estadisticadev;

import com.tdd.listas.ListaEnlazada;
import com.tdd.listas.Nodo;

public class Sumatorias {
	
	public double calcularDatosLista(ListaEnlazada l1) {

		if (l1.esVacia()) {
			return 0;
		}
		double numeroValores = 0;
		Nodo dato = l1.primero();
		do {
			dato = dato.retorneSig();
			numeroValores += 1;
		} while (dato != l1.ultimo().retorneSig());
		return numeroValores;

	}

	public double calcularSumatoriaLista(ListaEnlazada l1) {

		if (l1.esVacia()) {
			return 0;
		}
		double sumaValores = 0;
		Nodo dato = l1.primero();
		do {
			sumaValores += dato.retorneDato();
			dato = dato.retorneSig();
		} while (dato != l1.ultimo().retorneSig());
		return sumaValores;

	}

	public double calcularMediaLista(double numeroValores, double sumaValores) {
		return sumaValores / numeroValores;
	}

	public double calcularSumatoriaCuadradaLista(ListaEnlazada l1) {

		if (l1.esVacia()) {
			return 0;
		}
		double sumaValoresCuadrados = 0;
		Nodo dato = l1.primero();
		do {
			sumaValoresCuadrados += Math.pow(dato.retorneDato(), 2);
			dato = dato.retorneSig();
		} while (dato != l1.ultimo().retorneSig());
		return sumaValoresCuadrados;

	}
	
	public double calcularSumatoriaXYLista(ListaEnlazada l1, ListaEnlazada l2) {
		if(verificarListas(l1, l2)==false){
			return 0;
		}
		double sumaValores = 0;
		Nodo datoL1 = l1.primero();
		Nodo datoL2 = l2.primero();
		do {
			sumaValores += (datoL1.retorneDato()*datoL2.retorneDato());
			datoL1 = datoL1.retorneSig();
			datoL2 = datoL2.retorneSig();
		} while (datoL1 != l1.ultimo().retorneSig() && datoL2 != l2.ultimo().retorneSig());
		return sumaValores;

	}
	
	public boolean verificarListas(ListaEnlazada lx, ListaEnlazada ly) {
		
		double tamanoLx = calcularDatosLista(lx);
		double tamanoLy = calcularDatosLista(ly);
		if (lx.esVacia() || ly.esVacia() || tamanoLx != tamanoLy ) {
			return false;
		}else{
			return true;
		}
	}
	
	
}
