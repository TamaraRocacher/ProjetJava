package fr.tm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import fr.tm.model.TableModel;
import fr.tm.model.Taches;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel pan;
	JPanel panNouvelleTache;
	JPanel panRight;
	JScrollPane scroll;
	JTable table;
	
	JRadioButtonMenuItem vueSimple;
	JRadioButtonMenuItem vueDetaillee;
	
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
	
	public void initTable() {
		//String title[] = {"Effectuée","Intitulé","Date Début", "Date Fin", "Catégorie", "Suppression"};
		table = new JTable();
		//table.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
	}
	
	
	public void initComponents() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Affichage");
		ButtonGroup mode = new ButtonGroup();
		vueSimple = new JRadioButtonMenuItem("Vue Simple");
		vueDetaillee = new JRadioButtonMenuItem("Vue Détaillée");
		mode.add(vueSimple);
		mode.add(vueDetaillee);
		vueSimple.setSelected(true);
		
		menuBar.add(menu);
		
		menu.add(vueSimple);
		menu.add(vueDetaillee);
		
		this.setJMenuBar(menuBar);
		pan = new JPanel();
		panNouvelleTache = new JPanel();
		panRight = new JPanel();
		boutonMaJ = new JButton("Valider");
		
		ButtonGroup bg = new ButtonGroup();
		//pan.setPreferredSize(new Dimension(400,100));
		//panNouvelleTache.setPreferredSize(new Dimension(400,100));
		
		intitule = new JTextField();
		categorie = new JComboBox();
		categorie.addItem(new String("Test"));
		
		dateDebut = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dateDebut.setValue(new java.util.Date());
		
		dateFin = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dateFin.setValue(new java.util.Date());
		
		initTable();
		
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(800,300));
		
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
		//boutonMaJ = new JButton();
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

	public void setCategorie(JComboBox<String> categorie) {
		this.categorie = categorie;
	}
	
	public void update() {
		//table.getColumn("Suppression").setCellEditor(new ButtonEditor(new JCheckBox()));
		this.table.getColumn("Suppression").setCellRenderer(new ButtonRenderer());
		
		/*table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table,
	                Object value, boolean isSelected, boolean hasFocus, int row,
	                int column) {
	 
	            if (value instanceof JComboBox) {
	                return (JComboBox) value;
	            }
	            if (value instanceof Boolean) {
	                JCheckBox cb = new JCheckBox();
	                cb.setSelected(((Boolean) value).booleanValue());
	                return cb;
	            }
	            if (value instanceof JCheckBox) {
	                return (JCheckBox) value;
	            }
	            return new JTextField(value.toString());
	        }
		});*/
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
