package ordenacion_1;

import java.util.Random;

public class Insercion {

	public static void main(String[] args) {
		
		/*
		 * En mi posición actual compruebo si el número actual
		 * es menor o mayor que alguno de los número anteriores
		 * En caso afirmativo, buscar dónde encaja el número
		 * Y reposicionar el resto de números para recolocarlos
		 * una posición hacia la derecha
		 */

		Random r = new Random();
		int[] v = new int[20];
		int aux, j;
		
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(10, 100);
			aux = v[i];
			j = i - 1;
			
			while (j >= 0 && aux < v[j]) {
				
				v[j + 1] = v[j];
				j--;
			}
			
			v[j + 1] = aux;
		}
		
		System.out.println("\n---------- ORDENADOS ----------\n");
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 10 == 0)
				System.out.println();
		}
	}
}
