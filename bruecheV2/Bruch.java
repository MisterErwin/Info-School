public class Bruch {

	private int zaehler;
	private int nenner;

	/**
	 * Konstruktor fuer einen Bruch
	 * 
	 * @param pZaehler
	 *            Der Zaehler des Bruchs
	 * @param pNenner
	 *            Der Nenner des Bruchs
	 */
	public Bruch(int pZaehler, int pNenner) {
		Utils.validateNotNull(pZaehler, pNenner);
		Utils.validateNotZero(pNenner);
		this.zaehler = pZaehler;
		this.nenner = pNenner;
	}

	/**
	 * Get Funktion fuer den Zaehler
	 * 
	 * @return Zaehler des Bruchs
	 */
	public int getZaehler() {
		return this.zaehler;
	}

	/**
	 * Get Funktion fuer den Nenner
	 * 
	 * @return Nenner des Bruchs
	 */
	public int getNenner() {
		return this.nenner;
	}

	/**
	 * Set Methode fuer den Zaehler
	 * 
	 * @return Den Bruch
	 */
	public Bruch setZaehler(int pZaehler) {
		Utils.validateNotNull(pZaehler);
		this.zaehler = pZaehler;
		return this;
	}

	/**
	 * Set Methode fuer den Nenner
	 * 
	 * @return Den Bruch
	 */
	public Bruch setNenner(int pNenner) {
		Utils.validateNotNull(pNenner);
		Utils.validateNotZero(pNenner);
		this.nenner = pNenner;
		return this;
	}

	/**
	 * Multipliziert zwei Brueche
	 * 
	 * @param Den
	 *            2. Faktor
	 * @return Das Produkt als Bruch
	 */
	public Bruch multiplizieren(Bruch pBruch) {
		Utils.validateNotNull(pBruch);
		return new Bruch(getZaehler() * pBruch.getZaehler(), getNenner()
				* pBruch.getNenner());
	}

	/**
	 * Dividert zwei Brueche durch Multiplikation des Dividenden mit dem
	 * Kehrwehrt des Divisors
	 * 
	 * @param Der
	 *            Divisor
	 * @return Den Quotienten als Bruch
	 */
	public Bruch dividieren(Bruch pBruch) {
		Utils.validateNotNull(pBruch);
		return multiplizieren(pBruch.getKehrwehrt());
	}

	/**
	 * Addiert zwei Brueche
	 * 
	 * @param Der
	 *            2. Summand
	 * @return Die Summe als Bruch
	 */
	public Bruch addieren(Bruch pBruch) {
		Utils.validateNotNull(pBruch);
		Bruch b1 = new Bruch(getZaehler() * pBruch.getNenner(), getNenner()
				* pBruch.getNenner());
		Bruch b2 = new Bruch(pBruch.getZaehler() * getNenner(), getNenner()
				* pBruch.getNenner());
		return new Bruch(b1.getZaehler() + b2.getZaehler(), b1.getNenner());
	}

	/**
	 * Subtrahiert zwei Brueche
	 * 
	 * @param Der
	 *            Subtrahend
	 * @return Die Differenz als Bruch
	 */
	public Bruch subtrahieren(Bruch pBruch) {
		Utils.validateNotNull(pBruch);
		Bruch b1 = new Bruch(getZaehler() * pBruch.getNenner(), getNenner()
				* pBruch.getNenner());
		Bruch b2 = new Bruch(pBruch.getZaehler() * getNenner(), getNenner()
				* pBruch.getNenner());
		return new Bruch(b1.getZaehler() - b2.getZaehler(), b1.getNenner());
	}

	/**
	 * Kuerzt den Bruch
	 * 
	 * @return Den (nun gekuerzten) Bruch zur weiteren Verwendung
	 */
	public Bruch kuerze() {
		int ggt = getGGT();
		setZaehler(getZaehler() / ggt);
		setNenner(getNenner() / ggt);
		return this;
	}

	/**
	 * Ermittelt den groessten gemeinsamen Teiler des Bruches via den
	 * Euklidischen Algorithmus
	 * 
	 * @return Den GGT
	 */
	public int getGGT() {
		return Utils.getGGT(this);
	}

	/**
	 * Gibt den Kehrwehrt eines Bruches aus
	 * 
	 * @return Den Kehrwehrt des Bruches
	 */
	public Bruch getKehrwehrt() {
		return new Bruch(getNenner(), getZaehler());
	}

	/**
	 * Ueberschreibung der toString Funktion eines Objects zur besseren
	 * Darstellung
	 * 
	 * @return Den Bruch in lesbarer Schreibweise
	 */
	public String toString() {
		return " " + getZaehler() + "/" + getNenner() + " ";
	}

}
