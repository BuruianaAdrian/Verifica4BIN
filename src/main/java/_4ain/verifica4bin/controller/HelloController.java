package _4ain.verifica4bin.controller;

import _4ain.verifica4bin.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloController {
    @FXML
    public TextField inputGiocatore;
    @FXML
    public Button prossimo;
    @FXML
    public TextField inputRuolo;
    @FXML
    public ComboBox<Squadra> squadre;
    @FXML
    public Button assegna;
    @FXML
    public RadioButton ordinaR;
    @FXML
    public RadioButton ordinaN;
    @FXML
    public Button visualizza;
    @FXML
    public TextArea textArea;
    Giocatore principale;
    private ArrayList<Giocatore> listaGiocatori;
    private ArrayList<Squadra> listaSquadre;
    private int indiceCorrente = 0;

    public void initialize() {
        listaGiocatori = new ArrayList<>();
        listaSquadre = new ArrayList<>();

        listaGiocatori.add(new Giocatore("Joel", giveRuolo()));
        listaGiocatori.add(new Giocatore("Ellie", giveRuolo()));
        listaGiocatori.add(new Giocatore("Abby", giveRuolo()));
        listaGiocatori.add(new Giocatore("Tommy", giveRuolo()));
        listaGiocatori.add(new Giocatore("Owen", giveRuolo()));
        listaGiocatori.add(new Giocatore("Tess", giveRuolo()));

        Squadra uno = new Squadra("Team_Ellie");
        listaSquadre.add(uno);
        Squadra due = new Squadra("Team_Abby");
        listaSquadre.add(due);
        Squadra tre = new Squadra("Team_Dead");
        listaSquadre.add(tre);

        for (int i = 0; i < listaSquadre.size(); i++) {
            squadre.getItems().add(listaSquadre.get(i));
        }

        squadre.setValue(listaSquadre.getFirst());
        ProssimoGiocatore();
        ToggleGroup gruppo = new ToggleGroup();
        ordinaN.setToggleGroup(gruppo);
        ordinaR.setToggleGroup(gruppo);
    }

    public Ruolo giveRuolo() {
        Ruolo ruolo = null;
        int numero = (int) (Math.random() * 4) + 1;
        switch (numero) {
            case 1:
                ruolo = Ruolo.DIFENSORE;
                break;
            case 2:
                ruolo = Ruolo.PORTIERE;
                break;
            case 3:
                ruolo = Ruolo.ATTACCANTE;
                break;
            case 4:
                ruolo = Ruolo.CENTROCAMPISTA;
                break;
        }
        return ruolo;
    }

    public Giocatore ProssimoGiocatore() {
        if (indiceCorrente >= listaGiocatori.size()) {
            indiceCorrente = 0;
        }

        principale = listaGiocatori.get(indiceCorrente);

        String nome = principale.getNome();
        String ruolo = String.valueOf(principale.getRuolo());

        inputGiocatore.setText(nome);
        inputRuolo.setText(ruolo);

        indiceCorrente++;

        return principale;
    }

    public void assegnaGiocatore() {
        if (!squadre.getValue().add(principale)) {
            textArea.setText("Giocatore già in una squadra");
        } else {
            stampaSquadra();
        }
    }

    public void stampaSquadra() {
        Squadra s = squadre.getValue();
        String risultato = "";

        List<Giocatore> lista;

        if (ordinaN.isSelected()) {
            lista = s.ordinamentoPerNome();
        } else {
            lista = s.ordinamentoPerRuolo();
        }

        for (Giocatore g : lista) {
            risultato += g + "\n";
        }

        textArea.setText(risultato);
    }
}