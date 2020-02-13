package no.hvl.dat109.utleige;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import no.hvl.dat109.Adresse;

/**
 * Klasse som definerar eit utleigekontor
 * @author Stian Grønås
 */
public class Utleigekontor {

    //nummererast fortløpande
    private int kontornummer;
    private String telefonnummer;
    
    private Adresse kontoradresse;

    private List<Bil> bilar;

    private static int kontornummerLoepande = 1;

    /**
     * Opprettar eit nytt utleigekontor
     * @param adresse
     * @param telefonnummer
     */
    public Utleigekontor (Adresse adresse, String telefonnummer) {
        this.bilar = new ArrayList<>();
        this.kontornummer = kontornummerLoepande;
        kontornummerLoepande++;
        this.telefonnummer = telefonnummer;
        this.kontoradresse = adresse;
    }

    /**
     * Legg til ein bil i lista av bilar
     * @param bil
     */
    public void leggTilBil(Bil bil) {
        this.bilar.add(bil);
    }

    /**
     * Finn dei ledige utleigegruppene på bilane til kontoret
     * @return ei liste av gruppene som er ledige
     */
    public List<Character> finnLedigeUtleigeGrupper() {
        
        List<Character> ledigeGrupper;

        ledigeGrupper = bilar.stream()
                            .filter(Bil::isErLedig)
                            .map(Bil::getUtleigeGruppe)
                            .distinct()
                            .sorted()
                            .collect(Collectors.toList());

		return ledigeGrupper;
	}

    //getters/setters

    public int getKontornummer() {
        return kontornummer;
    }

    public void setKontornummer(int kontornummer) {
        this.kontornummer = kontornummer;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Adresse getKontoradresse() {
        return kontoradresse;
    }

    public void setKontoradresse(Adresse kontoradresse) {
        this.kontoradresse = kontoradresse;
    }

    public List<Bil> getBilar() {
        return bilar;
    }

    public void setBilar(List<Bil> bilar) {
        this.bilar = bilar;
    }

    @Override
    public String toString() {
        return "Utleigekontor [kontoradresse=" + kontoradresse + ", kontornummer=" + kontornummer + ", telefonnummer="
                + telefonnummer + "]";
    }

    public static void setKontornummerLoepande(int kontornummerLoepande) {
        Utleigekontor.kontornummerLoepande = kontornummerLoepande;
    }

}