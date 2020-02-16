package no.hvl.dat109.utleige;

import java.util.Random;

/**
 * Klasse som definerar ein bil
 * 
 * @author Stian Grønås
 */
public class Bil {

    private String registreringsnummer;
    private String merke;
    private String modell;
    private String farge;
    private char utleigeGruppe;
    private boolean erLedig;

    private int kilometerKoeyrd;

    /**
     * Opprettar ein bil
     * @param registreringsnummer
     * @param merke
     * @param modell
     * @param farge
     * @param utleigeGruppe
     * @param kilometerKoeyrd
     */
    public Bil(String registreringsnummer, String merke, String modell, String farge, char utleigeGruppe, int kilometerKoeyrd) {
        this.registreringsnummer = registreringsnummer;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleigeGruppe = utleigeGruppe;
        this.erLedig = true;
        this.kilometerKoeyrd = kilometerKoeyrd;
    }

    /**
     * Simulerer at bilen har køyrd noko (random tal frå 1 til 1000)
     * @return ny km
     */
    public int simulerKoeyrd() {
        Random random = new Random();
        this.kilometerKoeyrd += random.nextInt(1000)+1;
        return this.kilometerKoeyrd;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public char getUtleigeGruppe() {
        return utleigeGruppe;
    }

    public void setUtleigeGruppe(char utleigeGruppe) {
        this.utleigeGruppe = utleigeGruppe;
    }

    public boolean isErLedig() {
        return erLedig;
    }

    public void setErLedig(boolean erLedig) {
        this.erLedig = erLedig;
    }

    public int getKilometerKoeyrd() {
        return kilometerKoeyrd;
    }

    public void setKilometerKoeyrd(int kilometerKoeyrd) {
        this.kilometerKoeyrd = kilometerKoeyrd;
    }

}