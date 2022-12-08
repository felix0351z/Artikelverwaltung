package backend;

public class Artikelverwaltung {




    private Artikel[] list;
    private int counter;

    public Artikelverwaltung() {
        list = new Artikel[20];
        counter = 0;
    }


    public void add(Artikel artikel) {
        list[counter] = artikel;

        counter++;
    }

    public Artikel get(int position) {
        if (position >= counter) {
            return null;
        }

        return list[position];
    }

    public int getMaxValue() {
        return counter-1;
        //-1 da die Länge immer eins höher ist als die Position
    }

}
