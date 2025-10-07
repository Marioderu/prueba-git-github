package ordenacion_1;

import java.util.Random;

public class Test {

	private Random r = new Random();
	private int[] v1;
	private int[] v2;
	private int[] v3;
	private int[] v4;

	public Test() {
		this.v1 = new int[100000];
		this.v2 = new int[100000];
		this.v3 = new int[100000];
		this.v4 = new int[100000];
		rellenarV();
	}

	public long nanoTime() {
		
		return System.nanoTime();
	}
	
	public void rellenarV4() {
		
		int num, j;
		
		for (int i = 0; i < v4.length; i++) {
			
			v4[i] = r.nextInt(100, 1000);
			
			num = v4[i];
			j = i - 1;
			
			while (j >= 0 && num < v4[j]) {
				
				v4[j + 1] = v4[j];
				j--;
			}
			
			v4[j + 1] = num;
		}
	}
	
	private void rellenarV() {

		for (int i = 0; i < v1.length; i++) {

			v1[i] = r.nextInt(100, 1000);
			v2[i] = r.nextInt(100, 1000);
			v3[i] = r.nextInt(100, 1000);
		}
	}

	public void ordenarV(int[] v, int n) {

		if (n == 1)
			seleccion(v);
		else if (n == 2)
			ascension(v);
		else
			insercion(v);
	}

	private void seleccion(int[] v) {

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
	}

	private void ascension(int[] v) {

		int aux;
		
		for (int i = 0; i < v.length - 1; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				
				if (v[j] > v[j + 1]) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
		}
	}

	private void insercion(int[] v) {

		int j, num;
		
		for (int i = 1; i < v.length; i++) {
			
			num = v[i];
			j = i - 1;
			
			while (j >= 0 && num < v[j]) {
				v[j+1] = v[j];
				j--;
			}
			
			v[j+1] = num;
		}
	}

	public void mostrarVector(int[] v) {

		for (int i = 0; i < v.length; i++) {
			System.out.print(" [ " + v[i] + " ]");
			if ((i + 1) % 25 == 0)
				System.out.println();
		}

		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}

	public static void main(String[] args) {

		Test t = new Test();
		long inicio, fin, totalV1, totalV2, totalV3, totalV4;
		
		System.out.println("\n----------------------- ARRAY 1 -----------------------\n");
		
		inicio = t.nanoTime();
		
		t.ordenarV(t.v1, 1);
		
		fin = t.nanoTime();
		
		totalV1 = fin - inicio;
		
		System.out.println("\n----------------------- ARRAY 2 -----------------------\n");
		
		inicio = t.nanoTime();
		
		t.ordenarV(t.v2, 2);
		
		fin = t.nanoTime();
		
		totalV2 = fin - inicio;
	
		System.out.println("\n----------------------- ARRAY 3 -----------------------\n");
		
		inicio = t.nanoTime();
		
		t.ordenarV(t.v3, 3);
		
		fin = t.nanoTime();
		
		totalV3 = fin - inicio;
		
		System.out.println("\n----------------------- ARRAY 4 -----------------------\n");
		
		inicio = t.nanoTime();
		
		t.rellenarV4();
		
		fin = t.nanoTime();
		totalV4 = fin - inicio;
		System.out.println("\nCUADRO COMPARATIVO DE TIEMPO TOTAL DE EJECUCIÓN\n");
		System.out.println("\t- Ordenación V1 -> " + totalV1 / 1_000_000_000.0 + " segundos");
		System.out.println("\t- Ordenación V2 -> " + totalV2 / 1_000_000_000.0 + " segundos");
		System.out.println("\t- Ordenación V3 -> " + totalV3 / 1_000_000_000.0 + " segundos");
		System.out.println("\t- Ordenación V4 -> " + totalV4 / 1_000_000_000.0 + " segundos");
	}

}
