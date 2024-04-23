package View.PageResultats.conteneurprincipal.voitures;

import Model.EmployeModel;
import Model.VoitureModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import View.ConteneurEmploye;
import View.VueEmploye;


public class ModifierVoiture extends JDialog {

    private VoitureModel voiture;
    private JTextField fieldIdPlaque;
    private JTextField fieldNomModele;
    private JTextField fieldType;
    private JTextField fieldCouleur;
    private JTextField fieldMoteur;
    private JTextField fieldNbPlace;
    private JTextField fieldCapaciteValise;
    private JTextField fieldNbPorte;
    private JTextField fieldTransmission;
    private JTextField fieldCapaEssence;
    private JTextField fieldAnnee;
    private JTextField fieldKilometrageActuel;
    private JTextField fieldPrix;
    private JTextField fieldLieuPriseEnCharge;
    private JTextField fieldLimiteKm;
    private JTextField fieldMarque;
    private JTextField fieldImageVoiture;
    private EmployeModel employe;

    public ModifierVoiture(VoitureModel voiture, EmployeModel employeModel) throws SQLException, ClassNotFoundException {
        this.voiture = voiture;
        this.employe = employeModel;
        initialize();
    }

    public void initialize() {
        setTitle("Modifier Voiture");
        setSize(1000, 800);

        setLayout(new GridLayout(16, 2));
        //ConteneurEmploye conteneurEmploye = new ConteneurEmploye(employe,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        //add(conteneurEmploye, BorderLayout.NORTH);


        add(new JLabel("ID Plaque : "));
        fieldIdPlaque = new JTextField(voiture.getId_plaque());
        add(fieldIdPlaque);

        add(new JLabel("Nom Modele : "));
        fieldNomModele = new JTextField(voiture.getnom_modele());
        add(fieldNomModele);

        add(new JLabel("Type : "));
        fieldType = new JTextField(voiture.getType());
        add(fieldType);

        add(new JLabel("Couleur : "));
        fieldCouleur = new JTextField(voiture.getCouleur());
        add(fieldCouleur);

        add(new JLabel("Moteur : "));
        fieldMoteur = new JTextField(voiture.getMoteur());
        add(fieldMoteur);

        add(new JLabel("Nb Place : "));
        fieldNbPlace = new JTextField(String.valueOf(voiture.getNbPlace()));
        add(fieldNbPlace);

        add(new JLabel("Capacite Valise : "));
        fieldCapaciteValise = new JTextField(String.valueOf(voiture.getCapaciteValise()));
        add(fieldCapaciteValise);

        add(new JLabel("Nb Porte : "));
        fieldNbPorte = new JTextField(String.valueOf(voiture.getNbPorte()));
        add(fieldNbPorte);

        add(new JLabel("Transmission : "));
        fieldTransmission = new JTextField(voiture.getTransmission());
        add(fieldTransmission);

        add(new JLabel("Capa Essence : "));
        fieldCapaEssence = new JTextField(String.valueOf(voiture.getCapaEssence()));
        add(fieldCapaEssence);

        add(new JLabel("Annee : "));
        fieldAnnee = new JTextField(String.valueOf(voiture.getAnnee()));
        add(fieldAnnee);

        add(new JLabel("Kilometrage Actuel : "));
        fieldKilometrageActuel = new JTextField(String.valueOf(voiture.getkilometrage_actuel()));
        add(fieldKilometrageActuel);

        add(new JLabel("Prix : "));
        fieldPrix = new JTextField(String.valueOf(voiture.getPrix()));
        add(fieldPrix);

        add(new JLabel("Lieu Prise En Charge : "));
        fieldLieuPriseEnCharge = new JTextField(voiture.getLieuPriseEnCharge());
        add(fieldLieuPriseEnCharge);

        add(new JLabel("Limite Km : "));
        fieldLimiteKm = new JTextField(String.valueOf(voiture.getLimite_km()));
        add(fieldLimiteKm);

        add(new JLabel("Marque : "));
        fieldMarque = new JTextField(voiture.getMarque());
        add(fieldMarque);

        add(new JLabel("Image Voiture : "));
        fieldImageVoiture = new JTextField(voiture.getImage_voiture());
        add(fieldImageVoiture);

        JButton saveButton = new JButton("Enregistrer les modifications");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    voiture.setNom_modele(fieldNomModele.getText());
                    voiture.setType(fieldType.getText());
                    voiture.setCouleur(fieldCouleur.getText());
                    voiture.setMoteur(fieldMoteur.getText());
                    voiture.setNbPlace(Integer.parseInt(fieldNbPlace.getText()));
                    voiture.setCapacite_valise(Integer.parseInt(fieldCapaciteValise.getText()));
                    voiture.setNbPorte(Integer.parseInt(fieldNbPorte.getText()));
                    voiture.setTransmission(fieldTransmission.getText());
                    voiture.setCapaEssence(Integer.parseInt(fieldCapaEssence.getText()));
                    voiture.setAnnee(Integer.parseInt(fieldAnnee.getText()));
                    voiture.setKilometrage_actuel(Integer.parseInt(fieldKilometrageActuel.getText()));
                    voiture.setPrix(Integer.parseInt(fieldPrix.getText()));
                    voiture.setLieuPriseEnCharge(fieldLieuPriseEnCharge.getText());
                    voiture.setLimite_km(Integer.parseInt(fieldLimiteKm.getText()));
                    voiture.setMarque(fieldMarque.getText());
                    voiture.setImage_voiture(fieldImageVoiture.getText());

                    voiture.MajPartielBdd(voiture.getId_plaque(), "nom_modele", fieldNomModele.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "type", fieldType.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "couleur", fieldCouleur.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "moteur", fieldMoteur.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "nb_place", String.valueOf(voiture.getNbPlace()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "capacite_valise", String.valueOf(voiture.getCapaciteValise()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "nb_porte", String.valueOf(voiture.getNbPorte()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "transmission", fieldTransmission.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "capa_essence", String.valueOf(voiture.getCapaEssence()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "annee", String.valueOf(voiture.getAnnee()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "kilometrage_actuel", String.valueOf(voiture.getkilometrage_actuel()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "prix", String.valueOf(voiture.getPrix()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "lieu_prise_en_charge", fieldLieuPriseEnCharge.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "limite_km", String.valueOf(voiture.getLimite_km()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "marque", fieldMarque.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "image_voiture", fieldImageVoiture.getText());

                    JOptionPane.showMessageDialog(null, "Les modifications ont été enregistrées avec succès !");
                    String lieuDepart = ""; // Fournir la valeur appropriée
                    String dateDepart = ""; // Fournir la valeur appropriée
                    String lieuRetour = ""; // Fournir la valeur appropriée
                    String dateRetour = ""; // Fournir la valeur appropriée

                    VueEmploye vp = new VueEmploye(employe);


                    vp.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);
                    dispose(); // fermer la fenêtre actuelle
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour de la voiture : " + ex.getMessage());
                }
            }
        });
        JButton boutonRetour = new JButton("Retour");
        add(boutonRetour);
        //conteneurEmploye.add(boutonRetour, BorderLayout.SOUTH);

        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String lieuDepart = ""; // Fournir la valeur appropriée
                    String dateDepart = ""; // Fournir la valeur appropriée
                    String lieuRetour = ""; // Fournir la valeur appropriée
                    String dateRetour = ""; // Fournir la valeur appropriée

                    VueEmploye vp = new VueEmploye(employe);


                    vp.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);
                    dispose(); // fermer la fenêtre actuelle
                } catch (SQLException ex)
                {
                    //popUpDefault erreur1emp = new popUpDefault(ConnexionVue.this, "Erreur de base de données : " + ex.getMessage());
                    //erreur1emp.setVisible(true);
                }
                catch (ClassNotFoundException ex)
                {
                    //popUpDefault erreur2 = new popUpDefault(ConnexionVue.this, "Classe introuvable : " + ex.getMessage());
                    //erreur2.setVisible(true);
                }
            }
        });
    }
}
