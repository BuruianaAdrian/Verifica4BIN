package _4ain.verifica4bin.model;

import java.util.Comparator;

public class ComparatorNome implements Comparator<Giocatore> {
    @Override
    public int compare(Giocatore a, Giocatore b) {
        return a.getNome().compareTo(b.getNome());
    }
}
