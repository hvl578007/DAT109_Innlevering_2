package no.hvl.dat109.utleige;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definerar ein klasse for søk
 * @author Stian Grønås
 */
public class Soek {

    private int kontorNr;
    private LocalDateTime datoTidUtleige;
    private int talPaaDagar;

    private List<String> resultat; //TODO eigen klasse??!?!

    public Soek(int kontorNr, LocalDateTime datoTidUtleige, int talPaaDagar) {
        this.kontorNr = kontorNr;
        this.datoTidUtleige = datoTidUtleige;
        this.talPaaDagar = talPaaDagar;
        resultat = null;
    }

    /**
     * Gjer eit søk mot systemet
     */
    public void gjerEitSoek(Utleigeselskap selskap) {
        Utleigekontor kontor = selskap.finnKontor(this.kontorNr);
        List<Character> ledigeGrupper = kontor.finnLedigeUtleigeGrupper();

        setResultat(ledigeGrupper);
    }

    public void setResultat(List<Character> ledigeGrupper) {
        this.resultat = ledigeGrupper.stream()
                        .map(lG -> "Bilutleigegruppe: " + lG.toString() + " er ledig. Pris: " + (talPaaDagar*finnPris(lG)))
                        .collect(Collectors.toList());

        //TODO... lag ein resultatklasse slik at ein kan kople saman pris og gruppe!!!
    }

    //TODO denne må ein annan plass, (resultat-klasse? idk), finn på noko!!!
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

    public List<String> getResultat() {
        return this.resultat;
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
}