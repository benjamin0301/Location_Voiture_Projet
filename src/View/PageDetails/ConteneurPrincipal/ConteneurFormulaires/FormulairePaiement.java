package View.PageDetails.ConteneurPrincipal.ConteneurFormulaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormulairePaiement extends JPanel
{
    public FormulairePaiement()
    {
        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setBackground(Color.white);
        setPreferredSize(new Dimension(810, 415));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JTextArea titre = new JTextArea("Informations de paiement");
        titre.setEditable(false);
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
        espaceVideB.setPreferredSize(new Dimension(700, 30));
        add(espaceVideB);

        // FORMULAIRE

        JPanel formulairePanel = new JPanel(new GridBagLayout());
        formulairePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 35;
        gbc.ipadx = 160;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge autour de chaque champ de texte
        gbc.weightx = 1.0; // Permet au champ de texte de remplir l'espace horizontalement

        addLabeledField(formulairePanel, gbc, "Nom figurant sur la carte *");
        addLabeledField(formulairePanel, gbc, "Numéro de la carte *");
        addLabeledField(formulairePanel, gbc, "Date d'expiration *");
        addLabeledField(formulairePanel, gbc, "CVC *");

        add(formulairePanel, BorderLayout.CENTER);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String defaultText) {
        JTextField field = new JTextField(defaultText, 20);
        field.setForeground(Color.GRAY); // Couleur grise pour le texte par defaut
        field.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(defaultText)) {
                    field.setText("");
                    field.setForeground(Color.BLACK); // Changer la couleur du texte en noir lorsqu'il est clique
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(defaultText);
                    field.setForeground(Color.GRAY); // Revenir à la couleur grise lorsque le champ perd le focus
                }
            }
        });

        gbc.gridy++; // Incremente le numero de ligne
        panel.add(field, gbc);
    }
}
