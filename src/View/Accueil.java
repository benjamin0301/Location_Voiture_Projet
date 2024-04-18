package View;

import View.PageResultats.ConteneurHaut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.sql.SQLException;


public class Accueil extends JFrame {

    private JComboBox<String> JourDepart;
    private JComboBox<String> MoisDepart;
    private JComboBox<String> AnneeDepart;
    private JComboBox<String> JourArrivee;
    private JComboBox<String> MoisArrivee;
    private JComboBox<String> AnneeArrivee;
    private JTextField lieuField;
    public String getLieu() {
        return lieuField.getText();
    }

    public String getDateDepart() {
        return JourDepart.getSelectedItem() + "/" + (MoisDepart.getSelectedIndex() + 1) + "/" + AnneeDepart.getSelectedItem();
    }

    public String getDateRetour() {
        return JourArrivee.getSelectedItem() + "/" + (MoisArrivee.getSelectedIndex() + 1) + "/" + AnneeArrivee.getSelectedItem();
    }


    public Accueil() {
        setTitle("Accueil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // ouvre la page en grand directement
        setLocationRelativeTo(null);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut();
        add(conteneurHaut, BorderLayout.NORTH);

        // Initialisation des listes deroulantes pour les jours, les mois et les annees de depart
        initComboBoxes(true);
        JPanel departPanel = new JPanel();
        departPanel.add(JourDepart);
        departPanel.add(MoisDepart);
        departPanel.add(AnneeDepart);

        // Initialisation des listes deroulantes pour les jours, les mois et les annees d'arrivee
        initComboBoxes(false);
        JPanel arriveePanel = new JPanel();
        arriveePanel.add(JourArrivee);
        arriveePanel.add(MoisArrivee);
        arriveePanel.add(AnneeArrivee);

        // Champ de texte pour le lieu de prise en charge
        lieuField = new JTextField(20);
        JPanel lieuPanel = new JPanel();
        lieuPanel.add(new JLabel("Lieu de prise en charge : "));
        lieuPanel.add(lieuField);

        // Bouton pour confirmer la selection des dates
        JButton confirmButton = new JButton("Confirmer");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isDateValid()) {
                    JOptionPane.showMessageDialog(Accueil.this, "La date d'arrivee doit être après la date de depart.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                String departDate = JourDepart.getSelectedItem() + "/" +
                        (MoisDepart.getSelectedIndex() + 1) + "/" +
                        AnneeDepart.getSelectedItem();
                String arriveeDate = JourArrivee.getSelectedItem() + "/" +
                        (MoisArrivee.getSelectedIndex() + 1) + "/" +
                        AnneeArrivee.getSelectedItem();
                String lieu = lieuField.getText();
                JOptionPane.showMessageDialog(Accueil.this, "Date de depart : " + departDate + "\nDate d'arrivee : " + arriveeDate + "\nLieu de prise en charge : " + lieu);


                System.out.println("Connexion établie avec succès !");

                // Initialiser le reste de l'application
                SwingUtilities.invokeLater(() -> {
                    try {
                        Vue vue = new Vue();

                        vue.initialize(getLieu(), getDateDepart(), getLieu(), getDateRetour());
                        fermerFenetre();
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                });

            }
        });

        // Ajout des composants à la fenêtre
        JPanel topPanel = new JPanel(new GridLayout(0, 1));
        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.add(new JLabel("Date de depart : "));
        datePanel.add(departPanel);
        datePanel.add(new JLabel("Date d'arrivee : "));
        datePanel.add(arriveePanel);
        topPanel.add(datePanel);
        topPanel.add(lieuPanel);

        //add(datePanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);
    }

    private void initComboBoxes(boolean isDepart) {
        // Initialisation des listes deroulantes pour les jours, les mois et les annees
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int currentMonth = today.get(Calendar.MONTH);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        String[] days = new String[31 - currentDay + 1];
        for (int i = 0; i < 31 - currentDay + 1; i++) {
            days[i] = Integer.toString(currentDay + i);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);

        String[] months = new DateFormatSymbols().getMonths();
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setSelectedIndex(currentMonth);

        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = Integer.toString(currentYear - 50 + i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setSelectedIndex(50); // Selectionne l'annee actuelle par defaut

        if (isDepart) {
            JourDepart = dayComboBox;
            MoisDepart = monthComboBox;
            AnneeDepart = yearComboBox;
        } else {
            JourArrivee = dayComboBox;
            MoisArrivee = monthComboBox;
            AnneeArrivee = yearComboBox;
        }
    }

    private boolean isDateValid() {
        int departYear = Integer.parseInt((String) AnneeDepart.getSelectedItem());
        int departMonth = MoisDepart.getSelectedIndex();
        int departDay = Integer.parseInt((String) JourDepart.getSelectedItem());

        int arriveeYear = Integer.parseInt((String) AnneeArrivee.getSelectedItem());
        int arriveeMonth = MoisArrivee.getSelectedIndex();
        int arriveeDay = Integer.parseInt((String) JourArrivee.getSelectedItem());

        Calendar departCalendar = Calendar.getInstance();
        departCalendar.set(departYear, departMonth, departDay);

        Calendar arriveeCalendar = Calendar.getInstance();
        arriveeCalendar.set(arriveeYear, arriveeMonth, arriveeDay);

        return !departCalendar.after(arriveeCalendar);
    }
    public void fermerFenetre() {
        dispose();
    }


}
