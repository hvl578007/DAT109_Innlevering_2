package no.hvl.dat109.ui;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * UtleigeUITekstEnkel
 */
public class UtleigeUITekstEnkel implements UtleigeUI {

    @Override
    public void skrivUt(String melding) {
        JOptionPane.showConfirmDialog(null, melding);
    }

    @Override
    public String lesInnString(String melding) {
        String inn = JOptionPane.showInputDialog(null, melding);
        return inn;
    }

    @Override
    public int lesInnInteger(String melding) {
        String inn = JOptionPane.showInputDialog(null, melding);
        int tilbake = Integer.MIN_VALUE;
        try {
            tilbake = Integer.parseInt(inn);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return tilbake;
    }

    @Override
    public char lesInnChar(String melding) {
        String inn = JOptionPane.showInputDialog(null, melding);
        inn = inn.toUpperCase();
        char tilbake = inn.charAt(0);
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
        Bil bil = new Bil(regnr, merke, modell, farge, utleigeGruppe);
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
        List<String> res = soek.getResultat();
        String ut = "";
        for (String r : res) {
            ut += r + "\n";
        }
        this.skrivUt(ut);
    }

    @Override
    public LocalDateTime lesInnDatoTid() {
        String tidStr = lesInnString("Skriv inn dato/tid:, ISO-format");
        LocalDateTime tid = LocalDateTime.parse(tidStr);
        return tid;
    }

    
}