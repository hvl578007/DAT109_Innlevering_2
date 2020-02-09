package no.hvl.dat109.utleige;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.Adresse;

/**
 * Klasse som definerar eit utleigeselskap
 * @author Stian Grønås
 */
public class Utleigeselskap {

    private String namn;
    private String telefonnummer;

    private Adresse adresse;

    private List<Utleigekontor> kontorListe;

    /**
     * Opprettar eit utleigeselskap
     * @param namn
     * @param telefonnummer
     * @param adresse
     */
    public Utleigeselskap(String namn, String telefonnummer, Adresse adresse) {
        this.kontorListe = new ArrayList<>();
        this.namn = namn;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }

    //TODO ctor som kontaktar UI for å få inn info automatisk?


    /**
     * Legg til eit kontor i lista
     * @param kontor
     */
    public void leggTilKontor(Utleigekontor kontor) {
        this.kontorListe.add(kontor);
    }

    /**
     * Legg til ein bil på det gitte kontoret
     * @param kontorNr
     * @param bil
     */
    public void leggTilBilPaaKontor(int kontorNr, Bil bil) {
        Utleigekontor kontor = this.finnKontor(kontorNr);
        kontor.leggTilBil(bil);
    }

    /**
     * Finn eit kontor med det gitte kontornummeret
     * @param kontorNr
     * @return kontoret
     */
    public Utleigekontor finnKontor(int kontorNr) {
        //TODO gjer noko betre her...
        return this.kontorListe.get(kontorNr-1);
    }

    //getters/setters

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Utleigekontor> getKontorListe() {
        return kontorListe;
    }

    public void setKontorListe(List<Utleigekontor> kontorListe) {
        this.kontorListe = kontorListe;
    }

    @Override
    public String toString() {
        return "Utleigeselskap [adresse=" + adresse + ", namn=" + namn + ", telefonnummer=" + telefonnummer + "]";
    }

}