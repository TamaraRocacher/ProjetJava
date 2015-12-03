package fr.tm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import fr.tm.model.Taches;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel pan;
	JPanel panNouvelleTache;
	JPanel panRight;
	JScrollPane scroll;
	JTable table;
	
	JRadioButton ponctuel = new JRadioButton("Tâche Ponctuelle");
	JRadioButton longCours = new JRadioButton("Tâche au long cours");
	JTextField intitule;
	JFormattedTextField dateDebut;
	JFormattedTextField dateFin;
	JComboBox categorie;
	JButton boutonMaJ;
	
	
	StatusBar status = new StatusBar();
	
	public View() {
		//this.setPreferredSize(new Dimension(800,400));
		this.setTitle("TodoList");
		ImageIcon img = new ImageIcon("main.png");
		this.setIconImage(img.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
		initComponents();

		this.add(pan, BorderLayout.CENTER);
		pan.add(panRight, BorderLayout.EAST);
		this.add(status, BorderLayout.SOUTH);
		panNouvelleTache.setVisible(true);
		this.pack();
		this.setVisible(true);
	}
	
	public void initComponents() {
		pan = new JPanel();
		panNouvelleTache = new JPanel();
		panRight = new JPanel();
		boutonMaJ = new JButton("Mettre à jour");
		
		ButtonGroup bg = new ButtonGroup();
		//pan.setPreferredSize(new Dimension(400,100));
		//panNouvelleTache.setPreferredSize(new Dimension(400,100));
		
		intitule = new JTextField();
		categorie = new JComboBox();
		
		dateDebut = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dateDebut.setValue(new java.util.Date());
		
		dateFin = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dateFin.setValue(new java.util.Date());
		
		Object[][] data = {
			{true, "Faire le Projet Java", "13/11/2015", "13/12/2015"},
			{false,"Aller à la peche", "03/12/2015", "07/12/2015"}
		};
		
		String title[] = {"Effectuée","Intitulé","Date Début", "Date Fin"};
		table = new JTable(data, title);
		
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(500,300));
		
		panNouvelleTache.setLayout(new GridLayout(4,2));
		//layout.putConstraint(SpringLayout.WEST, intitule, 5, SpringLayout.EAST, panNouvelleTache);
		panNouvelleTache.add(new JLabel("Intitulé: "));
		panNouvelleTache.add(intitule);
		panNouvelleTache.add(new JLabel("Date Début: "));
		panNouvelleTache.add(dateDebut);
		panNouvelleTache.add(new JLabel("Date Fin: "));
		panNouvelleTache.add(dateFin);
		panNouvelleTache.add(new JLabel("Catégorie: "));
		panNouvelleTache.add(categorie);
		//panNouvelleTache.add(boutonMaJ);
		
		bg.add(ponctuel);
		bg.add(longCours);
		ponctuel.setSelected(true);
		//panRight.setMaximumSize(new Dimension(200,100));
		
		GridBagLayout gbl = new GridBagLayout();
		panRight.setLayout(gbl);
		
		
		
		//gbl.layoutContainer(panRight);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.NORTHWEST;
		gbc.fill = gbc.VERTICAL;
		gbc.gridx = 1;
		gbc.gridy++;
		gbc.weightx = 0;

		gbc.weighty=50;
		
		panRight.add(ponctuel,gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		panRight.add(longCours, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		panRight.add(panNouvelleTache, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		panRight.add(boutonMaJ, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		pan.add(scroll, BorderLayout.WEST);
		boutonMaJ = new JButton();
	}
	
	public void addListener(ActionListener listenForUpdate) {
		boutonMaJ.addActionListener(listenForUpdate);
	}

	public JRadioButton getPonctuel() {
		return ponctuel;
	}

	public void setPonctuel(JRadioButton ponctuel) {
		this.ponctuel = ponctuel;
	}

	public JRadioButton getLongCours() {
		return longCours;
	}

	public void setLongCours(JRadioButton longCours) {
		this.longCours = longCours;
	}

	public JTextField getIntitule() {
		return intitule;
	}

	public void setIntitule(JTextField intitule) {
		this.intitule = intitule;
	}

	public JFormattedTextField getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(JFormattedTextField dateDebut) {
		this.dateDebut = dateDebut;
	}

	public JFormattedTextField getDateFin() {
		return dateFin;
	}

	public void setDateFin(JFormattedTextField dateFin) {
		this.dateFin = dateFin;
	}

	public JComboBox getCategorie() {
		return categorie;
	}

	public void setCategorie(JComboBox categorie) {
		this.categorie = categorie;
	}
	
	public void update(Taches taches) {
		
	}
}
