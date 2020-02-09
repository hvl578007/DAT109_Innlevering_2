package no.hvl.dat109.aktorar;

import no.hvl.dat109.kontroller.UtleigeKontroller;;

/**
 * Klasse som definerar ein liksom-sjef
 * @author Stian Grønås
 */
public class Sjef {

    private UtleigeKontroller utleigeKontroller;

    /**
     * Opprettar ein sjef
     * @param utleigeKontroller
     */
    public Sjef(UtleigeKontroller utleigeKontroller) {
        this.utleigeKontroller = utleigeKontroller;
    }

    /**
     * Opprettar ein "tom" sjef
     */
    public Sjef() {
        this.utleigeKontroller = null;
    }

    /**
     * Startar logikken til sjefen (opprette kontor/bilar på selskapet sitt)
     */
    public void start() {
        int n = 2;
        int m = 2;

        for (int i = 0; i < n; i++) {
            utleigeKontroller.opprettKontor();
        }


        for (int i = 0; i < m; i++) {
            utleigeKontroller.opprettBilPaaKontor();
        }
    }

    public UtleigeKontroller getUtleigeKontroller() {
        return utleigeKontroller;
    }

    public void setUtleigeKontroller(UtleigeKontroller utleigeKontroller) {
        this.utleigeKontroller = utleigeKontroller;
    }
}