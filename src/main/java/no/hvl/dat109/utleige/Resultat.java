package no.hvl.dat109.utleige;

/**
 * Resultat
 * @author Stian Grønås
 */
public class Resultat {

    private int pris;
    private char utleigeGruppe;

    //Meir?

    public Resultat(char utleigeGruppe) {
        this.utleigeGruppe = utleigeGruppe;
        this.pris = finnPris(utleigeGruppe);
    }

    private int finnPris(char gruppe) {

        int pris = 0;

        switch (gruppe) {
            case 'A':
                pris = 200;
                break;
            
            case 'B':
                pris = 300;
                break;

            case 'C':
                pris = 400;
                break;

            case 'D':
                pris = 500;
                break;
        
            default:
                pris = 100;
                break;
        }
        return pris;
    }

    @Override
    public String toString() {
        return "Resultat [pris=" + pris + ", utleigeGruppe=" + utleigeGruppe + "]";
    }
}