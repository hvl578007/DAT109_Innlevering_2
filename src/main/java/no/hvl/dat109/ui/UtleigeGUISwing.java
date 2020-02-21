package no.hvl.dat109.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.kontroller.UtleigeKontroller;
import no.hvl.dat109.kontroller.UtleigeKontrollerImpl;
import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Utleigekontor;
import no.hvl.dat109.utleige.Utleigeselskap;


/**
 * UtleigeGUISwing
 */
public class UtleigeGUISwing extends JFrame implements ActionListener, WindowListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private UtleigeKontroller kontroller;


    public UtleigeGUISwing() {
        
        Utleigeselskap utleigeselskap = new Utleigeselskap("testbil", "00000000", new Adresse("testvegen 1", "1234", "fiktiv"));
        this.kontroller = new UtleigeKontrollerImpl(utleigeselskap);

        opprettKnappar();

        opprettFrame();
    }

    public UtleigeGUISwing(Utleigeselskap selskap) {
        
        this.kontroller = new UtleigeKontrollerImpl(selskap);

        opprettKnappar();

        opprettFrame();
    }

    private void opprettFrame() {
        this.setTitle("Bilutleige");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(this);

        setDefaultLookAndFeelDecorated(true);
    }

    private void opprettKnappar() {

        JButton opprettKontorKnapp = new JButton("Opprett nytt kontor");
        JButton opprettBilKnapp = new JButton("Opprett ny bil");
        JButton soekKnapp = new JButton("Gjer eit søk");
        JButton reserverKnapp = new JButton("Reserver");

        JButton soekOgReserverKnapp = new JButton("Søk og reserver");

        JButton hentBilKnapp = new JButton("Hent ein bil");
        JButton leverBilKnapp = new JButton("Lever ein bil");

        opprettKontorKnapp.setBounds(0,0,200,40);
        opprettBilKnapp.setBounds(0,50,200,40);
        soekKnapp.setBounds(0,100,200,40);
        reserverKnapp.setBounds(0,150,200,40);
        soekOgReserverKnapp.setBounds(0,200,200,40);
        hentBilKnapp.setBounds(0,250,200,40);
        leverBilKnapp.setBounds(0,300,200,40);

        opprettKontorKnapp.setActionCommand("opprettKontor");
        opprettKontorKnapp.addActionListener(this);

        opprettBilKnapp.setActionCommand("opprettBil");
        opprettBilKnapp.addActionListener(this);

        soekKnapp.setActionCommand("soek");
        soekKnapp.addActionListener(this);

        reserverKnapp.setActionCommand("reserver");
        reserverKnapp.addActionListener(this);

        soekOgReserverKnapp.setActionCommand("soekOgReserver");
        soekOgReserverKnapp.addActionListener(this);

        hentBilKnapp.setActionCommand("hentBil");
        hentBilKnapp.addActionListener(this);

        leverBilKnapp.setActionCommand("leverBil");
        leverBilKnapp.addActionListener(this);

        add(opprettKontorKnapp);
        add(opprettBilKnapp);
        add(soekKnapp);
        add(reserverKnapp);
        add(soekOgReserverKnapp);
        add(hentBilKnapp);
        add(leverBilKnapp);

    }

    //TODO i annan klasse?
    @Override
    public void actionPerformed(ActionEvent e) {
        if("opprettBil".equals(e.getActionCommand())) {
            System.out.println("Det skal oprettast ein bil...");
            kontroller.opprettBilPaaKontor();

        } else if("opprettKontor".equals(e.getActionCommand())) {
            System.out.println("Det skal opprettast eit kontor...");
            kontroller.opprettKontor();

        } else if ("soek".equals(e.getActionCommand())) {
            System.out.println("Gjer eit søk...");
            kontroller.soek();

        } else if ("reserver".equals(e.getActionCommand())) {
            System.out.println("Gjer ein reservasjon...");
            kontroller.reserver();

        } else if ("soekOgReserver".equals(e.getActionCommand())) {
            //TODO
            
        } else if ("hentBil".equals(e.getActionCommand())) {
            System.out.println("Henter ein bil...");
            kontroller.hentBil();

        } else if ("leverBil".equals(e.getActionCommand())) {
            System.out.println("Leverer ein bil...");
            kontroller.leverBil();

        } else {
            System.out.println("noko gjekk gale...");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Avsluttar programmet...");
    }


    public static void main(String[] args) {
        Utleigeselskap selskap = new Utleigeselskap("Tester", "12345678", new Adresse("Testvegen 1", "1234", "Test"));
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


        new UtleigeGUISwing(selskap);
    }

    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}