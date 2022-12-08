package backend;

public class Buch extends Artikel {

    private int anzahlSeiten;

    public Buch(String bezeichnung, int anzahlSeiten) {
        super(bezeichnung);
        this.anzahlSeiten = anzahlSeiten;
    }

    public Buch(String bezeichnung, int lagerbestand, int anzahlSeiten) {
        super(bezeichnung, lagerbestand);
        this.anzahlSeiten = anzahlSeiten;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Anzahl Seiten: " + anzahlSeiten);
    }

    public int getAnzahlSeiten() {
        return anzahlSeiten;
    }

}
