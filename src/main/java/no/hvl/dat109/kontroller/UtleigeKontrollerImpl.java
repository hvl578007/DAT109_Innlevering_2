package no.hvl.dat109.kontroller;

import no.hvl.dat109.utleige.Kunde;

import java.time.LocalDateTime;

import no.hvl.dat109.ui.UtleigeUI;
import no.hvl.dat109.ui.UtleigeUITekstEnkel;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Reservasjon;
import no.hvl.dat109.utleige.Resultat;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleige;
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

        //TODO skriv ut bilinfo
    }

    @Override
    public void opprettKontor() {
        Utleigekontor kontor = ui.lagKontorMedInfo();
        this.selskap.leggTilKontor(kontor);

        //TODO skriv ut kontorinfo
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
        //TODO sjekke om resultat != null
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
        String tlf = ui.lesInnTlfNr();
        int kontorNr = ui.lesInnKontorNr();
        //TODO sjekke om kontor/kunde != null!!!
        Utleigekontor kontor = selskap.finnKontor(kontorNr);
        Kunde kunde = selskap.finnKunde(tlf);
        Reservasjon reservasjon = kontor.finnReservasjonPaaKunde(kunde);

        if (reservasjon != null) {
            reservasjon.setHarHenta(true);
            String kortNr = ui.lesInnKortNr();
            Bil bil = kontor.leigUtBil(reservasjon.getUtleigeGruppe());
            int km = bil.getKilometerKoeyrd();

            LocalDateTime datoTidUtleige = reservasjon.getDatoTidUtleige();
            LocalDateTime datoTidForventaRetur = datoTidUtleige.plusDays(reservasjon.getTalPaaDagar());

            Utleige utleige = new Utleige(bil, reservasjon, kortNr, km, datoTidUtleige, datoTidForventaRetur);

            kunde.leggTilUtleige(utleige);

            ui.skrivUtUtleige(utleige);
        } else {
            //TODO skriv ut feilmelding!
            ui.skrivUt("Ingen reservasjon på dette kontoret!");
        }


    }

    @Override
    public void leverBil() {
        // TODO husk å sjekke ting om dei er null!
        String tlf = ui.lesInnTlfNr();
        int kontorNr = ui.lesInnKontorNr();
        
        Utleigekontor kontor = selskap.finnKontor(kontorNr);
        Kunde kunde = selskap.finnKunde(tlf);
        Utleige utleige = kontor.finnUtleigePaaKunde(kunde);

        utleige.getBil().setErLedig(true);
        
        int nyKm = utleige.getBil().simulerKoeyrd();
        utleige.setKilometerEtter(nyKm);

        LocalDateTime datoTidRetur = ui.lesInnDatoTid();
        utleige.setDatoTidRetur(datoTidRetur);

        String rekning = utleige.genererRekning();
        ui.skrivUt(rekning);
    }

    public Soek getSoek() {
        return soek;
    }

    public void setSoek(Soek soek) {
        this.soek = soek;
    }
    
}