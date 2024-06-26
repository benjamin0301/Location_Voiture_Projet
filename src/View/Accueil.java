package View;

import Model.ClientModel;
import View.PageResultats.ConteneurHaut;
import View.popup.PopUpDef2;
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
        int mois = MoisDepart.getSelectedIndex() + 1;
        String moisFormate = (mois < 10) ? "0" + mois : "" + mois;
        return JourDepart.getSelectedItem() + "/" + moisFormate + "/" + AnneeDepart.getSelectedItem();
    }

    public String getDateRetour() {
        int mois = MoisArrivee.getSelectedIndex() + 1;
        String moisFormate = (mois < 10) ? "0" + mois : "" + mois;
        return JourArrivee.getSelectedItem() + "/" + moisFormate + "/" + AnneeArrivee.getSelectedItem();
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
        backgroundPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 155, 120));




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
                    PopUpDef2 pop1 = new PopUpDef2("La date d'arrivee doit être après la date de depart.");
                    pop1.setVisible(true);
                    return;
                }
                String lieu = lieuField.getText().trim(); // Récupérer le lieu et supprimer les espaces en début et fin

                if (lieu.isEmpty()) { // Vérifier si le lieu est vide
                    PopUpDef2 pop2 = new PopUpDef2("Veuillez saisir un lieu de départ.");
                    pop2.setVisible(true);
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

                    } catch (SQLException | ClassNotFoundException ex) {
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

        // Remplir la liste déroulante des mois
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = String.format("%02d", i);
        }
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setSelectedIndex(currentMonth);

        // Remplir la liste déroulante des années
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = Integer.toString(currentYear - 50 + i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setSelectedIndex(50); // Sélectionne l'année actuelle par défaut

        // Remplir la liste déroulante des jours en fonction de la date actuelle et de la valeur sélectionnée pour le mois et l'année
        int maxDay = getMaxDayOfMonth(currentMonth, currentYear);
        String[] days = new String[maxDay];
        for (int i = 1; i <= maxDay; i++) {
            days[i - 1] = String.format("%02d", i);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setSelectedIndex(currentDay - 1); // Sélectionne le jour actuel par défaut

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

    private int getMaxDayOfMonth(int month, int year) {
        switch (month) {
            case 1: // Février
                return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
            case 3: // Avril
            case 5: // Juin
            case 8: // Août
            case 10: // Octobre
                return 30;
            default:
                return 31;
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

        // Vérifier que la date de départ n'est pas antérieure à la date actuelle
        Calendar today = Calendar.getInstance();
        if (departCalendar.before(today)) {
            return false;
        }

        // Vérifier que la date d'arrivée est après la date de départ
        return !departCalendar.after(arriveeCalendar);
    }
}
