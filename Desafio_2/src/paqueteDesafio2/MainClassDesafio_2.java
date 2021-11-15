package paqueteDesafio2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainClassDesafio_2 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
	    System.out.println("Inicio Ejecucion: " +formatTime.format(LocalDateTime.now()));
	    
		Pais argentina = new Pais ("ARG","Argentina",54);
		Pais bolivia = new Pais ("BOL","Bolivia",591);
		Pais brasil = new Pais ("BRA","Brasil",55);
		Pais chile = new Pais ("CHI","Chile",56);
		Pais colombia= new Pais ("COL","Colombia",57);
		Pais ecuador = new Pais ("ECU","Ecuador",51);
		Pais paraguay = new Pais ("PGY","Paraguay",595);
		Pais peru = new Pais ("PER","Peru",51);
		Pais uruguay = new Pais ("UGY","Uruguay",598);
		Pais venezuela = new Pais ("VEN","Venezuela",58);

		
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
		
		
		 System.out.println(listPaises);
		//listPaises.forEach();
		
		
		

	    System.out.println("Fin Ejecucion: " +formatTime.format(LocalDateTime.now()));	
	}

}
