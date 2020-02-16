package no.hvl.dat109.utleige;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Definerar ein klasse for søk
 * @author Stian Grønås
 */
public class Soek {

    private int kontorNr;
    private LocalDateTime datoTidUtleige;
    private int talPaaDagar;

    private List<Resultat> resultat;

    public Soek(int kontorNr, LocalDateTime datoTidUtleige, int talPaaDagar) {
        this.kontorNr = kontorNr;
        this.datoTidUtleige = datoTidUtleige;
        this.talPaaDagar = talPaaDagar;
        resultat = null;
    }

    /**
     * Gjer eit søk i selskapet
     * @param selskap
     */
    public void gjerEitSoek(Utleigeselskap selskap) {
        //TODO sjekke om kontor != null
        Utleigekontor kontor = selskap.finnKontor(this.kontorNr);
        List<Character> ledigeGrupper = kontor.finnLedigeUtleigeGrupper();

        opprettResultat(ledigeGrupper);
    }

    /**
     * Hentar ut resultatet med det gitte nummeret
     * @param resNr
     * @return resultatet
     */
    public Resultat hentResultat(int resNr) {
        return this.resultat.get(resNr-1);
    }

    /**
     * Opprettar ei liste med resultat og lagrar det i søket
     * @param ledigeGrupper
     */
    private void opprettResultat(List<Character> ledigeGrupper) {

        this.resultat = new ArrayList<>();

        for (Character gruppe : ledigeGrupper) {
            Resultat res = new Resultat(gruppe, this.talPaaDagar);
            resultat.add(res);
        }

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

    public List<Resultat> getResultat() {
        return resultat;
    }

    public void setResultat(List<Resultat> resultat) {
        this.resultat = resultat;
    }
}