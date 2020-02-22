package no.hvl.dat109.ui;

import java.time.LocalDateTime;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Kunde;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Reservasjon;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleige;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * UtleigeUI
 */
public interface UtleigeUI {

    /**
     * Skriv ut ein melding
     * @param melding
     */
    public void skrivUt(String melding);

    /**
     * Les inn ein string
     * @param melding
     * @return
     */
    public String lesInnString(String melding);

    /**
     * Les inn eit tal
     * @param melding
     * @return
     */
    public int lesInnInteger(String melding);

    /**
     * Les inn ein char
     * @param melding
     * @return
     */
    public char lesInnChar(String melding);

    /**
     * Lagar ei ny adresse og spør om info til denne
     * @return adressa
     */
    public Adresse lagAdresseMedInfo();

    /**
     * Lagar ein ny bil og spør om info til denne
     * @return bilen
     */
    public Bil lagBilMedInfo();

    /**
     * Lagar eit nytt kontor og spør om info til denne
     * @return kontoret
     */
    public Utleigekontor lagKontorMedInfo();

    /**
     * Lagar eit nytt selskap og spør om info til denne
     * @return selskapet
     */
	public Utleigeselskap lagSelskapMedInfo();

    /**
     * Leg inn eit kontornummer
     * @return kontornummeret
     */
	public int lesInnKontorNr();

    /**
     * Les inn info om eit søk og opprettar eit nytt søke-objekt
     * @return søk-objekt
     */
	public Soek lesInnSoek();

    /**
     * Visar resultat av eit søk
     * @param soek
     */
    public void visSoekResultat(Soek soek);
    
    /**
     * Less inn ein dato og tida
     * @return objekt av localdatetime
     */
    public LocalDateTime lesInnDatoTid();

    /**
     * Les inn eit resultatnummer på eit søk
     * @param soek
     * @return nummeret
     */
    public int lesInnResultatNr(Soek soek);

    /**
     * Lagar ein kunde med info
     * @return kunden
     */
    public Kunde lagKundeMedInfo();

    /**
     * Skriv ut kunde + reservasjon
     * @param kunde
     * @param reservasjon
     */
    public void skrivUtKundeReservasjon(Kunde kunde, Reservasjon reservasjon);

    /**
     * Les inn eit telefonnummer
     * @return tlf
     */
    public String lesInnTlfNr();

    /**
     * Les inn info om kortnummeret
     * @return kortnummeret
     */
    public String lesInnKortNr();

    /**
     * Skriv ut ein utleige
     * @param utleige
     */
	public void skrivUtUtleige(Utleige utleige);

    /**
     * Spør om ein er ein eksisterande kunde
     * @return 0 om JA, 1 om NEI
     */
	public int spoerOmEksisterandeKunde();

}