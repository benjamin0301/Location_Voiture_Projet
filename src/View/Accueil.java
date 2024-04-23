package View;

import Model.ClientModel;
import View.PageResultats.ConteneurHaut;
import View.popup.popUpReservation;

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
    private ClientModel client;

    public String getLieu() {
        return lieuField.getText();
    }

    public String getDateDepart() {
        return JourDepart.getSelectedItem() + "/" + (MoisDepart.getSelectedIndex() + 1) + "/" + AnneeDepart.getSelectedItem();
    }

    public String getDateRetour() {
        return JourArrivee.getSelectedItem() + "/" + (MoisArrivee.getSelectedIndex() + 1) + "/" + AnneeArrivee.getSelectedItem();
    }

    //public Accueil(ClientModel client) {
     //   this.client = client;
  //  }

    public Accueil(int res, ClientModel clientModel)
    {
        this.client = clientModel;
        setTitle("Accueil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ConteneurHaut conteneurHaut = new ConteneurHaut(res, client);
        //add(conteneurHaut, BorderLayout.NORTH);

        ImageIcon originalImageIcon = new ImageIcon("images/firefly-1.jpg");
        Image originalImage = originalImageIcon.getImage();

        int targetWidth = 2560; // Largeur cible
        int targetHeight = 2025; // Hauteur cible
        Image resizedImage = ImageUtils.resizeImage(originalImage, targetWidth, targetHeight);

        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(resizedImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setPreferredSize(new Dimension(targetWidth, targetHeight));
        backgroundPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 155, 80));




        initComboBoxes(true);
        JPanel departPanel = new JPanel();
        departPanel.setBackground(Color.white);
        JourDepart.setBackground(Color.white);
        JourDepart.setFont(new Font("Georgia", Font.PLAIN, 16));
        departPanel.add(JourDepart);
        MoisDepart.setBackground(Color.white);
        MoisDepart.setFont(new Font("Georgia", Font.PLAIN, 16));
        departPanel.add(MoisDepart);
        AnneeDepart.setBackground(Color.white);
        AnneeDepart.setFont(new Font("Georgia", Font.PLAIN, 16));
        departPanel.add(AnneeDepart);

        initComboBoxes(false);
        JPanel arriveePanel = new JPanel();
        arriveePanel.setBackground(Color.white);
        JourArrivee.setBackground(Color.white);
        JourArrivee.setFont(new Font("Georgia", Font.PLAIN, 16));
        arriveePanel.add(JourArrivee);
        MoisArrivee.setBackground(Color.white);
        MoisArrivee.setFont(new Font("Georgia", Font.PLAIN, 16));
        arriveePanel.add(MoisArrivee);
        AnneeArrivee.setBackground(Color.white);
        AnneeArrivee.setFont(new Font("Georgia", Font.PLAIN, 16));
        arriveePanel.add(AnneeArrivee);

        lieuField = new JTextField(20);
        lieuField.setPreferredSize(new Dimension(200, 30));
        JPanel lieuPanel = new JPanel();
        lieuPanel.setBackground(Color.white);
        lieuPanel.setPreferredSize(new Dimension(350, 120));
        JLabel lieu = new JLabel("Lieu de prise en charge : ");
        lieu.setFont(new Font("Georgia", Font.PLAIN, 18));
        lieu.setPreferredSize(new Dimension(200, 40));
        lieuPanel.add(lieu);
        lieuPanel.add(lieuField);




        JButton confirmButton = new JButton("Confirmer");
        confirmButton.setFont(new Font("Georgia", Font.BOLD, 25));
        confirmButton.setPreferredSize(new Dimension(250, 40));
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#7E3DFF"));


        JPanel panelBouton = new JPanel();
        panelBouton.setBackground(Color.white);
        panelBouton.setPreferredSize(new Dimension(350, 50));
        panelBouton.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isDateValid()) {
                    JOptionPane.showMessageDialog(Accueil.this, "La date d'arrivee doit être après la date de depart.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String lieu = lieuField.getText().trim(); // Récupérer le lieu et supprimer les espaces en début et fin

                if (lieu.isEmpty()) { // Vérifier si le lieu est vide
                    JOptionPane.showMessageDialog(Accueil.this, "Veuillez saisir un lieu de départ.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String departDate = JourDepart.getSelectedItem() + "/" +
                        (MoisDepart.getSelectedIndex() + 1) + "/" +
                        AnneeDepart.getSelectedItem();
                String arriveeDate = JourArrivee.getSelectedItem() + "/" +
                        (MoisArrivee.getSelectedIndex() + 1) + "/" +
                        AnneeArrivee.getSelectedItem();
                //String lieu = lieuField.getText();

                popUpReservation customDialog = new popUpReservation(Accueil.this, departDate, arriveeDate, lieu);
                customDialog.setVisible(true);

                System.out.println("Connexion établie avec succès !");

                // Initialiser le reste de l'application
                SwingUtilities.invokeLater(() -> {
                    try
                    {

                        Vue vue = new Vue(client);
                        vue.initialize(getLieu(), getDateDepart(), getLieu(), getDateRetour(),res);
                        Window window = SwingUtilities.getWindowAncestor(confirmButton);

                        if (window instanceof JFrame) {
                            JFrame frame = (JFrame) window;
                            frame.dispose();
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                });

            }
        });

        // Ajout des composants à la fenêtre
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(Color.white);
        topPanel.setPreferredSize(new Dimension(400, 500));
        topPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;

        JPanel eb1 = new JPanel();
        eb1.setBackground(Color.white);
        eb1.setPreferredSize(new Dimension(398, 20));
        topPanel.add(eb1, gbc);

        gbc.gridy++;
        JTextArea titre = new JTextArea("     Bienvenue sur RentMyRide !");
        titre.setEditable(false);
        titre.setForeground(Color.decode("#7E3DFF"));
        titre.setPreferredSize(new Dimension(398, 28));
        titre.setBackground(Color.white);
        titre.setFont(new Font("Georgia", Font.BOLD, 23));
        topPanel.add(titre, gbc);

        gbc.gridy++;
        JPanel eb2 = new JPanel();
        eb2.setBackground(Color.white);
        eb2.setPreferredSize(new Dimension(398, 20));
        topPanel.add(eb2, gbc);

        gbc.gridy++;
        JSeparator sep1 = new JSeparator(SwingConstants.HORIZONTAL);
        sep1.setPreferredSize(new Dimension(370, 20));
        sep1.setForeground(Color.BLACK);
        topPanel.add(sep1, gbc);

        gbc.gridy++;
        JTextArea accroche = new JTextArea("    Vous cherchez un véhicule ?\n    Vous êtes au bon endroit.");
        accroche.setPreferredSize(new Dimension(398, 75));
        accroche.setEditable(false);
        accroche.setBackground(Color.white);
        accroche.setFont(new Font("Georgia", Font.BOLD, 16));
        topPanel.add(accroche, gbc);



        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.setBackground(Color.white);
        datePanel.setPreferredSize(new Dimension(350, 100));

        JLabel ddepart = new JLabel("Date de départ : ");
        ddepart.setFont(new Font("Georgia", Font.PLAIN, 18));
        datePanel.add(ddepart);
        datePanel.add(departPanel);

        JLabel darrivee = new JLabel("Date d'arrivée : ");
        darrivee.setFont(new Font("Georgia", Font.PLAIN, 18));
        datePanel.add(darrivee);
        datePanel.add(arriveePanel);

        gbc.gridy++;
        topPanel.add(datePanel, gbc);

        gbc.gridy++;
        topPanel.add(lieuPanel, gbc);

        gbc.gridy++;
        topPanel.add(panelBouton, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        topPanel.add(espaceBlanc, gbc);

        backgroundPanel.add(topPanel);

        add(backgroundPanel, BorderLayout.CENTER);
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
}
