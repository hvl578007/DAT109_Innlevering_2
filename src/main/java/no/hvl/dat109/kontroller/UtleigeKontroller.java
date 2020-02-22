package no.hvl.dat109.kontroller;

/**
 * Inteface UtleigeKontroller
 * @author
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

    /**
     * Reserverar ein reservasjon og lagrar kundeinfo
     */
    public void reserver();
    //TODO endre til at den returnerer kunde-objektet?! eller i det minste reservasjons-objektet

    /**
     * Hentar ein bil ved eit kontor
     */
    public void hentBil();
    //TODO endre til at den returnerer kunde-objektet?! eller i det minste utleige-objektet

    /**
     * Leverer ein bil til eit kontor
     */
    public void leverBil();
    //TODO endre til at den returnerer kunde-objektet?! eller i det minste utleige-objektet

}