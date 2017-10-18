package sd.fibonacci;

/*berechnet die Fibonacci Zahl einer Zahl n,*/
/*dabei gilt Fibonacci von 1 = Fibonacci von 2 = 1,*/
/*ansonsten Fibonacci von n = Fibonacci von (n-1) + Fibonacci von (n-2)*/

/*hier einfach rekursiv programmiert*/
/*Vorteile: einfacher uebersichtlicher Code*/
/*Nachteile: relativ langsam, verbraucht sehr viele Resourcen - es werden bei jedem Methodenaufruf neue lokale Variablen angelegt*/

public class fibonacciRekursiv {
	
	/*hier globale Varablen wegen :
	 *  - Literale vermeiden,
	 *  - einfach Aenderungen an gut sichtbarer Stelle vornehmen zu koennen,
	 *  - einfache Parameteruebergabe  */
	
	static int fibVonZahl = 40; /*muß > 0 sein*/

	public static void main(String[] args) {
		 String ausgabe = "die Fibonacci zahl von " + fibVonZahl + " = ";
		 
		 ausgabe += fibonacci(fibVonZahl);
		
		 System.out.print(ausgabe);

	}
	
	private static int fibonacci(int zahl) {
		/*fibonacci() von 1 und 2 ist 1, steht hier deshalb so als vorgegeben, und um die locale Variable zu initialisieren,*/
		/*es wird nur der Fall geprüft wenn die Zahl für fibonacci() größer als 2 ist */
		int ergebnis = 1;
		if (zahl > 2) {
			ergebnis = fibonacci(zahl - 1) + fibonacci(zahl - 2);
		}
		
		return ergebnis;
	}
}
