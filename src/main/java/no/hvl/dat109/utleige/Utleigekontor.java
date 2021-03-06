package no.hvl.dat109.utleige;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Finn ein tilfeldig (den første) reservasjon på ein kunde på dette kontoret
     * @param kunde
     * @return reservasjonen
     */
    public Reservasjon finnReservasjonPaaKunde(Kunde kunde) {
        List<Reservasjon> reservasjonar = kunde.getReservasjonar();

        return reservasjonar.stream()
                    .filter(r -> !r.isHarHenta() && r.getKontorNr() == this.kontornummer)
                    .findFirst().orElse(null);
        //burde setta reservasjon som harhenta her!?
    }

    /**
     * Leigar ut ein ledig bil på den gitte gruppa
     * @param UtleigeGruppe
     * @return bilen
     */
    public Bil leigUtBil(char utleigeGruppe) {
        //TODO burde gje betre bil om det ikkje er noko ledige i den gruppa igjen
        Bil bil = this.bilar.stream()
                .filter(b -> b.getUtleigeGruppe() == utleigeGruppe)
                .filter(Bil::isErLedig)
                .findAny().orElse(null);
        
        if(bil != null) bil.setErLedig(false);
        return bil;
    }

    /**
     * Finn ein tilfeldig utleige på ein kunde som ikkje er levert
     * @param kunde
     * @return utleigen
     */
    public Utleige finnUtleigePaaKunde(Kunde kunde) {
        List<Utleige> utleigar = kunde.getUtleigar();

        return utleigar.stream()
                    .filter(u -> !u.isHarLevert() && u.getReservasjon().getKontorNr() == this.kontornummer)
                    .findAny().orElse(null);
        //burde setta utleige som harlevert her!?
    }

    /**
     * Finn ein utleige på ein kunde med regnr som ikkje er levert
     * @param kunde
     * @param regnr
     * @return
     */
    public Utleige finnUtleigePaaKunde(Kunde kunde, String regnr) {
        List<Utleige> utleigar = kunde.getUtleigar();

        return utleigar.stream()
                    .filter(u -> !u.isHarLevert() && u.getReservasjon().getKontorNr() == this.kontornummer)
                    .filter(u -> u.getBil().getRegistreringsnummer().equals(regnr))
                    .findAny().orElse(null);
    }

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

    public static void setKontornummerLoepande(int kontornummerLoepande) {
        Utleigekontor.kontornummerLoepande = kontornummerLoepande;
    }

    @Override
    public String toString() {
        return "Utleigekontor [bilar=" + bilar + ", kontoradresse=" + kontoradresse + ", kontornummer=" + kontornummer
                + ", telefonnummer=" + telefonnummer + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Utleigekontor kontor;
        if(obj instanceof Utleigekontor) {
            kontor = (Utleigekontor) obj;
            return this.getTelefonnummer().equals(kontor.getTelefonnummer());
        }
        return false;
    }

}