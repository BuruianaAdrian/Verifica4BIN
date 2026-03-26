package _4ain.verifica4bin.model;

public class Giocatore implements Comparable<Giocatore>{
    private String nome;
    private Ruolo ruolo;
    private boolean isGiàInSquadra;

    public Giocatore(String nome, Ruolo ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
        isGiàInSquadra=false;
    }
    @Override
    public int compareTo(Giocatore giocatore){
        return this.nome.compareTo(giocatore.nome);
    }
    public boolean entraInSquadra(){
        if(isGiàInSquadra){
            return false;
        }else{
            isGiàInSquadra=true;
            return true;
        }
    }

    @Override
    public String toString() {
        return nome+" "+ruolo;
    }

    public String getNome() {
        return nome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

}
