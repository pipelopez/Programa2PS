package com.tdd.estadisticadev;

public class RegresionLineal {

	public double calcularBeta1(double sumatoriaXY, double n, double promedioX, 
			double promedioY, double sumatoriaXCuadrado) {
		
		double beta1 = ((sumatoriaXY)-(n*promedioX*promedioY))/(sumatoriaXCuadrado-(n*Math.pow(promedioX, 2)));
		return beta1;

	}
	
	public double calcularBeta0(double beta1, double promedioX, double promedioY) {
		double beta0= promedioY-(beta1*promedioX);
		return beta0;
	}
	
	public double calcularRxy(double n, double sumatoriaXY, double sumatoriaX, double sumatoriaY, 
			double sumatoriaXCuadrado, double sumatoriaYCuadrado){
		double r = (n*sumatoriaXY- (sumatoriaX*sumatoriaY))/(Math.sqrt(((n*sumatoriaXCuadrado)-Math.pow(sumatoriaX, 2))*((n*sumatoriaYCuadrado)-Math.pow(sumatoriaY, 2))));
		return r;
	}
	
	public double calcularRCuadrado(double r){
		return Math.pow(r, 2);
	}
	
	public double calcularYk(double beta1, double beta0, double xk) {
		//xk es un proxy size de 386 LOC
		double yk = beta0 + beta1*xk;
		return yk;
	}
}
