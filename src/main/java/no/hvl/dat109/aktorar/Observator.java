package no.hvl.dat109.aktorar;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.kontroller.UtleigeKontroller;
import no.hvl.dat109.kontroller.UtleigeKontrollerImpl;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * Klasse som definerar ein observator
 * @author Stian Grønås
 */
public class Observator {

    public static void main(String[] args) {

        Utleigeselskap utleigeselskap = new Utleigeselskap("testbil", "00000000", new Adresse("testvegen 1", "1234", "fiktiv"));
        UtleigeKontroller kontroller = new UtleigeKontrollerImpl(utleigeselskap);
        
        //observatør startar metodar på kontroller

        Sjef sjef = new Sjef(kontroller);
        sjef.start();


        Kunde kunde = new Kunde(kontroller);
        kunde.start();
    }
}