package no.hvl.dat109.utleige;

/**
 * Resultat
 * @author Stian Grønås
 */
public class Resultat {

    //TODO Burde lagre dei på selskapet? Ein eigen klasse?
    private final static int PRIS_GRUPPE_A = 200;
    private final static int PRIS_GRUPPE_B = 300;
    private final static int PRIS_GRUPPE_C = 400;
    private final static int PRIS_GRUPPE_D = 500;
    private final static int PRIS_INGEN_GRUPPE = 1000;

    private int pris;
    private char utleigeGruppe;

    public Resultat(char utleigeGruppe, int dagar) {
        this.utleigeGruppe = utleigeGruppe;
        this.pris = finnPris(utleigeGruppe) * dagar;
    }

    private int finnPris(char gruppe) {

        int pris = 0;

        switch (gruppe) {
            case 'A':
                pris = PRIS_GRUPPE_A;
                break;
            
            case 'B':
                pris = PRIS_GRUPPE_B;
                break;

            case 'C':
                pris = PRIS_GRUPPE_C;
                break;

            case 'D':
                pris = PRIS_GRUPPE_D;
                break;
        
            default:
                pris = PRIS_INGEN_GRUPPE;
                break;
        }
        return pris;
    }

    @Override
    public String toString() {
        return "Resultat [pris=" + pris + ", utleigeGruppe=" + utleigeGruppe + "]";
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