package _4ain.verifica4bin.model;

import java.util.Comparator;

public class ComparatorRuolo implements Comparator<Giocatore> {
    @Override
    public int compare(Giocatore a, Giocatore b) {
        return a.getRuolo().compareTo(b.getRuolo());
    }
}
