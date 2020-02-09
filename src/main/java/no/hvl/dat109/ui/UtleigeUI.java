package no.hvl.dat109.ui;

import java.time.LocalDateTime;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Soek;
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
    
    public LocalDateTime lesInnDatoTid();

}