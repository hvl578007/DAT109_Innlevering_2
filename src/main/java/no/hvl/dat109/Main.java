﻿package no.hvl.dat109;

import java.util.List;

import javax.swing.JOptionPane;

import no.hvl.dat109.ui.UtleigeGUISwing;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * Klasse som har main-metoden i seg
 * @author Stian Grønås
 */
public class Main {

    /**
     * Main-metode som startar heile programmet
     */
    public static void main(String[] args) {

        int svar = JOptionPane.showOptionDialog(null, "Bruke eit testselskap? (JA)\nOpprette eit nytt? (NYTT)", "Selskap?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"JA", "NYTT"}, "");

        if (svar == 0) {
            //opprettar eit testselskap med info allereie der
            UtleigeGUISwing gui = new UtleigeGUISwing(opprettTestSelskap());
        } else {
            //spør etter info om selskapet
            UtleigeGUISwing gui = new UtleigeGUISwing();
        }
    }

    /**
     * Opprettar eit testselskap med diverse info allereie der
     * @return selskapet
     */
    private static Utleigeselskap opprettTestSelskap() {
        Utleigeselskap selskap = new Utleigeselskap("Tester", "00000000", new Adresse("Testvegen 1", "1234", "Test"));
        List<Utleigekontor> kontorar = selskap.getKontorListe();

        Utleigekontor kontor1 = new Utleigekontor(new Adresse("Testvegen 10", "1210", "Testby1"), "11111111");
        Utleigekontor kontor2 = new Utleigekontor(new Adresse("Testvegen 20", "1220", "Testby2"), "22222222");
        Utleigekontor kontor3 = new Utleigekontor(new Adresse("Testvegen 30", "1230", "Testby3"), "33333333");

        Bil bil1 = new Bil("AB11111", "Testmerke", "Testmodell", "Blå", 'A', 14000);
        Bil bil2 = new Bil("AB12222", "Testmerke", "Testmodell", "Blå", 'B', 24000);
        Bil bil3 = new Bil("AB13333", "Testmerke", "Testmodell", "Blå", 'C', 34000);
        Bil bil4 = new Bil("AB14444", "Testmerke", "Testmodell", "Blå", 'D', 44000);
        Bil bil5 = new Bil("AB15555", "Testmerke", "Testmodell", "Blå", 'A', 54000);
        Bil bil6 = new Bil("AB16666", "Testmerke", "Testmodell", "Blå", 'B', 64000);
        Bil bil7 = new Bil("AB17777", "Testmerke", "Testmodell", "Blå", 'C', 74000);
        Bil bil8 = new Bil("AB18888", "Testmerke", "Testmodell", "Blå", 'D', 84000);

        Bil bil9 = new Bil("AB19999", "Testmerke", "Testmodell", "Blå", 'A', 94000);
        Bil bil10 = new Bil("AB20000", "Testmerke", "Testmodell", "Blå", 'B', 104000);
        Bil bil11 = new Bil("AB21111", "Testmerke", "Testmodell", "Blå", 'C', 114000);
        Bil bil12 = new Bil("AB22222", "Testmerke", "Testmodell", "Blå", 'D', 124000);

        kontor1.getBilar().add(bil1);
        kontor1.getBilar().add(bil2);
        kontor1.getBilar().add(bil3);
        kontor1.getBilar().add(bil4);
        kontor1.getBilar().add(bil5);
        kontor1.getBilar().add(bil6);
        kontor1.getBilar().add(bil7);
        kontor1.getBilar().add(bil8);

        kontor2.getBilar().add(bil9);
        kontor2.getBilar().add(bil10);
        kontor3.getBilar().add(bil11);
        kontor3.getBilar().add(bil12);

        kontorar.add(kontor1);
        kontorar.add(kontor2);
        kontorar.add(kontor3);

        return selskap;
    }
}