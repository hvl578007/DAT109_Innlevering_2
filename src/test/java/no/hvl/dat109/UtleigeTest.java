package no.hvl.dat109;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Kunde;
import no.hvl.dat109.utleige.Reservasjon;
import no.hvl.dat109.utleige.Resultat;
import no.hvl.dat109.utleige.Utleige;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;

/**
 * UtleigeTest
 */
public class UtleigeTest {

    //TODO opprett noko selskap + kontor + bilar for å teste diverse i!
    Utleigeselskap selskap;
    List<Utleigekontor> kontorar;
    List<Kunde> kundar;

    Bil[] bil = new Bil[12];

    Utleigekontor kontor1;
    Utleigekontor kontor2;
    Utleigekontor kontor3;

    Kunde kunde1;
    Kunde kunde2;
    Kunde kunde3;
    Kunde kunde4;
    Kunde kunde5;

    Reservasjon reservasjon1;
    Reservasjon reservasjon2;
    Reservasjon reservasjon3;
    Reservasjon reservasjon4;

    Utleige utleige1;
    Utleige utleige2;

    @Before
    public void oppsett() {

        selskap = new Utleigeselskap("Tester", "10000000", new Adresse("Testvegen 1", "1234", "Test"));
        kontorar = selskap.getKontorListe();

        kontor1 = new Utleigekontor(new Adresse("Testvegen 10", "1210", "Testby1"), "11111111");
        kontor2 = new Utleigekontor(new Adresse("Testvegen 20", "1220", "Testby2"), "22222222");
        kontor3 = new Utleigekontor(new Adresse("Testvegen 30", "1230", "Testby3"), "33333333");

        bil[0] = new Bil("AB11111", "Testmerke", "Testmodell", "Blå", 'A', 14000);
        bil[1] = new Bil("AB12222", "Testmerke", "Testmodell", "Blå", 'B', 24000);
        bil[2] = new Bil("AB13333", "Testmerke", "Testmodell", "Blå", 'C', 34000);
        bil[3] = new Bil("AB14444", "Testmerke", "Testmodell", "Blå", 'D', 44000);
        bil[4] = new Bil("AB15555", "Testmerke", "Testmodell", "Blå", 'A', 54000);
        bil[5] = new Bil("AB16666", "Testmerke", "Testmodell", "Blå", 'B', 64000);
        bil[6] = new Bil("AB17777", "Testmerke", "Testmodell", "Blå", 'C', 74000);
        bil[7] = new Bil("AB18888", "Testmerke", "Testmodell", "Blå", 'D', 84000);

        bil[8] = new Bil("AB19999", "Testmerke", "Testmodell", "Blå", 'A', 94000);
        bil[9] = new Bil("AB20000", "Testmerke", "Testmodell", "Blå", 'B', 104000);
        bil[10] = new Bil("AB21111", "Testmerke", "Testmodell", "Blå", 'C', 114000);
        bil[11] = new Bil("AB22222", "Testmerke", "Testmodell", "Blå", 'D', 124000);

        for (int i = 0; i <= 7; i++) {
            kontor1.getBilar().add(bil[i]);
        }

        for (int i = 8; i <= 9; i++) {
            kontor2.getBilar().add(bil[i]);
        }

        for (int i = 10; i < bil.length; i++) {
            kontor3.getBilar().add(bil[i]);
        }

        kontorar.add(kontor1);
        kontorar.add(kontor2);
        kontorar.add(kontor3);

        kunde1 = new Kunde("Ola", "Normann", "12222222", new Adresse("Norgevegen1", "0000", "Norgebyen"));
        kunde2 = new Kunde("Per", "Normann", "13333333", new Adresse("Norgevegen2", "0001", "Norgebyen"));
        kunde3 = new Kunde("Tester", "Normann", "14444444", new Adresse("Norgevegen3", "0002", "Norgebyen"));
        kunde4 = new Kunde("Berit", "Normann", "15555555", new Adresse("Norgevegen4", "0003", "Norgebyen"));
        kunde5 = new Kunde("Nora", "Normann", "16666666", new Adresse("Norgevegen5", "0004", "Norgebyen"));

        selskap.getKundar().add(kunde1);
        selskap.getKundar().add(kunde2);
        selskap.getKundar().add(kunde3);
        selskap.getKundar().add(kunde4);
        selskap.getKundar().add(kunde5);

        kundar = selskap.getKundar();

        reservasjon1 = new Reservasjon(1, LocalDateTime.now(), 10, 1000, 'A');
        reservasjon2 = new Reservasjon(1, LocalDateTime.now(), 10, 2000, 'B');
        reservasjon3 = new Reservasjon(1, LocalDateTime.now(), 10, 3000, 'C');
        reservasjon4 = new Reservasjon(1, LocalDateTime.now(), 10, 4000, 'D');

        kunde1.leggTilReservasjon(reservasjon1);
        kunde1.leggTilReservasjon(reservasjon2);
        kunde2.leggTilReservasjon(reservasjon3);
        kunde2.leggTilReservasjon(reservasjon4);

        utleige1 = new Utleige(bil[0], reservasjon1, "1111000000001111", bil[0].getKilometerKoeyrd(), LocalDateTime.now(), LocalDateTime.now());
        utleige2 = new Utleige(bil[1], reservasjon2, "1111000110001111", bil[1].getKilometerKoeyrd(), LocalDateTime.now(), LocalDateTime.now());

        kunde1.leggTilUtleige(utleige1);
        kunde1.leggTilUtleige(utleige2);

    }

