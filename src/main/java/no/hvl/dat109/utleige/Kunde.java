package no.hvl.dat109.utleige;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Reservasjon;

/**
 * Klasse som definerar ein kunde
 * @author Stian Grønås
 */
public class Kunde {

    private String fornamn;
    private String etternamn;
    private String telefonnummer;
    private Adresse adresse;

    private List<Reservasjon> reservasjonar;
    private List<Utleige> utleigar;

    /**
     * Opprettar ein ny kunde
     * @param fornamn
     * @param etternamn
     * @param telefonnummer
     * @param adresse
     */
    public Kunde(String fornamn, String etternamn, String telefonnummer, Adresse adresse) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
        this.reservasjonar = new ArrayList<>();
        this.utleigar = new ArrayList<>();
    }

    /**
     * Legg til ein reservasjon på ein kunde
     * @param reservasjon
     */
	public void leggTilReservasjon(Reservasjon reservasjon) {
        this.reservasjonar.add(reservasjon);
    }
    
    /**
     * Legg til ein utleige på ein kunde
     * @param utleige
     */
    public void leggTilUtleige(Utleige utleige) {
        this.utleigar.add(utleige);
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEtternamn() {
        return etternamn;
    }

    public void setEtternamn(String etternamn) {
        this.etternamn = etternamn;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Reservasjon> getReservasjonar() {
        return reservasjonar;
    }

    public void setReservasjonar(List<Reservasjon> reservasjonar) {
        this.reservasjonar = reservasjonar;
    }

    public List<Utleige> getUtleigar() {
        return utleigar;
    }

    public void setUtleigar(List<Utleige> utleigar) {
        this.utleigar = utleigar;
    }

    @Override
    public boolean equals(Object obj) {
        Kunde kunde;
        if(obj instanceof Kunde) {
            kunde = (Kunde) obj;
            return this.getTelefonnummer().equals(kunde.getTelefonnummer());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Kunde [adresse=" + adresse + ", etternamn=" + etternamn + ", fornamn=" + fornamn +
                 ", telefonnummer=" + telefonnummer + "]";
    }

    
}