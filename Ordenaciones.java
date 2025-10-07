package ordenacion_1;

import java.util.Random;

public class Ordenaciones {

	static int[] insercion(int[] v) {
		
		int j, num;
		
		for (int i = 0; i < v.length; i++) {
			
			j = i - 1;
			num = v[i];
			
			while(j >= 0 && num < v[j]) {
				
				v[j + 1] = v[j];
				j--;
			}
			
			v[j + 1] = num;
		}
		
		return v;
	}
	
	static int[] ascension(int[] v) {
		
		int aux;
		
		for (int i = 0; i < v.length; i++) {
			
			for (int j = 0; j < v.length - 1; j++) {
				
				if (v[j] > v[j + 1]) {
					aux = v[j + 1];
					v[j + 1] = v[j];
					v[j] = aux;
				}
			}
			
		}
		
		return v;
	}
	
	static int[] seleccion(int[] v) {
		
		int menor, aux;
		
		for (int i = 0; i < v.length - 1; i++) {
			
			menor = i;
			
			for (int j = i + 1; j < v.length; j++) {
				
				if (v[menor] > v[j]) {
					menor = j;
				}
			}
			
			if (menor != i) {
				
				aux = v[menor];
				v[menor] = v[i];
				v[i] = aux;
				
			}
		}
		
		return v;
	}
	
	public static int[] rellenarVector(int[] v) {
		
		Random r = new Random();
		
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(100, 1000);
		}
		
		return v;
	}
	
	public static void mostrarVector(int[] v) {
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
	
		int[] v1 = new int[100];
		int[] v2 = new int[100];
		int[] v3 = new int[100];
		
		v1 = rellenarVector(v1);
		v2 = rellenarVector(v2);
		v3 = rellenarVector(v3);
		
		mostrarVector(v1);
		
		System.out.println("\n****************************************************************************************");
		System.out.println("**************************************  VECTOR 1  **************************************");
		System.out.println("****************************************************************************************\n");
		
		v1 = seleccion(v1);
		
		mostrarVector(v1);
		
		System.out.println("\n****************************************************************************************");
		System.out.println("**************************************  VECTOR 2  **************************************");
		System.out.println("****************************************************************************************\n");
		
		mostrarVector(v2);
		
		System.out.println("\n****************************************************************************************\n");
		
		v2 = ascension(v2);
		
		mostrarVector(v2);
		
		System.out.println("\n****************************************************************************************");
		System.out.println("**************************************  VECTOR 3  **************************************");
		System.out.println("****************************************************************************************\n");
		
		mostrarVector(v3);
		
		System.out.println("\n****************************************************************************************\n");
		
		v3 = seleccion(v3);
		
		mostrarVector(v3);
	}

}
