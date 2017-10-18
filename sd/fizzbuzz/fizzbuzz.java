package sd.fizzbuzz;

/*Schreiben Sie ein Programm, das die Zahlen von 1 bis 100 ausgibt.
 * Bei jeder Zahl, die durch 5 teilbar ist, soll "fizz" ausgegeben werden
 *  und bei jeder Zahl, die durch 7 teilbar ist, soll "buzz" ausgegeben werden.
 *  Wenn die Zahl sowohl durch 7 als auch durch 5 teilbar ist, soll "fizzbuzz" ausgegeben werden.*/

public class fizzbuzz {
	
	/*hier globale Varablen wegen :
	 *  - Literale vermeiden,
	 *  - einfach Aenderungen an gut sichtbarer Stelle vornehmen zu koennen,
	 *  - einfache Parameteruebergabe  */
	
	private static int startwert = 1;
	private static int endwert = 100;
	private static String erg5Teiler = "fizz";
	private static String erg7Teiler = "buzz";
	
	public static void main (String[] args){
		/*die Strukturierung in 
		 * 		Eingabe, 
		 * 		Verarbeitung, 
		 * 		Ausgabe
		 *  ist hier eigentlich nicht noetig und dient nur zur Uebung, das wesentliche FizzBuzz passiert in der Methode verarbeitung() */
		
		String ergebnis = "";
		
		eingabe(args);
		ergebnis = verarbeitung();
		System.out.print(ergebnis);
		
		
	}

	private static void eingabe(String[] parameterArray){
		/*die Methode eingabe() kann natuerlich auch ganz anders aussehen - ueber eine Usereingabe z.B.
		 * ich wurde aber mal bei einem Vorstellungsgespraech ueber den Programmaufruf mit Parametern und Verwendung von args gefragt
		 * deswegen hier so, das Programm ist dadurch auch einfach zu testen*/
		
		int anzahlParameter = parameterArray.length;
		int fehlerLvl1 = 1; /*die Werte von fehlerLvl wurden willkuerlich gewaehlt und werden bei System.out() uebergeben, koennen hier angepasst werden */
		int fehlerLvl2 = 2;
		String fehlerZuVieleParameter = "zu viele Parameter";
		String fehlerParameterKeineZahlen = "Parameter sind keine Zahlen";
		
		/*Anzahl und Art der Parameter ueberprufen*/
		
		if (anzahlParameter > 2) {
			programmabruch(fehlerLvl1, fehlerZuVieleParameter);
		} 
		if((anzahlParameter > 0 && !parameterArray[0].trim().matches("\\d*")) || (anzahlParameter > 1 && !parameterArray[1].trim().matches("\\d*"))) {
			programmabruch(fehlerLvl2, fehlerParameterKeineZahlen);
		}
		
		/*Parameteruebergabe*/
		
		switch(anzahlParameter) {
			/*ich geh davon aus das meistens kein Parameter uebergeben wird, deswegen an 1. Position case 0 : break;*/
			case 0 : 
			break;
			case 1 : 
				startwert = Integer.parseInt(parameterArray[0]);
			break;
			case 2 : 
				startwert = Integer.parseInt(parameterArray[0]);
				endwert = Integer.parseInt(parameterArray[1]);
			break;
			default:			
		}
		
	}
	
	private static void programmabruch(int fehlerLvl, String fehlerText){
		String beschreibung = "fizzbuzz Aufruf ohne Parameter: Startwert = 1, Endwert = 100 \n";
		beschreibung += "fizzbuzz Aufruf ohne Parameter: Startwert = 0, Endwert = 100 \n";
		beschreibung += "fizzbuzz Aufruf mit einem Parameter: Startwert = 1. Parameter, Endwert = 100 \n";
		beschreibung += "fizzbuzz Aufruf mit zwei Parametern: Startwert = 1. Parameter, Endwert = 2. Parameter \n";
		beschreibung += "Parameter müssen natürliche Zahlen sein, sinnvoll : 1. Parameter < 2. Parameter";
		
		System.out.print(fehlerText + "\n"  +beschreibung);
		System.exit(fehlerLvl);
	}

	private static String verarbeitung(){
		String ergebnis = "";
		boolean is5Teiler = false;
		boolean is7Teiler = false;
		
		for(int i = startwert; i <= endwert; i++){
			is5Teiler = i % 5 == 0;
			is7Teiler = i % 7 == 0;
			
			/*hab hier einen mehrfach verschachtelten tertiaeren Operator verwendet und ihn zur besseren Lesbarkeit formatiert */
			
			ergebnis += (is5Teiler || is7Teiler)
							?	(is5Teiler && is7Teiler)
									?	erg5Teiler + erg7Teiler
									:	is5Teiler
											?	erg5Teiler
											:	erg7Teiler
							: i;
			ergebnis += "\n";
		} 
		
		return ergebnis;
	}
}