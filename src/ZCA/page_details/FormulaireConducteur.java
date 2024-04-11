package ZCA.page_details;

import ZCA.page_principale.conteneurprincipal.voitures.PanelVoiture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormulaireConducteur extends JPanel
{
    public FormulaireConducteur()
    {
        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setBackground(Color.white);
        setPreferredSize(new Dimension(810, 1050));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JTextArea titre = new JTextArea("Informations concernant le conducteur");
        titre.setPreferredSize(new Dimension(770, 30));
        titre.setFont(new Font("Aleo", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(770, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.white);
        espaceVideB.setPreferredSize(new Dimension(700, 30));
        add(espaceVideB);

        /// FORMULAIRE

        JPanel formulairePanel = new JPanel(new GridBagLayout());
        formulairePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 35;
        gbc.ipadx = 160;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge autour de chaque champ de texte
        gbc.weightx = 1.0; // Permet au champ de texte de remplir l'espace horizontalement

        addLabeledField(formulairePanel, gbc, "Prénom *");

// Ajout du texte supplémentaire entre les champs "Prénom" et "Nom"
        gbc.gridy++; // Incrémente le numéro de ligne
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Fait en sorte que le composant occupe toute la largeur restante
        JLabel infoLabel = new JLabel("<html>Le nom doit correspondre au nom qui figure sur le permis de conduire<br>et sur la carte de crédit utilisée lors du retrait de la voiture.</html>");
        infoLabel.setForeground(Color.GRAY); // Couleur grise pour le texte
        formulairePanel.add(infoLabel, gbc);

        addLabeledField(formulairePanel, gbc, "Nom *");
        addLabeledField(formulairePanel, gbc, "E-mail *");
        addLabeledField(formulairePanel, gbc, "Téléphone *");
        addLabeledField(formulairePanel, gbc, "Pays/Région *");
        addLabeledField(formulairePanel, gbc, "Ville *");
        addLabeledField(formulairePanel, gbc, "Adresse *");
        addLabeledField(formulairePanel, gbc, "Numéro de vol (en option)");

        gbc.gridy++; // Incrémente le numéro de ligne
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Fait en sorte que le composant occupe toute la largeur restante
        JLabel infoNVol = new JLabel("<html>Il est important de préciser votre numéro de vol en cas<br>de retard ou d’annulation de celui-ci. Cela aidera<br>l’agence de location de voitures à connaître votre<br>heure d’arrivée.</html>");
        infoNVol.setForeground(Color.GRAY); // Couleur grise pour le texte
        formulairePanel.add(infoNVol, gbc);

        gbc.gridy++; // Incrémente le numéro de ligne
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Fait en sorte que le composant occupe toute la largeur restante
        JLabel infoAge = new JLabel("<html>Âge du conducteur principal</html>");
        infoAge.setForeground(Color.GRAY); // Couleur grise pour le texte
        formulairePanel.add(infoAge, gbc);

        //boutons

        JButton button1 = new JButton("18-29");
        JButton button2 = new JButton("30-69");
        JButton button3 = new JButton("70+");

        JPanel buttonsContainer = new JPanel(new FlowLayout());
        buttonsContainer.add(button1);
        buttonsContainer.add(button2);
        buttonsContainer.add(button3);

        gbc.gridy++; // Incrémente le numéro de ligne
        gbc.ipady = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Fait en sorte que le conteneur occupe toute la largeur restante
        formulairePanel.add(buttonsContainer, gbc);

        add(formulairePanel, BorderLayout.CENTER);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String defaultText) {
        JTextField field = new JTextField(defaultText, 20);
        field.setForeground(Color.GRAY); // Couleur grise pour le texte par défaut
        field.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(defaultText)) {
                    field.setText("");
                    field.setForeground(Color.BLACK); // Changer la couleur du texte en noir lorsqu'il est cliqué
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(defaultText);
                    field.setForeground(Color.GRAY); // Revenir à la couleur grise lorsque le champ perd le focus
                }
            }
        });

        gbc.gridy++; // Incrémente le numéro de ligne
        panel.add(field, gbc);
    }

}
