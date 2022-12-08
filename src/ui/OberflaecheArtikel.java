package ui;

import backend.Artikel;
import backend.SteuerungArtikel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
  * backend.Artikelverwaltung - GUI
  * Aufgabe3 : GUI – MVC-Schichtenmodell - Ereignisbehandlung
  * @version 1.1 vom 30.11.2022
  * @author C. Noeske, GHSE
  */
public class OberflaecheArtikel extends JFrame {
  // Anfang Attribute
  private JLabel jLUeberschrift = new JLabel();
  private JLabel jLBezeichnung = new JLabel();
  private JLabel jLLagerbestand = new JLabel();
  private JLabel jLVerkaufspreis = new JLabel();
  private JTextField jTFBezeichnung = new JTextField();
  private JNumberField jNFLagerbestand = new JNumberField();
  private JNumberField jNFVerkaufspreis = new JNumberField();
  private JButton jBUebernehmen = new JButton();
  // Anzeige-Steuerung
  private JButton jBZurueck = new JButton();
  private JButton jBVor = new JButton();
  // Suchen

  private SteuerungArtikel steuerung;
  // Ende Attribute
  
  
  public OberflaecheArtikel(String title) {
    // Frame-Initialisierung
    super(title);
    //Abschalten der Standard-Verhaltens für das Schließen des Fensters 
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
    //Neues Verhalten für das Schließen des Fensters
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
      } 
    }); 
    int frameWidth = 631; 
    int frameHeight = 415;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    jLUeberschrift.setBounds(72, 32, 355, 57);
    jLUeberschrift.setText("Artikelverwaltung");
    jLUeberschrift.setFont(new Font("Arial", Font.BOLD, 36));
    cp.add(jLUeberschrift);
    jLBezeichnung.setBounds(40, 104, 171, 41);
    jLBezeichnung.setText("Bezeichnung");
    jLBezeichnung.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jLBezeichnung);
    jLLagerbestand.setBounds(40, 160, 171, 33);
    jLLagerbestand.setText("Lagerbestand");
    jLLagerbestand.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jLLagerbestand);
    jLVerkaufspreis.setBounds(40, 208, 187, 41);
    jLVerkaufspreis.setText("Verkaufspreis");
    jLVerkaufspreis.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jLVerkaufspreis);
    jTFBezeichnung.setBounds(232, 112, 209, 33);
    jTFBezeichnung.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jTFBezeichnung);
    jNFLagerbestand.setBounds(232, 160, 121, 33);
    jNFLagerbestand.setText("");
    jNFLagerbestand.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jNFLagerbestand);
    jNFVerkaufspreis.setBounds(232, 208, 121, 33);
    jNFVerkaufspreis.setText("");
    jNFVerkaufspreis.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jNFVerkaufspreis);
    jBUebernehmen.setBounds(152, 256, 297, 49);
    jBUebernehmen.setText("Übernehmen");
    jBUebernehmen.setMargin(new Insets(2, 2, 2, 2));
    //a ActionListener des Uebernehmen - Buttons
    jBUebernehmen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBUebernehmen_ActionPerformed(evt);
      }
    });
    jBUebernehmen.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jBUebernehmen);
    //b Zurueck - Button
    jBZurueck.setBounds(48, 256, 49, 49);
    jBZurueck.setText("<");
    jBZurueck.setMargin(new Insets(2, 2, 2, 2));
    jBZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBZurueck_ActionPerformed(evt);
      }
    });
    jBZurueck.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jBZurueck);
    //b Vor - Button
    jBVor.setBounds(496, 256, 49, 49);
    jBVor.setText(">");
    jBVor.setMargin(new Insets(2, 2, 2, 2));
    jBVor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { 
        jBVor_ActionPerformed(evt);
      }
    });
    jBVor.setFont(new Font("Arial", Font.BOLD, 24));
    cp.add(jBVor);
    // Ende Komponenten
    steuerung = new SteuerungArtikel(this);
    setVisible(true);
  }
  // Anfang Methoden
  public void jBUebernehmen_ActionPerformed(ActionEvent evt) { //a
    String bezeichnung = this.jTFBezeichnung.getText();
    int lagerbestand = this.jNFLagerbestand.getInt();
    int preis = this.jNFVerkaufspreis.getInt();

    Artikel artikel = new Artikel(bezeichnung, lagerbestand);
    artikel.setVerkaufspreis(preis);
    artikel.print();

    this.jTFBezeichnung.setText("");
    this.jNFLagerbestand.setInt(0);
    this.jNFVerkaufspreis.setDouble(0);

    this.steuerung.addArtikel(artikel);
  }
  
  public void jBZurueck_ActionPerformed(ActionEvent evt) {  //b zurueck - Button
    Artikel artikel = this.steuerung.letzterArtikel();
    changeInformation(artikel);
  }
  
  public void jBVor_ActionPerformed(ActionEvent evt) {  //b vor  - Button
    Artikel artikel = this.steuerung.naechsterArtikel();
    changeInformation(artikel);
  }

  private void changeInformation(Artikel artikel) {
    if (artikel == null) return;

    this.jTFBezeichnung.setText(artikel.getBezeichnung());
    this.jNFLagerbestand.setInt(artikel.getLagerbestand());
    this.jNFVerkaufspreis.setDouble(artikel.getVerkaufspreis());
  }
  
  // Ende Methoden
  public static void main(String[] args) {
    new OberflaecheArtikel("frontend.OberflaecheArtikel");
  }
}
