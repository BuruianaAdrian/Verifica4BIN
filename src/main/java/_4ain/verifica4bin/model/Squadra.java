package _4ain.verifica4bin.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Squadra {
    private String nome;
    private ArrayList<Giocatore> giocatori;

    public Squadra(String nome) {
        this.nome = nome;
        giocatori=new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Giocatore> getGiocatori() {
        return giocatori;
    }

    public boolean add(Giocatore g){
        if(g.entraInSquadra()){
            giocatori.add(g);
            return true;
        }else return false;
    }

    public String stampaSquadra(){
        String s="";
        for(Giocatore g: giocatori){
            s+=g+"\n";
        }
        return s;
    }

    public List<Giocatore> ordinamentoPerNome(){
        List<Giocatore> classifica = new ArrayList<>(giocatori);
        Collections.sort(classifica, new ComparatorNome());
        return classifica;
    }

    public List<Giocatore> ordinamentoPerRuolo(){
        List<Giocatore> classifica = new ArrayList<>(giocatori);
        Collections.sort(classifica, new ComparatorRuolo());
        return classifica;
    }

    @Override
    public String toString() {
        return nome;
    }
}
