package ordenacion_1;

import java.util.Random;

public class Ascension {

	public static void main(String[] args) {
		
		/*
		 * Comparar por pares el actual con el siguiente
		 * Ver cuál es el mayor
		 * Si el actual es mayor que el siguiente, se intercambian
		 */
		
		Random r = new Random();
		int[] v = new int[20];
		int aux = 0;
		
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(200);
		}
		
		System.out.println("\n---------- SIN ORDENAR ----------\n");
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}
		
		for (int i = 0; i < v.length - 1; i++) { // ORDENACIÓN DEL ARRAY
			
			for (int j = 0; j < v.length - 1; j++) {
				
				if (v[j] > v[j+1]) {
					aux = v[j];
					v[j] = v[j+1];
					v[j+1] = aux;
				}
			}
		}
		
		System.out.println("\n---------- ORDENADOS ----------\n");
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}
	}

}
