package intraconsulta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Universidad uni = new Universidad("umlam");
		Integer opcion = 0;

		do {
			try {
				System.out.println("1: registrar alumno");
				System.out.println("2: lista de Alumno");
				System.out.println("3: registrar Materia");
				System.out.println("4: lista de Materia");
				System.out.println("5: crear curso");
				opcion = teclado.nextInt();
				teclado.nextLine();

				switch (opcion) {
				case 1:
					registrarAlumno(teclado, uni);
					break;
				case 2:
					imprimirAlumno(uni);
					break;
				case 3:
					registrarMateria(teclado, uni);
					break;
				case 4:
					uni.imprimirMaterias();
					break;
				case 5:

					System.out.print("Codigo de cursada:");
					Integer codigo = teclado.nextInt();
					teclado.nextLine();

					System.out.println("codigo de materia");
					Integer codigoMateria = teclado.nextInt();
					teclado.nextLine();
					Materia materia = uni.buscarMateria(codigoMateria);

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("error");
				teclado.nextLine();
			}
		} while (opcion != 6);

	}

	public static void registrarMateria(Scanner teclado, Universidad uni) {
		System.out.print("Codigo de Materia: ");
		Integer codigo = teclado.nextInt();
		teclado.nextLine();

		System.out.print("Nombre de Materia: ");
		String nombre = teclado.nextLine();

		Materia Materia = new Materia(codigo, nombre);

		uni.registrarMateria(Materia);
	}

	public static void imprimirAlumno(Universidad uni) {
		uni.imprimirAlumno();
	}

	public static void registrarAlumno(Scanner teclado, Universidad uni) {
		System.out.print("nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("apellido: ");
		String apellido = teclado.nextLine();
		System.out.print("dni: ");
		Integer dni = teclado.nextInt();
		teclado.nextLine();

		Alumno alumno = new Alumno(nombre, apellido, dni);
		uni.registrarAlumno(alumno);

	}

}
