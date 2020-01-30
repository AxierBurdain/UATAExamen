import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduzca un número del 1 al 8:  ");
		Scanner s1 = new Scanner(System.in);
		int numero = s1.nextInt();

		switch (numero) {
		case 1:
			System.out.println("Microcoche");
			break;

		case 2:
			System.out.println("Automóvil Compacto");
			break;

		case 3:
			System.out.println("Automóvil Ultracompacto");
			break;

		case 4:
			System.out.println("Automóvil Familiar");
			break;

		case 5:
			System.out.println("Vehículo de lujo");
			break;

		case 6:
			System.out.println("Automóvil Deportivo");
			break;

		case 7:
			System.out.println("Descapotable");
			break;

		case 8:
			System.out.println("Todoterreno");
			break;

		}

	}

}
