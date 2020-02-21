package no.hvl.dat109.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

import no.hvl.dat109.utleige.Bil;
import no.hvl.dat109.utleige.Kunde;
import no.hvl.dat109.utleige.Soek;
import no.hvl.dat109.utleige.Utleigekontor;

/**
 * UtleigeGUISwingInput
 * @author Stian Grønås
 */
public class UtleigeGUISwingInput extends JFrame implements ActionListener, WindowListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UtleigeGUISwingInput() {

    }

    public static void main(String[] args) {
        UtleigeGUISwingInput input = new UtleigeGUISwingInput();
        input.opprettNyBilGUI();
    }

    private void opprettFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(this);

        setDefaultLookAndFeelDecorated(true);
    }

    public Bil opprettNyBilGUI() {
        this.setTitle("Opprett ny bil");
    
        //JTextField tekstfelt = new JT
        this.opprettFrame();
        return null;
    }

    public Kunde opprettNyKundeGUI() {
        this.setTitle("Opprett ny kunde");
        return null;
    }

    public Soek opprettNyttSoekGUI() {
        this.setTitle("Søkeinfo");

        return null;
    }

    public Utleigekontor opprettNyttKontorGUI() {
        this.setTitle("Opprett nytt kontor");
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

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