package backend;

import ui.OberflaecheArtikel;

public class SteuerungArtikel {

    OberflaecheArtikel ui;
    Artikelverwaltung artikelverwaltung;

    int ausgewaehlterArtikel = 0;

    public SteuerungArtikel(OberflaecheArtikel ui) {
        this.ui = ui;
        this.artikelverwaltung = new Artikelverwaltung();
    }


    public void addArtikel(Artikel artikel) {
        artikelverwaltung.add(artikel);
    }

    public Artikel naechsterArtikel() {
        if (ausgewaehlterArtikel == artikelverwaltung.getMaxValue()) { //geht auch net
            return momentanerArtikel();
        }

        ausgewaehlterArtikel++;
        return momentanerArtikel();
    }

    public Artikel letzterArtikel() {
        if (ausgewaehlterArtikel == 0) { //Geht auch net
            return momentanerArtikel();
        }

        ausgewaehlterArtikel--;
        return momentanerArtikel();
    }

    private Artikel momentanerArtikel() {
        return artikelverwaltung.get(ausgewaehlterArtikel);
    }








}
