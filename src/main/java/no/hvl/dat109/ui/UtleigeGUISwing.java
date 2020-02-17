package no.hvl.dat109.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import no.hvl.dat109.Adresse;
import no.hvl.dat109.kontroller.UtleigeKontroller;
import no.hvl.dat109.kontroller.UtleigeKontrollerImpl;
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

        this.setTitle("Bilutleige");

        opprettKnappar();

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
        opprettKontorKnapp.setBounds(0,0,200,40);
        JButton opprettBilKnapp = new JButton("Opprett ny bil");
        opprettBilKnapp.setBounds(0, 50, 200, 40);

        opprettKontorKnapp.setActionCommand("opprettKontor");
        opprettKontorKnapp.addActionListener(this);

        opprettBilKnapp.setActionCommand("opprettBil");
        opprettBilKnapp.addActionListener(this);

        add(opprettKontorKnapp);
        add(opprettBilKnapp);

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
        } else {
            System.out.println("noko gjekk gale...");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Avsluttar programmet...");
    }


    public static void main(String[] args) {
        new UtleigeGUISwing();
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