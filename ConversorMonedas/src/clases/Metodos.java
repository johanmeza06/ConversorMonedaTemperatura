package clases;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Metodos {
	
	public String aMoneda(double cantidad, String moneda) {
		return "$ "+ Math.round(cantidad*100.0)/100.0+" "+ moneda;
	}
	// Se crea el siguiente metodo para convertir las monedas
	public void convertirMoneda(String de, String a,double conversion,double cantidad, JLabel lblResul) {
		switch(de) {
		case "CLP": //PESO CHILENO A OTRAS MONEDAS
			if(a.equals("USD")) {
				conversion = cantidad * 0.0012;
			}else if (a.equals("EUR")) {
				conversion = cantidad * 0.0011;
			}else if (a.equals("GBP")) {
				conversion = cantidad * 0.00096;
			}else if (a.equals("JPY")) {
				conversion = cantidad * 0.17;
			}else if (a.equals("KRW")) {
				conversion = cantidad * 1.57;
			}else { // CLP
				conversion = cantidad;
			}
			break;
		case "USD": //DOLAR A OTRAS MONEDAS
			if(a.equals("CLP")) {
				conversion = cantidad * 806.70;
			}else if (a.equals("EUR")) {
				conversion = cantidad * 0.89;
			}else if (a.equals("GBP")) {
				conversion = cantidad * 0.77;
			}else if (a.equals("JPY")) {
				conversion = cantidad * 139.41;
			}else if (a.equals("KRW")) {
				conversion = cantidad * 1266.42;
			}else {// USD
				conversion = cantidad;
			}
			break;
		case "EUR"://EURO A OTRAS MONEDAS
			if(a.equals("USD")) {
				conversion = cantidad * 1.12;
			}else if (a.equals("CLP")) {
				conversion = cantidad * 905.09;
			}else if (a.equals("GBP")) {
				conversion = cantidad * 0.87;
			}else if (a.equals("JPY")) {
				conversion = cantidad * 156.33;
			}else if (a.equals("KRW")) {
				conversion = cantidad * 1419.99;
			}else { // EUR
				conversion = cantidad;
			}
			break;
		case "GBP": //LIBRA ESTERLINA A OTRAS MONEDAS 
			if(a.equals("USD")) {
				conversion = cantidad * 1.29;
			}else if (a.equals("EUR")) {
				conversion = cantidad * 1.15;
			}else if (a.equals("CLP")) {
				conversion = cantidad * 1044.43;
			}else if (a.equals("JPY")) {
				conversion = cantidad * 180.37;
			}else if (a.equals("KRW")) {
				conversion = cantidad * 1638.35;
			}else { // GBP
				conversion = cantidad;
			}
			break;
		case "JPY": //YEN JAPONES A OTRAS MONEDAS
			if(a.equals("USD")) {
				conversion = cantidad * 0.0072;
			}else if (a.equals("EUR")) {
				conversion = cantidad * 0.0064;
			}else if (a.equals("GBP")) {
				conversion = cantidad * 0.0055;
			}else if (a.equals("CLP")) {
				conversion = cantidad * 5.79;
			}else if (a.equals("KRW")) {
				conversion = cantidad * 9.08;
			}else { // JPY
				conversion = cantidad;
			}
			break;
		case "KRW": //YON SUL COREANO A OTRAS MONEDAS
			if(a.equals("USD")) {
				conversion = cantidad * 0.00079;
			}else if (a.equals("EUR")) {
				conversion = cantidad * 0.00070;
			}else if (a.equals("GBP")) {
				conversion = cantidad * 0.0000061;
			}else if (a.equals("JPY")) {
				conversion = cantidad * 0.11;
			}else if (a.equals("CLP")) {
				conversion = cantidad * 0.64;
			}else { // KRW
				conversion = cantidad;
			}
			break;
			
		}
		lblResul.setText(aMoneda(cantidad, de)+" -> "+ aMoneda(conversion,a));
	}
	// se crea el siguiente metodo para convertir la temperatura
	public String aTemperatura(double cantidad, String grados) {
		return Math.round(cantidad*100.0)/100.0+" "+ grados;
	}
	public void convertirTemperatura(String de, String a,double conversion,double cantidad, JLabel lblResul) {
		switch (de) {
		case "°C":
			if (a.equals("°F")) {
				conversion = (cantidad * 9/5) + 32;
			}else {
				conversion = cantidad;
			}
			break;
		case "°F":
			if (a.equals("°C")) {
				conversion = (cantidad - 32)* 5/9;
			}else {
				conversion = cantidad;
			}
			break;
		}
		lblResul.setText(aTemperatura(cantidad, de)+" -> "+ aTemperatura(conversion,a));
	}
}
