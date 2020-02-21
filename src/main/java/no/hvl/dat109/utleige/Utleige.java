package no.hvl.dat109.utleige;

import java.time.LocalDateTime;

/**
 * Klasse som definerar ei utleige
 * @author Stian Grønås
 */
public class Utleige {

    private String kortnummer;
    private int kilometerFoer;
    private LocalDateTime datoTidUtleige;
    private LocalDateTime datoTidForventaRetur;
    private LocalDateTime datoTidRetur;
    private int kilometerEtter;
    private String rekning;

    private boolean harLevert;

    private Reservasjon reservasjon;
    private Bil bil;

    /**
     * Opprettar ei utleige
     * @param bil
     * @param reservasjon
     * @param kortnummer
     * @param kilometerFoer
     * @param datoTidUtleige
     * @param datoTidForventaRetur
     */
    public Utleige(Bil bil, Reservasjon reservasjon, String kortnummer, int kilometerFoer, LocalDateTime datoTidUtleige,
            LocalDateTime datoTidForventaRetur) {
        this.bil = bil;
        this.reservasjon = reservasjon;
        this.kortnummer = kortnummer;
        this.kilometerFoer = kilometerFoer;
        this.datoTidUtleige = datoTidUtleige;
        this.datoTidForventaRetur = datoTidForventaRetur;
        this.datoTidRetur = null;
        this.kilometerEtter = 0;
        this.rekning = "Ingen rekning";
        this.harLevert = false;
    }

    /**
     * Lagar ein simpel rekning
     * @return kopi av rekningen
     */
    public String genererRekning() {
        String rekning = "Det har blitt trukke " + this.reservasjon.getPris() + " kr på kortet: " + this.kortnummer;
        this.rekning = rekning;
        return rekning; 
    }

    public String getKortnummer() {
        return kortnummer;
    }

    public void setKortnummer(String kortnummer) {
        this.kortnummer = kortnummer;
    }

    public int getKilometerFoer() {
        return kilometerFoer;
    }

    public void setKilometerFoer(int kilometerFoer) {
        this.kilometerFoer = kilometerFoer;
    }

    public LocalDateTime getDatoTidUtleige() {
        return datoTidUtleige;
    }

    public void setDatoTidUtleige(LocalDateTime datoTidUtleige) {
        this.datoTidUtleige = datoTidUtleige;
    }

    public LocalDateTime getDatoTidForventaRetur() {
        return datoTidForventaRetur;
    }

    public void setDatoTidForventaRetur(LocalDateTime datoTidForventaRetur) {
        this.datoTidForventaRetur = datoTidForventaRetur;
    }

    public LocalDateTime getDatoTidRetur() {
        return datoTidRetur;
    }

    public void setDatoTidRetur(LocalDateTime datoTidRetur) {
        this.datoTidRetur = datoTidRetur;
    }

    public int getKilometerEtter() {
        return kilometerEtter;
    }

    public void setKilometerEtter(int kilometerEtter) {
        this.kilometerEtter = kilometerEtter;
    }

    public String getRekning() {
        return rekning;
    }

    public void setRekning(String rekning) {
        this.rekning = rekning;
    }

    public boolean isHarLevert() {
        return harLevert;
    }

    public void setHarLevert(boolean harLevert) {
        this.harLevert = harLevert;
    }

    public Reservasjon getReservasjon() {
        return reservasjon;
    }

    public void setReservasjon(Reservasjon reservasjon) {
        this.reservasjon = reservasjon;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    @Override
    public String toString() {
        return "Utleige [bilreg=" + bil.getRegistreringsnummer() + ", datoTidForventaRetur=" + datoTidForventaRetur + ", datoTidRetur="
                + datoTidRetur + ", datoTidUtleige=" + datoTidUtleige + ", harLevert=" + harLevert + ", kilometerEtter="
                + kilometerEtter + ", kilometerFoer=" + kilometerFoer + ", kortnummer=" + kortnummer + ", rekning="
                + rekning + "]";
    }

    
}