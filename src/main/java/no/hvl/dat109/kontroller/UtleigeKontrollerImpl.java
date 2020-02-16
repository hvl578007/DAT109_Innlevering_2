package no.hvl.dat109.kontroller;

import no.hvl.dat109.utleige.Kunde;
import no.hvl.dat109.ui.UtleigeUI;
import no.hvl.dat109.ui.UtleigeUITekstEnkel;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Reservasjon;
import no.hvl.dat109.utleige.Resultat;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * Klasse som definierar ein implementasjon av UtleigeKontroller-interface-et
 * @author Stian Grønås
 */
public class UtleigeKontrollerImpl implements UtleigeKontroller {

    private UtleigeUI ui;
    private Utleigeselskap selskap;

    //anna namn?
    private Soek soek;

    /**
     * Opprettar ein kontroller og spør UI om info om selskapet og opprettar det internt
     */
    public UtleigeKontrollerImpl() {
        ui = new UtleigeUITekstEnkel();
        this.selskap = ui.lagSelskapMedInfo();
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
        Bil bil = ui.lagBilMedInfo();

        selskap.leggTilBilPaaKontor(kontorNr, bil);
    }

    @Override
    public void opprettKontor() {
        Utleigekontor kontor = ui.lagKontorMedInfo();
        this.selskap.leggTilKontor(kontor);
    }

    @Override
    public void soek() {
        Soek soek = ui.lesInnSoek();

        soek.gjerEitSoek(this.selskap);

        ui.visSoekResultat(soek);

        this.setSoek(soek);

    }

    @Override
    public void reserver() {
        int resNr = ui.lesInnResultatNr(soek);

        Resultat resultat = soek.hentResultat(resNr);

        Reservasjon reservasjon = new Reservasjon(soek.getKontorNr(), soek.getDatoTidUtleige(), soek.getTalPaaDagar(), resultat.getPris(), resultat.getUtleigeGruppe());

        Kunde kunde = ui.lagKundeMedInfo();

        kunde.leggTilReservasjon(reservasjon);

        selskap.leggTilKunde(kunde);

        ui.skrivUtKundeReservasjon(kunde, reservasjon);

    }

    @Override
    public void hentBil() {
        // TODO Auto-generated method stub

    }

    @Override
    public void leverBil() {
        // TODO Auto-generated method stub

    }

    public Soek getSoek() {
        return soek;
    }

    public void setSoek(Soek soek) {
        this.soek = soek;
    }
    
}