package no.hvl.dat109.kontroller;

/**
 * UtleigeKontroller
 */
public interface UtleigeKontroller {

    /**
     * Oppretter ein ny bil på eit kontor\n
     * Bil-info og kontor-nr blir spurt via UI
     */
    public void opprettBilPaaKontor();
    
    /**
     * Opprettar eit nytt kontor på selskapet\n
     * Kontor-info blir spurt via UI
     */
    public void opprettKontor();

    /**
     * Gjer eit søk i systemet\n
     * diverse info om søket blir lagra i eit objekt og spurt via UI
     */
    public void soek();

}