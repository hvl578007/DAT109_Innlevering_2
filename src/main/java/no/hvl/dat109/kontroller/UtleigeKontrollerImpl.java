package no.hvl.dat109.kontroller;

import no.hvl.dat109.ui.UtleigeUI;
import no.hvl.dat109.ui.UtleigeUITekstEnkel;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * Klasse som definierar ein implementasjon av UtleigeKontroller-interface-et
 * @author Stian Grønås
 */
public class UtleigeKontrollerImpl implements UtleigeKontroller {

    private UtleigeUI ui;
    private Utleigeselskap selskap;

    /**
     * Opprettar ein kontroller og spør UI om info om selskapet og opprettar det internt
     */
    public UtleigeKontrollerImpl() {
        ui = new UtleigeUITekstEnkel();
        this.selskap = ui.lagNyttSelskapMedInfo();
    }

    /**
     * Opprettar ein kontroller for det gitte selskapet
     * @param selskap
     */
    public UtleigeKontrollerImpl(Utleigeselskap selskap) {
        ui = new UtleigeUITekstEnkel();
        this.selskap = selskap;
    }

    @Override
    public void opprettBilPaaKontor() {
        int kontorNr = ui.lesInnKontorNr();
        Bil bil = ui.lagNyBilMedInfo();

        selskap.leggTilBilPaaKontor(kontorNr, bil);
    }

    @Override
    public void opprettKontor() {
        Utleigekontor kontor = ui.lagNyttKontorMedInfo();
        this.selskap.leggTilKontor(kontor);
    }

    
}