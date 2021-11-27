package paquetes;

//IMPORTA DESDE LAS CLASES CARGADAS EN LAS DEPENDENDIAS DEL ARCHIVOS .JAR DEL DESAFIO ANTERIOR
import paqueteDesafio2.Pais;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// IMPORTA DESDE LAS DEPENDENCIAS
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion = 5;
		Message log = new Message();    //CREO INSTANCIA DE MESSAGE
		//setearLevelLog(Level.INFO);    //ES UN METODO PARA CONFIGURAR EL NIVEL DEL LOGGER. PERO DESPUES LO HICE FUNCIONAR CON EL LOG4J2.XML
		
		Scanner input = new Scanner(System.in);

	
		log.logMjsInfo("SE INICIA EJECUCION"); //MSJ INFO
		
			
		List<Pais> listPaises = new ArrayList<Pais>();
		listPaises.add(new Pais("ARG", "Argentina", 54));
		listPaises.add(new Pais("BOL", "Bolivia", 591));
		listPaises.add(new Pais("BRA", "Brasil", 55));
		listPaises.add(new Pais("CHI", "Chile", 56));
		listPaises.add(new Pais("COL", "Colombia", 57));
		listPaises.add(new Pais("ECU", "Ecuador", 51));
		listPaises.add(new Pais("PGY", "Paraguay", 595));
		listPaises.add(new Pais("PER", "Peru", 51));
		listPaises.add(new Pais("UGY", "Uruguay", 598));
		listPaises.add(new Pais("VEN", "Venezuela", 58));
		
		log.logMjsInfo("SE INSTANCIAN TODOS LOS PAISES SUDAMERICANOS Y SE COLOCAN EN UNA LISTA DE PAISES "); //MSJ INFO
		
		
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

	// METODO QUE ME PERMITIA SETEAR EL NIVEL DEL LOGGER. NO SE USA PORQUE SE CONFIGURO POR EL LOG4J2.XML EN CARPETA RESOURSES
	
	public static void setearLevelLog(Level Level) {

		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		org.apache.logging.log4j.core.config.Configuration conf = ctx.getConfiguration();
		conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(Level);
		ctx.updateLoggers(conf);

	}

}
