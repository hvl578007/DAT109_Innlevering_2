package no.hvl.dat109.utleige;

import java.time.LocalDateTime;

/**
 * Klasse som definerar ein reservasjon
 * @author Stian Grønås
 */
public class Reservasjon {

    private int kontorNr;
    private LocalDateTime datoTidUtleige;
    private int talPaaDagar;
    private int pris;
    private char utleigeGruppe;

    /**
     * Lagar ein ny reservasjon
     * @param kontorNr
     * @param datoTidUtleige
     * @param talPaaDagar
     * @param pris
     * @param utleigeGruppe
     */
    public Reservasjon(int kontorNr, LocalDateTime datoTidUtleige, int talPaaDagar, int pris, char utleigeGruppe) {
        this.kontorNr = kontorNr;
        this.datoTidUtleige = datoTidUtleige;
        this.talPaaDagar = talPaaDagar;
        this.pris = pris;
        this.utleigeGruppe = utleigeGruppe;
    }

    public int getKontorNr() {
        return kontorNr;
    }

    public void setKontorNr(int kontorNr) {
        this.kontorNr = kontorNr;
    }

    public LocalDateTime getDatoTidUtleige() {
        return datoTidUtleige;
    }

    public void setDatoTidUtleige(LocalDateTime datoTidUtleige) {
        this.datoTidUtleige = datoTidUtleige;
    }

    public int getTalPaaDagar() {
        return talPaaDagar;
    }

    public void setTalPaaDagar(int talPaaDagar) {
        this.talPaaDagar = talPaaDagar;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public char getUtleigeGruppe() {
        return utleigeGruppe;
    }

    public void setUtleigeGruppe(char utleigeGruppe) {
        this.utleigeGruppe = utleigeGruppe;
    }

    
}