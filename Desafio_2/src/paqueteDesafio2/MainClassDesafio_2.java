package paqueteDesafio2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClassDesafio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 5;
		int codArea =0;
		Scanner input = new Scanner(System.in);

		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
		System.out.println("Inicio Ejecucion: " + formatTime.format(LocalDateTime.now()));

		Pais argentina = new Pais("ARG", "Argentina", 54);
		Pais bolivia = new Pais("BOL", "Bolivia", 591);
		Pais brasil = new Pais("BRA", "Brasil", 55);
		Pais chile = new Pais("CHI", "Chile", 56);
		Pais colombia = new Pais("COL", "Colombia", 57);
		Pais ecuador = new Pais("ECU", "Ecuador", 51);
		Pais paraguay = new Pais("PGY", "Paraguay", 595);
		Pais peru = new Pais("PER", "Peru", 51);
		Pais uruguay = new Pais("UGY", "Uruguay", 598);
		Pais venezuela = new Pais("VEN", "Venezuela", 58);

		ArrayList<Pais> listPaises = new ArrayList<Pais>();
		listPaises.add(argentina);
		listPaises.add(bolivia);
		listPaises.add(brasil);
		listPaises.add(chile);
		listPaises.add(colombia);
		listPaises.add(ecuador);
		listPaises.add(paraguay);
		listPaises.add(peru);
		listPaises.add(uruguay);
		listPaises.add(venezuela);

		do {

			System.out.println("INGRESE UNA OPCION DEL MENU" + "\n");
			System.out.println("1 - BUSCAR UN PAIS POR SU CODIGO DE AREA" + "\n" + "0 - SALIR");

			try {
				opcion = input.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("SE INGRESO UN VALOR NO NUMERICO, VUELVA A INGRESAR LA OPCION DESEADA");
				input.nextLine();
				opcion = 5;
			}

			if (opcion != 0) {

				if (opcion == 1) {
					System.out.println("INGRESE EL CODIGO DE AREA DEL PAIS A BUSCAR ");
					
					try {
						codArea = input.nextInt(); // SI ME DA UN ERROR ME LO CATCHEA EL TRY DE ARRIBA
						
					} catch (InputMismatchException ime) {
						System.out.println("SE INGRESO UN VALOR NO NUMERICO, VUELVA A INGRESAR LA OPCION DESEADA");
						input.nextLine();
						
					}
					

					List<Pais> listPaisArea = listPaises.stream().filter(pais -> pais.getCodigoArea() == codArea)
							.collect(Collectors.toList());

					if (listPaisArea.size() == 0) {

						System.out.println(
								"NO SE ENCONTRARON REGISTROS CON EL CODIGO DE AREA INGRESADO (" + codArea + ")");
					} else {
						System.out.println("EL PAIS CON EL CODIGO DE AREA (+" + codArea + ") ES :");
						for (Pais paises : listPaisArea) {
							System.out.println(paises.getNombre() + " (" + paises.getId() + ")");
						}
					}
				} else {
					System.out.println("LA OPCION INGRESADA NO ES VALIDA. INGRESE NUEVAMENE SU OPCION");
				}

			} else {
				System.out.println("Fin Ejecucion: " + formatTime.format(LocalDateTime.now()));
			}

		} while (opcion != 0);

		input.close();

	}

}
