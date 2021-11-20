package paquetes;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion = 5;
		Message log = new Message();    //CREO INSTANCIA DE MESSAGE
		setearLevelLog(Level.INFO);    //SETEO NIVEL INFO DEL LOG, PARA PODER MOSTRAR MSJ HASTA NIVEL -INFO-
		
		Scanner input = new Scanner(System.in);

//		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
//		System.out.println("INICIO EJECUCION" + formatTime.format(LocalDateTime.now()));
		log.logMjsInfo("SE INICI EJECUCION"); //MSJ INFO
		
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

		log.logMjsInfo("SE INSTANCIAN TODOS LOS PAISES SUDAMERICANOS"); //MSJ INFO
		
		List<Pais> listPaises = new ArrayList<Pais>();
		
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

		log.logMjsInfo("TODOS LOS PAISES INSTANCIADOS SE COLOCAN EN UNA LISTA DE PAISES"); //MSJ INFO
		
		do {

			System.out.println("\n"+"INGRESE UNA OPCION DEL MENU");
			System.out.println("1 - BUSCAR UN PAIS POR SU CODIGO DE AREA" + "\n" + "0 - SALIR");

			try {
				opcion = input.nextInt();   //SE LEE OPCION
				log.logMjsWarning("SE LEE Y CONVIERTE LO INGRESADO POR TECLADO A NUMERO"); //MSJ WARNING
				
			} catch (InputMismatchException ime) {
				log.logMjsFatal("NO SE PUDO REALIZAR LA CONVERSION A NUMERO"); //MSJ FATAL
				System.out.println("SE INGRESO UN VALOR NO NUMERICO");
				input.nextLine();
				opcion = 5;
			}
			
			
			if (opcion != 0 || opcion == 5) {
				
				if (opcion == 1) {
					
					do {
						
						System.out.println("INGRESE EL CODIGO DE AREA DEL PAIS A BUSCAR");
						try{
							int codArea = input.nextInt(); 
							
							log.logMjsWarning("SE LEE Y CONVIERTE LO INGRESADO POR TECLADO A NUMERO"); //MSJ WARNING
							
							List<Pais> listPaisArea = listPaises.stream()
									.filter(pais -> pais.getCodigoArea() == codArea)
									.collect(Collectors.toList());
											
							log.logMjsInfo("SE REALIZA EL FILTRADO DE PAISES POR CODIGO DE AREA"); //MSJ INFO
							
							if (listPaisArea.isEmpty()) {
	
								throw new RuntimeException();
							
							} else {
								System.out.println("\n"+"-------------------------------------------------------");
								System.out.println("EL PAIS CON EL CODIGO DE AREA (+" + codArea + ") ES :");
								for (Pais paises : listPaisArea) {
									System.out.println(paises.getNombre() + " (" + paises.getId() + ")");
								}
								System.out.println("-------------------------------------------------------");
							}
						
						} catch (InputMismatchException ime) {
							log.logMjsFatal("NO SE PUDO REALIZAR LA CONVERSION A NUMERO"); //MSJ FATAL
							System.out.println("SE INGRESO UN VALOR NO NUMERICO, INGRESE EL CODIGO DE AREA NUEVAMENTE"+"\n");
							input.nextLine();
							opcion = 5;
							
						} catch (RuntimeException re) {
							log.logMjsInfo("EL CODIGO POSTAL NO COINCIDE CON NINGUN PAIS"); //MSJ INFO
							System.out.println("\n"+"-------------------------------------------------------");
							System.out.println("NO SE ENCONTRO EL VALOR ESPERADO");
							System.out.println("-------------------------------------------------------");
							input.nextLine();
							opcion = 10;
						}
					}while(opcion==5);	
					
				} else {
					System.out.println("LA OPCION INGRESADA NO ES VALIDA. INGRESE NUEVAMENE SU OPCION");
				}

			} else {
				//System.out.println("FIN DE EJECUCION: " + formatTime.format(LocalDateTime.now()));
				log.logMjsInfo("SE FINALIZA EJECUCION");
			}
		
		}while(opcion!=0);

	input.close();

	}

	public static void setearLevelLog(Level Level) {

		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		org.apache.logging.log4j.core.config.Configuration conf = ctx.getConfiguration();
		conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(Level);
		ctx.updateLoggers(conf);

	}

}
