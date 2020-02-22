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

        ui.skrivUt("Oppretta bil: " + bil.toString());
    }

    @Override
    public void opprettKontor() {
        Utleigekontor kontor = ui.lagKontorMedInfo();
        this.selskap.leggTilKontor(kontor);

        ui.skrivUt("Oppretta kontor: " + kontor.toString());
    }

    @Override
    public void soek() {
        Soek soek = ui.lesInnSoek();

        Utleigekontor kontor = this.selskap.finnKontor(soek.getKontorNr());

        if (kontor != null) {
            soek.gjerEitSoek(kontor);

            //vis resultat?
            ui.visSoekResultat(soek);

            this.setSoek(soek);
        } else {
            ui.skrivUt("Ugyldig kontornummer på søket! Prøv på nytt!");
        }
        
    }

    @Override
    public void reserver() {

        if (this.soek != null) {
            ui.visSoekResultat(soek);
        
            int resNr = ui.lesInnResultatNr(soek);

            Resultat resultat = soek.hentResultat(resNr);

            if (resultat != null) {
                Reservasjon reservasjon = new Reservasjon(soek.getKontorNr(), soek.getDatoTidUtleige(), soek.getTalPaaDagar(), resultat.getPris(), resultat.getUtleigeGruppe());

                //vil spørje om det er ein kunde frå før nå
                Kunde kunde = null;
                do {
                    int svar = ui.spoerOmEksisterandeKunde();
                    if (svar == 0) {
                        String tlf = ui.lesInnTlfNr();
                        kunde = selskap.finnKunde(tlf);
                    } else if (svar == 1) {
                        kunde = ui.lagKundeMedInfo();
                    }
                    if (kunde == null) {
                        ui.skrivUt("Ingen kunde med det tlf! Prøv på nytt.");
                    }
                } while(kunde == null);

                kunde.leggTilReservasjon(reservasjon);

                selskap.leggTilKunde(kunde);

                ui.skrivUtKundeReservasjon(kunde, reservasjon);

                setSoek(null);
            } else {
                ui.skrivUt("Søket hadde ingen resultat! Gjer eit nytt søk på anna kontor!");
            }
        } else {
            ui.skrivUt("Søke-objektet er tomt! Gjer eit nytt søk.");
        }
        

    }

    @Override
    public void hentBil() {
        String tlf = ui.lesInnTlfNr();
        int kontorNr = ui.lesInnKontorNr();
        Utleigekontor kontor = selskap.finnKontor(kontorNr);
        Kunde kunde = selskap.finnKunde(tlf);

        if (kunde != null && kontor != null) {
            Reservasjon reservasjon = kontor.finnReservasjonPaaKunde(kunde);

            if (reservasjon != null) {
                reservasjon.setHarHenta(true);
                String kortNr = ui.lesInnKortNr();
                Bil bil = kontor.leigUtBil(reservasjon.getUtleigeGruppe());

                if (bil != null) {
                    int km = bil.getKilometerKoeyrd();

                    LocalDateTime datoTidUtleige = reservasjon.getDatoTidUtleige();
                    LocalDateTime datoTidForventaRetur = datoTidUtleige.plusDays(reservasjon.getTalPaaDagar());

                    Utleige utleige = new Utleige(bil, reservasjon, kortNr, km, datoTidUtleige, datoTidForventaRetur);

                    kunde.leggTilUtleige(utleige);

                    ui.skrivUtUtleige(utleige);
                } else {
                    ui.skrivUt("Ingen ledige bilar nå! Prøv igjen seinare/lever inn ein bil...");
                }
                
            } else {
                ui.skrivUt("Ingen reservasjon på dette kontoret!");
            }
        } else {

            if (kontor == null) {
                ui.skrivUt("Ugyldig kontornr! Prøv på nytt.");
            }

            if (kunde == null) {
                ui.skrivUt("Ingen kunde med det telefonnummeret! Prøv på nytt.");
            }
        }
        


    }

    @Override
    public void leverBil() {
        String tlf = ui.lesInnTlfNr();
        int kontorNr = ui.lesInnKontorNr();
        
        Utleigekontor kontor = selskap.finnKontor(kontorNr);
        Kunde kunde = selskap.finnKunde(tlf);
        
        if (kunde != null && kontor != null) {
            Utleige utleige = kontor.finnUtleigePaaKunde(kunde);

            if (utleige != null) {
                utleige.getBil().setErLedig(true);
            
                int nyKm = utleige.getBil().simulerKoeyrd();
                utleige.setKilometerEtter(nyKm);

                LocalDateTime datoTidRetur = ui.lesInnDatoTid();
                utleige.setDatoTidRetur(datoTidRetur);

                utleige.setHarLevert(true);

                String rekning = utleige.genererRekning();
                ui.skrivUt(rekning);
            } else {
                ui.skrivUt("Ingen utleige på dette kontoret!");
            }

        } else {

            if (kontor == null) {
                ui.skrivUt("Ugyldig kontornr! Prøv på nytt.");
            }

            if (kunde == null) {
                ui.skrivUt("Ingen kunde med det telefonnummeret! Prøv på nytt.");
            }
        }
        
    }

    public Soek getSoek() {
        return soek;
    }

    public void setSoek(Soek soek) {
        this.soek = soek;
    }
    
}