package no.hvl.dat109.ui;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Kunde;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Reservasjon;
import no.hvl.dat109.utleige.Resultat;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleige;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * Klasse som implementerar UtleigeUI-interfacet
 * @author Stian Grønås
 */
public class UtleigeUITekstEnkel implements UtleigeUI {

    @Override
    public void skrivUt(String melding) {
        JOptionPane.showMessageDialog(null, melding, "Selskap", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String lesInnString(String melding) {
        String inn = JOptionPane.showInputDialog(null, melding);
        return inn;
    }

    @Override
    public int lesInnInteger(String melding) {
        boolean gyldig = false;
        int tilbake = 0;
        do {
            String inn = JOptionPane.showInputDialog(null, melding);
            try {
                tilbake = Integer.parseInt(inn);
                gyldig = true;
            } catch (Exception e) {
                this.skrivUt("Ikkje eit tal! Skriv inn på nytt");
            }
        } while (!gyldig);
        
        return tilbake;
    }

    @Override
    public char lesInnChar(String melding) {
        String inn = JOptionPane.showInputDialog(null, melding);
        inn = inn.toUpperCase();
        char tilbake = inn.charAt(0);
        while (!Bil.GYLDIGE_GRUPPER.contains(tilbake)) {
            this.skrivUt("Ugyldig character!");
            inn = JOptionPane.showInputDialog(null, melding);
            inn = inn.toUpperCase();
            tilbake = inn.charAt(0);
        }
        return tilbake;
    }

    @Override
    public Adresse lagAdresseMedInfo() {
        String gateadresse = this.lesInnString("Gateadresse:");
        String postnummer = this.lesInnString("Postnummer");
        String poststad = this.lesInnString("Poststad");

        Adresse adresse = new Adresse(gateadresse, postnummer, poststad);
        return adresse;
    }

    @Override
    public Bil lagBilMedInfo() {
        String regnr = lesInnString("Regnr:");
        String merke = lesInnString("Merke:");
        String modell = lesInnString("Modell:");
        String farge = lesInnString("Farge:");
        char utleigeGruppe = lesInnChar("Utleigegruppe:");
        int km = lesInnInteger("Kilometer køyrd:");
        Bil bil = new Bil(regnr, merke, modell, farge, utleigeGruppe, km);
        return bil;
    }

    @Override
    public Utleigekontor lagKontorMedInfo() {
        Adresse adresse = this.lagAdresseMedInfo();
        String tlf = lesInnString("Telefonnummer:");
        Utleigekontor kontor = new Utleigekontor(adresse, tlf);
        return kontor;
    }

    @Override
    public Utleigeselskap lagSelskapMedInfo() {
        Adresse adresse = this.lagAdresseMedInfo();
        String namn = lesInnString("Namn på selskap:");
        String tlf = lesInnString("Telefonnummer:");
        Utleigeselskap selskap = new Utleigeselskap(namn, tlf, adresse);
        return selskap;
    }

    @Override
    public int lesInnKontorNr() {
        int nr = this.lesInnInteger("Skriv inn kontornr:");
        return nr;
    }

    @Override
    public Soek lesInnSoek() {
        int kontorNr = this.lesInnKontorNr();
        LocalDateTime datoTidUtleige = this.lesInnDatoTid();
        int talPaaDagar = this.lesInnInteger("Tal på dagar:");
        Soek soek = new Soek(kontorNr, datoTidUtleige, talPaaDagar);
        return soek;
    }

    @Override
    public void visSoekResultat(Soek soek) {
        if (soek != null) {
            List<Resultat> res = soek.getResultat();
            String ut = "";
            for (Resultat r : res) {
                ut += r.toString() + "\n";
            }
            this.skrivUt(ut);
        } else {
            this.skrivUt("Tomt søke-objekt");
        }
    }

    @Override
    public LocalDateTime lesInnDatoTid() {
        int svar = JOptionPane.showOptionDialog(null, "Bruke dato/tid now()? (JA)\nSkrive inn tid manuelt? (MANUELT)", "Selskap", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"JA", "MANUELT"}, "");
        LocalDateTime tid = null;
        if (svar == 0) {
            tid = LocalDateTime.now();
        } else {
            boolean gyldig = false;
            do {
                String tidStr = lesInnString("Skriv inn dato/tid:, ISO-format");
                try {
                    tid = LocalDateTime.parse(tidStr);
                    gyldig = true;
                } catch (Exception e) {
                    this.skrivUt("Ugyldig dato - prøv på nytt!");
                }
            } while (!gyldig);
        }
        return tid;
    }

    @Override
    public int lesInnResultatNr(Soek soek) {
        int talPaaResultat = soek.getResultat().size();
        int nr = this.lesInnInteger("Skriv inn resultatnr (1 opp til " + talPaaResultat + ")");
        while (nr < 1 || nr > talPaaResultat) {
            this.skrivUt("Ugyldig resultatnummer, skriv inn på nytt!");
            nr = this.lesInnInteger("Skriv inn resultatnr (1 opp til " + talPaaResultat + ")");
        }
        return nr;
    }

    @Override
    public Kunde lagKundeMedInfo() {
        String fornamn = lesInnString("Skriv inn fornamn");
        String etternamn = lesInnString("Skriv inn etternamn");
        String tlf = lesInnTlfNr();
        Adresse adresse = lagAdresseMedInfo();
        Kunde kunde = new Kunde(fornamn, etternamn, tlf, adresse);
        return kunde;
    }

    @Override
    public String lesInnTlfNr() {
        //TODO sjekke at det er 8 sifre?
        return this.lesInnString("Skriv inn tlf:");
    }

    @Override
    public String lesInnKortNr() {
        //TODO "lagre på sikker måte.."
        return this.lesInnString("Skriv inn kortnr:");
    }

    @Override
    public void skrivUtKundeReservasjon(Kunde kunde, Reservasjon reservasjon) {
        this.skrivUt("Kunde\n" + kunde.toString() + "\nReservasjon:\n" + reservasjon.toString());
    }

    @Override
    public void skrivUtUtleige(Utleige utleige) {
        this.skrivUt("Det har blitt gjort eit utleige:\n" + utleige.toString());
    }

    
}