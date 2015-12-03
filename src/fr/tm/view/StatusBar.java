package fr.tm.view;

import java.awt.Dimension;

import javax.swing.JLabel;

public class StatusBar extends JLabel {

    /** Creates a new instance of StatusBar */
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Prêt");
    }

    public void setMessage(String message) {
        setText(" "+message);        
    }        
}