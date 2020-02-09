package no.hvl.dat109;

/**
 * Klasse som definerar ei adresse
 * @author Stian Grønås
 */
public class Adresse {

    private String gateadresse;
    private String postnummer;
    private String poststad;

    /**
     * Opprettar ei adresse
     * @param gateadresse
     * @param postnummer
     * @param poststad
     */
    public Adresse(String gateadresse, String postnummer, String poststad) {
        this.gateadresse = gateadresse;
        this.postnummer = postnummer;
        this.poststad = poststad;
    }

    //TODO ctor som kontaktar UI for å få inn info automatisk?

    public String getGateadresse() {
        return gateadresse;
    }

    public void setGateadresse(String gateadresse) {
        this.gateadresse = gateadresse;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststad() {
        return poststad;
    }

    public void setPoststad(String poststad) {
        this.poststad = poststad;
    }

    @Override
    public String toString() {
        return "Adresse [gateadresse=" + gateadresse + ", postnummer=" + postnummer + ", poststad=" + poststad + "]";
    }
}