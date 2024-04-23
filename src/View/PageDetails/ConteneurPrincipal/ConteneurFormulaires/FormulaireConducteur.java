package View.PageDetails.ConteneurPrincipal.ConteneurFormulaires;

import Model.ClientModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormulaireConducteur extends JPanel
{
    private ClientModel client;
    public FormulaireConducteur(ClientModel clientModel)
    {
        this.client = clientModel;
        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setBackground(Color.white);
        setPreferredSize(new Dimension(810, 785));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JTextArea titre = new JTextArea("Informations concernant le conducteur");
        titre.setPreferredSize(new Dimension(770, 30));
        titre.setFont(new Font("Georgia", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(770, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.white);
        espaceVideB.setPreferredSize(new Dimension(700, 20));
        add(espaceVideB);

        /// FORMULAIRE

        JPanel formulairePanel = new JPanel(new GridBagLayout());
        formulairePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 35;
        gbc.ipadx = 160;
        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.weightx = 1.0;

        addLabeledField(formulairePanel, gbc, "Prénom *");

        gbc.gridy++; // Incremente le numero de ligne
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel infoLabel = new JLabel("<html>Le nom doit correspondre au nom qui figure sur le permis de conduire<br>et sur la carte de crédit utilisée lors du retrait de la voiture.</html>");
        infoLabel.setForeground(Color.GRAY);
        formulairePanel.add(infoLabel, gbc);

        gbc.insets = new Insets(0, 10, 10, 10);

        addLabeledField(formulairePanel, gbc, "Nom *");

        gbc.insets = new Insets(10, 10, 10, 10);

        addLabeledField(formulairePanel, gbc, "E-mail *");
        addLabeledField(formulairePanel, gbc, "Téléphone *");
        addLabeledField(formulairePanel, gbc, "Pays/Région *");
        addLabeledField(formulairePanel, gbc, "Ville *");
        addLabeledField(formulairePanel, gbc, "Adresse *");
        gbc.insets = new Insets(10, 10, 0, 10);
        addLabeledField(formulairePanel, gbc, "Numéro de vol (en option)");

        gbc.insets = new Insets(0, 10, 0, 10);

        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel infoNVol = new JLabel("<html>Il est important de préciser votre numéro de vol en cas de retard ou d’annulation de celui-ci.<br>Cela aidera l’agence de location de voitures à connaître votre heure d’arrivée.</html>");
        infoNVol.setForeground(Color.GRAY);
        formulairePanel.add(infoNVol, gbc);

        /*
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel infoAge = new JLabel("<html>Âge du conducteur principal</html>");
        infoAge.setForeground(Color.GRAY);
        formulairePanel.add(infoAge, gbc);

        //boutons

        JButton button1 = new JButton("18-29");
        JButton button2 = new JButton("30-69");
        JButton button3 = new JButton("70+");

        JPanel buttonsContainer = new JPanel(new FlowLayout());
        buttonsContainer.add(button1);
        buttonsContainer.add(button2);
        buttonsContainer.add(button3);

        gbc.gridy++;
        gbc.ipady = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        formulairePanel.add(buttonsContainer, gbc);*/

        add(formulairePanel, BorderLayout.CENTER);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String defaultText) {
        JTextField field = new JTextField(defaultText, 20);
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(defaultText)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(defaultText);
                    field.setForeground(Color.GRAY);
                }
            }
        });

        gbc.gridy++;
        panel.add(field, gbc);
    }

}
