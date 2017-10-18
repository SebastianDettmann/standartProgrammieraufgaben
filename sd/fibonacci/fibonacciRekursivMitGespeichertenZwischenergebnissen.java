package sd.fibonacci;

/*berechnet die Fibonacci Zahl einer Zahl n,*/
/*dabei gilt Fibonacci von 1 = Fibonacci von 2 = 1,*/
/*ansonsten Fibonacci von n = Fibonacci von (n-1) + Fibonacci von (n-2)*/

/*hier einfach rekursiv programmiert*/
/*hier etwas verbessert, bereits erechnete Fibonacci Zahlen werden nicht noch mal berechnet */

public class fibonacciRekursivMitGespeichertenZwischenergebnissen {
	
	/*hier globale Varablen wegen :
	 *  - Literale vermeiden,
	 *  - einfach Aenderungen an gut sichtbarer Stelle vornehmen zu koennen,
	 *  - einfache Parameteruebergabe  */
	
	static int fibVonZahl = 40; /*muß > 0 sein*/
	/*Arrays beginnen mit 0, daher hat der n - te Wert den Index n-1,
	 * durch + 1 kann n - te Wert den Index von n haben - uebersichtlicher,
	 * der Index von 0 wird dabei ausgelassen */

	static int[] fibErgebnisArray = new int[fibVonZahl + 1]; 

	public static void main(String[] args) {
		 String ausgabe = "die Fibonacci zahl von " + fibVonZahl + " = ";
		 
		 ausgabe += fibonacci(fibVonZahl);
		
		 System.out.print(ausgabe);

	}
	
	private static int fibonacci(int zahl) {
		/*fibonacci() von 1 und 2 ist 1, steht hier deshalb so als vorgegeben, und um die locale Variable zu initialisieren,*/
		/*es wird nur der Fall geprüft wenn die Zahl für fibonacci() größer als 2 ist */
		int ergebnis = 1;
		
		/*fibErgebnisArray wurde als globales int Array erstellt und dadurch alle Werte mit 0 standartmaessig initialisiert,
		 *wurde ein Wert gespeichert ist er !=0 - die kleinste Fibonacci Zahl ist 1*/
		if(fibErgebnisArray[zahl] != 0) {
			ergebnis = fibErgebnisArray[zahl];
		}
		else {
			if (zahl > 2) {
				ergebnis = fibonacci(zahl - 1) + fibonacci(zahl - 2);
				/*wenn eine Fibunacci Zahl als Zwischenergebnis gefunden wurde wird sie mit ihrem Argument als Index fibErgebnisArray gespeichert und braucht nicht noch einmal berechnet zu werden */
				fibErgebnisArray[zahl] = ergebnis;
			}
			
		}
		
		return ergebnis;
	}
}
