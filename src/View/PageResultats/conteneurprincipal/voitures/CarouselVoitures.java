package View.PageResultats.conteneurprincipal.voitures;

import Controler.ClientController;
import Model.ClientModel;
import Model.VoitureModel;
import View.Vue;
import View.popup.PopUpDef2;
import View.popup.popUpDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarouselVoitures extends JPanel {

    private List<String> elements;
    private int currentIndex;
    private JButton previousButton;
    private JButton nextButton;
    public String TypeClicked;
    private ArrayList<VoitureModel> listePersonnellealaClasse;

    private int res;
    private ClientModel client;

    public CarouselVoitures(ClientModel clientModel,ArrayList<VoitureModel> newliste, int res) throws SQLException, ClassNotFoundException
    {
        this.res = res;
        this.client = clientModel;
        this.listePersonnellealaClasse = newliste;
        elements = new ArrayList<>();
        setLayout(new BorderLayout());

        ArrayList<String> listeTypes = new ArrayList<>(Arrays.asList("Mini", "SUV", "Sportive", "Supersportive", "Berline", "Minivan", "Spécial"));

        for (int i = 0; i < listeTypes.size(); i++)
        {
            addElement(listeTypes.get(i));
        }

        previousButton = createArrowButton('<');
        nextButton = createArrowButton('>');

        previousButton.addActionListener(e -> showPreviousElements());
        nextButton.addActionListener(e -> showNextElements());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.white);

        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(createCarouselPanel(), BorderLayout.CENTER);

        showElements(0, 4);
    }

    public CarouselVoitures(ArrayList<VoitureModel> newliste, int res) throws SQLException, ClassNotFoundException
    {
        this.res = res;
        this.listePersonnellealaClasse = newliste;
        elements = new ArrayList<>();
        setLayout(new BorderLayout());

        ArrayList<String> listeTypes = new ArrayList<>(Arrays.asList("Mini", "SUV", "Sportive", "Supersportive", "Berline", "Minivan", "Spécial"));

        for (int i = 0; i < listeTypes.size(); i++)
        {
            addElement(listeTypes.get(i));
        }

        previousButton = createArrowButton('<');
        nextButton = createArrowButton('>');

        previousButton.addActionListener(e -> showPreviousElements());
        nextButton.addActionListener(e -> showNextElements());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.white);

        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(createCarouselPanel(), BorderLayout.CENTER);

        showElements(0, 4);
    }

    private JPanel createCarouselPanel() throws SQLException, ClassNotFoundException
    {
        JPanel carouselPanel = new JPanel();
        carouselPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        carouselPanel.setBackground(Color.white);
        ArrayList<String> imagesTypes = new ArrayList<>(Arrays.asList("images/mini.png", "images/SUV.png", "images/sportive.png", "images/supersportive.png", "images/berline.png", "images/minivan.png", "images/special.png"));


        for (int i = 0; i < elements.size(); i++)
        {
            String element = elements.get(i);
            String imageCase = imagesTypes.get(i);
            JButton caseCarrousel = new JButton();
            caseCarrousel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            caseCarrousel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
            caseCarrousel.setAlignmentX(SwingConstants.CENTER);
            caseCarrousel.setAlignmentY(SwingConstants.CENTER);
            caseCarrousel.setPreferredSize(new Dimension(160, 180));
            caseCarrousel.setBackground(Color.WHITE);
            caseCarrousel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

            caseCarrousel.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    PopUpDef2 pop = new PopUpDef2("Type sélectionné : " + element);
                    pop.setVisible(true);


                    JButton clickedButton = (JButton) e.getSource();
                    int index = carouselPanel.getComponentZOrder(clickedButton);

                    TypeClicked = elements.get(index);

                    /*client.Phrase_de_reponse = "bite";
                    String phrase = client.Phrase_de_reponse;
                    JOptionPane.showMessageDialog(null, phrase);*/

                    switch (TypeClicked)
                    {
                        case "Mini":
                            try
                            {
                                VoitureModel voiture = new VoitureModel();
                                listePersonnellealaClasse = voiture.recupListeVoitureFiltrage("type","=", "Mini", null,null,null,null,null,null,null, null,null,null,null,null);
                                System.out.println("si ca rentre dans mini" + listePersonnellealaClasse.getFirst().getType());
                                new ConteneurVoitures(client, res, listePersonnellealaClasse);
                            }
                            catch (ClassNotFoundException | SQLException ex) { throw new RuntimeException(ex); }
                            break;

                        case "SUV":
                            break;

                        case "Sportive":
                            break;

                        case "Supersportive":
                            break;

                        case "Berline":
                            break;

                        case "Minivan":
                            break;

                        case "Spécial":
                            break;

                        case "TypeXYZ":
                            break;
                    }

                }
            });


            JTextArea typeVoiture = new JTextArea(element);
            typeVoiture.setEditable(false);
            typeVoiture.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            typeVoiture.setFont(new Font("Georgia", Font.BOLD, 18));
            typeVoiture.setMargin(new Insets(20, 0, 0, 0));
            caseCarrousel.add(typeVoiture);

            ImageIcon AImage = new ImageIcon(imageCase);
            JLabel imageLabel = new JLabel(AImage);
            caseCarrousel.add(imageLabel);

            carouselPanel.add(caseCarrousel);
        }

        return carouselPanel;
    }

    public String returnTypeClicked(){
        return TypeClicked;
    }

    private JButton createArrowButton(char direction) {
        JButton button = new JButton(Character.toString(direction));
        button.setPreferredSize(new Dimension(140, 25));
        button.setBackground(Color.white);
        button.setForeground(Color.darkGray);
        button.setFocusPainted(false);
        button.setFont(new Font("Aleo", Font.BOLD, 20));
        return button;
    }

    public void addElement(String element) {
        elements.add(element);
    }

    public void showElements(int startIndex, int endIndex) {
        Component[] components = ((JPanel) ((BorderLayout) getLayout()).getLayoutComponent(BorderLayout.CENTER)).getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setVisible(i >= startIndex && i <= endIndex);
        }
    }

    public void showNextElements() {
        int nextIndex = currentIndex + 5;
        if (nextIndex < elements.size()) {
            showElements(nextIndex, nextIndex + 4);
            currentIndex = nextIndex;
        }
    }

    public void showPreviousElements() {
        int previousIndex = currentIndex - 5;
        if (previousIndex >= 0) {
            showElements(previousIndex, previousIndex + 4);
            currentIndex = previousIndex;
        }
    }
}