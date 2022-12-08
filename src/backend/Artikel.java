package backend;

public class Artikel {

    private static int letzteArtikelNummer;

    private String bezeichnung;
    private double verkaufspreis;
    private int lagerbestand;

    private int artikelnummer;


    private Artikel() {
        this.artikelnummer = letzteArtikelNummer++;
    }

    public Artikel(String bezeichnung) {
        this();
        this.bezeichnung = bezeichnung;
    }

    public Artikel(String bezeichnung, int lagerbestand) {
        this(bezeichnung);
        this.lagerbestand = lagerbestand;
    }


    public void einkaufen(int stueckzahl) {
        lagerbestand+=stueckzahl;
    }

    public void verkaufen(int stueckzahl) {
        if (lagerbestand-stueckzahl < 0) {
            return;
        }

        lagerbestand-=stueckzahl;
    }




    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public double getVerkaufspreis() {
        return verkaufspreis;
    }
    public void setVerkaufspreis(double verkaufspreis) {
        this.verkaufspreis = verkaufspreis;
    }
    public int getLagerbestand() {
        return lagerbestand;
    }
    public void setLagerbestand(int lagerbestand) {
        this.lagerbestand = lagerbestand;
    }
    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void print() {
        System.out.println("--------Artikel------------");
        System.out.println("Bezeichnung: " + bezeichnung + "\nVerkaufspreis: " + verkaufspreis + "\nLagerbestand: " + lagerbestand);
    }

}
