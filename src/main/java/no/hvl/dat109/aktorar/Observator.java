package no.hvl.dat109.aktorar;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

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

        //Sjef sjef = new Sjef(kontroller);
        //sjef.start();


        //Kunde kunde = new Kunde(kontroller);
        //kunde.start();

        //JOptionPane pane = new JOptionPane();
        UIManager.put("OptionPane.cancelButtonText", "nope");
        UIManager.put("OptionPane.okButtonText", "yup");
        JOptionPane.showInputDialog(null, null, "Skriv inn dato:", JOptionPane.QUESTION_MESSAGE, null, null, "");

        JOptionPane.showInputDialog("hei?");
        //JOptionPane.showOptionDialog(null, null, "Skriv inn dato:", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"DatoTidNå", "OK"}, "");
    }
}