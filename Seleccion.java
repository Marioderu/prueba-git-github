package ordenacion_1;

import java.util.Random;

public class Seleccion {

	public static void main(String[] args) {
		
		/*
		 * Seleccionar el número más pequeño en cada vuelta
		 * E intercambiarlo por el número actual
		 */

		Random r = new Random();
		int[] v = new int[100];
		int aux = 0, menor;
		
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(200);
		}
		
		System.out.println("\n---------- SIN ORDENAR ----------\n");
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
		
		for (int i = 0; i < v.length - 1; i++) {
			
			menor = i;
			
			for (int j = i + 1; j < v.length; j++) {
				
				if(v[j] < v[menor])
					menor = j;
			}
			
			if (menor != i) {
				
				aux = v[i];
				v[i] = v[menor];
				v[menor] = aux;
			}
		}
		
		System.out.println("\n---------- ORDENADOS ----------\n");
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}

}
