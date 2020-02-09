package no.hvl.dat109.ui;

import javax.swing.JOptionPane;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.utleige.Bil;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bil lagBilMedInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Utleigekontor lagKontorMedInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Utleigeselskap lagSelskapMedInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lesInnKontorNr() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}