import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Introduzca un n�mero:  ");
		Scanner s1 = new Scanner(System.in);
		int numero = s1.nextInt();
		
		if (numero>0) {
			System.out.println("El n�mero " + numero + " es positivo");
		} else if (numero<0) {
			System.out.println("El n�mero " + numero + " es negativo");
		} else System.out.println("El n�mero es cero");
	}

}
