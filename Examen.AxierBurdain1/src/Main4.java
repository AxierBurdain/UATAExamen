import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduzca el tama�o de la lista de n�meros: ");
		Scanner s1 = new Scanner(System.in);
		
		int longitud = s1.nextInt();
		int[] numeros = new int[longitud];
		int contador1 = 0;
		int contador2 = 0;
		

		for (int j = 0; j < numeros.length; j++) {
			System.out.println("Introduzca n�mero: " + (j + 1));
			numeros[j] = s1.nextInt();
		}

		Arrays.sort(numeros);

		int mayor = numeros[numeros.length - 1];
		int menor = numeros[0];

		for (int i = 0; i < numeros.length; i++) {

			if (mayor == numeros[i]) {
				contador1++;
			}

			if (menor == numeros[i]) {
				contador2++;
			}
		}

		System.out.println("El n�mero mayor es " + mayor + " y se repite " + contador1 + " veces");
		System.out.println("El n�mero menor es " + menor + " y se repite " + contador2 + " veces");

	}

}
