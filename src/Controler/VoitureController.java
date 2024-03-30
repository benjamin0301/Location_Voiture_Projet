package Controler;

import Model.VoitureModel;
import java.sql.SQLException;

public class VoitureController {

    private VoitureModel model; // référence vers le modèle

    public VoitureController(VoitureModel model) {
        this.model = model;
    }

    public boolean ajouterNouvelleVoiture(String idPlaque, String modele) {
        // Valider les données saisies par l'utilisateur
        if (!validerDonnees(idPlaque, modele)) {
            // Afficher un message d'erreur à l'utilisateur si les données ne sont pas valides
            // Vous pouvez utiliser des mécanismes propres à votre vue pour afficher les messages d'erreur
            return false;
        }

        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        model.ajouterVoiture(idPlaque, modele, "Bleu", "ad", "bleu", 2, 5, 5, 5, 0, 5, 2005, 54567, 5000, false, "Paris", "2022-05-05", "2022-05-10", 500, 1);
        return true; // Succès
    }

    private boolean validerDonnees(String idPlaque, String modele) {
        // Validez les données selon vos critères de validation
        // Par exemple, vérifiez si les champs sont vides ou si le format est correct
        if (idPlaque.isEmpty() || modele.isEmpty()) {
            // Si l'un des champs est vide, les données ne sont pas valides
            return false;
        }
        // Autres conditions de validation si nécessaire...

        // Si toutes les validations réussissent, retournez true
        return true;
    }
}
