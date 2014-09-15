public class Utils {

	/**
	 * Wirft einen Fehler, falls eines der Argumente null ist
	 * 
	 * @param args
	 *            Liste der Argumente
	 * @throws NullPointerException
	 */
	public static void validateNotNull(Object... args) {
		for (Object o : args)
			if (o == null)
				throw new NullPointerException("Parameter darf nicht NULL sein");
	}

	/**
	 * Wirft einen Fehler, falls eines der Argumente 0 ist
	 * 
	 * @param args
	 *            Integer-Liste der Argumente
	 * @throws NullPointerException
	 */
	public static void validateNotZero(Integer... args) {
		for (Integer i : args)
			if (i == 0)
				throw new NullPointerException("arg can't be 0!");
	}

	/**
	 * Ermittelt den groessten gemeinsamen Teiler eines Bruches via den
	 * Euklidischen Algorithmus
	 * 
	 * @param Der
	 *            Bruch
	 * @return Den GGT
	 */
	public static int getGGT(Bruch pBruch) {
		Utils.validateNotNull(pBruch);
		return ggt(pBruch.getZaehler(), pBruch.getNenner());
	}

	/**
	 * Ermittelt den groessten gemeinsamen Teiler zweier Zahlen via den
	 * Euklidischen Algorithmus
	 * 
	 * @param Die
	 *            1. Zahl
	 * @param Die
	 *            2. Zahl
	 * @return Den GGT
	 */
	public static int ggt(int a, int b) {
		return (b == 0) ? a : ggt(b, a % b);
	}

	/**
	 * Prueft, ob das Object eine Zahl ist
	 * 
	 * @param Object
	 *            zum prüfen
	 * @return Ob das Object Integer ist
	 */
	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Gibt einen String als Zahl aus Oder wirft eine NumberFormatException
	 * Warum auch immer ich diese Methode gemacht habe...
	 * 
	 * @param String
	 *            zum konvertieren
	 * @return Integer
	 * @throws NumberFormatException
	 *             Falls der Parameter kein INT ist
	 */
	public static int asInt(String s) {
		if (!isInt(s))
			throw new NumberFormatException("Die Werte müssen Zahlen sein");
		return Integer.parseInt(s);
	}
}
