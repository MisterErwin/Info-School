package brueche;

public class Hauptprogramm {

	/**
	 * Hauptmethode
	 */
	public static void main(String[] args) {
		Bruch b1 = new Bruch(2, 1);
		Bruch b2 = new Bruch(1, 2);
		
		System.out.println("Mult: " + b1.multiplizieren(b2).kuerze());
		System.out.println("Div: " + b1.dividieren(b2).kuerze());

		System.out.println("Add: " + b1.addieren(b2).kuerze());
		System.out.println("Sub: " + b1.subtrahieren(b2).kuerze());

	}

}