    @Test
    public void testSelskapFinnKontor() {
        assertEquals(kontor1, selskap.finnKontor(1));
        assertEquals(kontor2, selskap.finnKontor(2));
        assertEquals(kontor3, selskap.finnKontor(3));
        assertNull(selskap.finnKontor(0));
        assertNull(selskap.finnKontor(4));
        assertNotEquals(kontor3, selskap.finnKontor(2));
    }

    @Test
    public void testSelskapFinnKunde() {
        assertEquals(kunde1, selskap.finnKunde("12222222"));
        assertEquals(kunde2, selskap.finnKunde("13333333"));
        assertEquals(kunde3, selskap.finnKunde("14444444"));
        assertEquals(kunde4, selskap.finnKunde("15555555"));
        assertEquals(kunde5, selskap.finnKunde("16666666"));
        assertNull(selskap.finnKunde("11111111"));
    }

    @Test
    public void testKontorFinnLedigeUtleigeGrupper() {
        assertEquals(4, kontor1.finnLedigeUtleigeGrupper().size());
        assertEquals(2, kontor2.finnLedigeUtleigeGrupper().size());
        assertEquals(2, kontor3.finnLedigeUtleigeGrupper().size());
        
        bil[11].setErLedig(false);
        assertEquals(1, kontor3.finnLedigeUtleigeGrupper().size());
        bil[10].setErLedig(false);
        assertEquals(0, kontor3.finnLedigeUtleigeGrupper().size());
        bil[10].setErLedig(true);
        assertEquals(1, kontor3.finnLedigeUtleigeGrupper().size());

        bil[0].setErLedig(false);
        bil[4].setErLedig(false);
        assertEquals(3, kontor1.finnLedigeUtleigeGrupper().size());
    }

    @Test
    public void testKontorFinnReservasjonPaaKunde() {
        Reservasjon res = kontor1.finnReservasjonPaaKunde(kunde1);
        assertEquals(reservasjon1, res);
        res.setHarHenta(true);
        res = kontor1.finnReservasjonPaaKunde(kunde1);
        assertEquals(reservasjon2, res);
        res.setHarHenta(true);
        assertNull(kontor1.finnReservasjonPaaKunde(kunde1));
        assertNull(kontor2.finnReservasjonPaaKunde(kunde1));
        assertNull(kontor3.finnReservasjonPaaKunde(kunde1));
    }

    @Test
    public void testKontorLeigUtBil() {
        Bil b = kontor2.leigUtBil('A');
        assertEquals(bil[8], b);
        b = kontor2.leigUtBil('B');
        assertEquals(bil[9], b);
        b = kontor2.leigUtBil('A');
        assertNull(b);
    }

    @Test
    public void testKontorFinnUtleigePaaKunde() {
        Utleige u = kontor1.finnUtleigePaaKunde(kunde1);
        assertEquals(utleige1, u);
        u = kontor1.finnUtleigePaaKunde(kunde1, "AB12222");
        assertEquals(utleige2, u);
        u.setHarLevert(true);
        u = kontor1.finnUtleigePaaKunde(kunde1, "AB12222");
        assertNull(u);
    }

    @Test
    public void testResultatFinnPris() {
        Resultat r1 = new Resultat('A', 10);
        assertEquals(2000, r1.getPris());
        Resultat r2 = new Resultat('B', 10);
        assertEquals(3000, r2.getPris());
        Resultat r3 = new Resultat('C', 10);
        assertEquals(4000, r3.getPris());
        Resultat r4 = new Resultat('D', 10);
        assertEquals(5000, r4.getPris());
        Resultat r5 = new Resultat('E', 10);
        assertEquals(10000, r5.getPris());

    }

    @Test
    public void testSoekGjerEitSoek() {
        //usikker...
    }

    @Test
    public void testUtleigeGenererRekning() {
        //usikker...
        Utleige utleige = new Utleige(bil[0], new Reservasjon(1, LocalDateTime.now(), 10, 1000, 'A'), "1111000000001111", bil[0].getKilometerKoeyrd(), LocalDateTime.now(), LocalDateTime.now());
        String rekning = utleige.genererRekning();
        assertEquals("Det har blitt trukke 1000 kr på kortet: 1111000000001111", rekning);
    }
}