package no.hvl.dat109.utleige;

/**
 * Klasse som definerar ein bil
 * @author Stian Grønås
 */
public class Bil {

    private String registreringsnummer;
    private String merke;
    private String modell;
    private String farge;
    private char utleigeGruppe;
    private boolean erLedig;

    /**
     * Opprettar ein bil
     * @param registreringsnummer
     * @param merke
     * @param modell
     * @param farge
     * @param utleigeGruppe
     */
    public Bil(String registreringsnummer, String merke, String modell, String farge, char utleigeGruppe) {
        this.registreringsnummer = registreringsnummer;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleigeGruppe = utleigeGruppe;
        this.erLedig = true;
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

    @Override
    public String toString() {
        return "Bil [erLedig=" + erLedig + ", farge=" + farge + ", merke=" + merke + ", modell=" + modell
                + ", registreringsnummer=" + registreringsnummer + ", utleigeGruppe=" + utleigeGruppe + "]";
    }

}