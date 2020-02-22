package no.hvl.dat109.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import no.hvl.dat109.kontroller.UtleigeKontroller;
import no.hvl.dat109.kontroller.UtleigeKontrollerImpl;
import no.hvl.dat109.utleige.Utleigeselskap;


/**
 * Klasse som definerar hovudmenyen - UtleigeGUISwing
 * @author Stian Grønås
 */
public class UtleigeGUISwing extends JFrame implements ActionListener, WindowListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private UtleigeKontroller kontroller;


    /**
     * Opprettar ein GUI og spør om info om selskapet (tomt selskap)
     */
    public UtleigeGUISwing() {
        
        this.kontroller = new UtleigeKontrollerImpl();

        opprettKnappar();

        opprettFrame();
    }

    /**
     * Opprettar ein GUI på det gitte selskapet
     * @param selskap
     */
    public UtleigeGUISwing(Utleigeselskap selskap) {
        
        this.kontroller = new UtleigeKontrollerImpl(selskap);

        opprettKnappar();

        opprettFrame();
    }

    /**
     * Opprettar hovudframe-en
     */
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

    /**
     * Opprettar knappane på frame-en
     */
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
            //TODO fiks! ny metode i kontroller?
            System.out.println("Søker og reserverer. NB! Ikkje ferdig...");
            kontroller.soek();
            kontroller.reserver();
            
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