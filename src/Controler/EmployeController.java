package Controler;

import Model.EmployeModel;

import java.sql.SQLException;

public class EmployeController {

    private final EmployeModel employe;

    private String Phrase_de_reponse;

    private boolean success;

    public EmployeController() throws SQLException, ClassNotFoundException {
        this.employe = new EmployeModel();
    }

    public EmployeModel ajouterNouvelEmploye(String mdp, String nom, String prenom, String mail, String num_tel) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        if (!validerDonneesEmploye(mail,num_tel)) {
            return null;
        }

        EmployeModel newEmploye = new EmployeModel(mdp, nom, prenom, mail, num_tel);
        int id_employe = employe.generateUniqueEmployeeId();
        newEmploye.setId_employe(id_employe);

        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newEmploye.ajouterEmploye(newEmploye);
        return newEmploye; // Succès
    }

    private boolean validerDonneesEmploye(String mail, String num_tel) throws SQLException, ClassNotFoundException {

        if (!employe.UniciteMail(mail)) {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return false;
        } else if (!employe.UniciteNumeroTel(num_tel)) {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return false;
        } else {
            Phrase_de_reponse = "Toutes les données sont valides";
            return true;
        }
    }

    public boolean supprimerEmploye(EmployeModel employe) throws SQLException, ClassNotFoundException {
        if (employe.supprimerEmploye(employe)) {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return true;
        } else {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return false;
        }
    }

    public Boolean changerPrenom(EmployeModel employe, String newPrenom) throws SQLException, ClassNotFoundException {
        success = employe.majPartielBdd(employe.getId_employe(), "prenom", newPrenom);
        employe.setPrenom(newPrenom);
        Phrase_de_reponse = employe.Phrase_de_reponse;
        return success;
    }

    public Boolean changerNom(EmployeModel employe, String newNom) throws SQLException, ClassNotFoundException {
        success = employe.majPartielBdd(employe.getId_employe(), "nom", newNom);
        employe.setNom(newNom);
        Phrase_de_reponse = employe.Phrase_de_reponse;
        return success;
    }

    public Boolean changerMotDePasse(EmployeModel employe, String newMotDePasse) throws SQLException, ClassNotFoundException {
        success = employe.majPartielBdd(employe.getId_employe(), "mot_de_passe", newMotDePasse);
        employe.setMdp(newMotDePasse);
        Phrase_de_reponse = employe.Phrase_de_reponse;
        return success;
    }

    public Boolean changerMail(EmployeModel employe, String newMail) throws SQLException, ClassNotFoundException {
        if (employe.UniciteMail(newMail)) {
            success = employe.majPartielBdd(employe.getId_employe(), "mail", newMail);
            employe.setMail(newMail);
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return success;
        } else {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return false;
        }
    }


    public Boolean changerNumeroTel(EmployeModel employe, String newNumeroTel) throws SQLException, ClassNotFoundException {
        if (employe.UniciteNumeroTel(newNumeroTel)) {
            success = employe.majPartielBdd(employe.getId_employe(), "num_tel", newNumeroTel);
            employe.setNum_tel(newNumeroTel);
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return success;
        } else {
            Phrase_de_reponse = employe.Phrase_de_reponse;
            return false;
        }
    }

    public int verifierConnexionEmploye(int idEmploye, String password) throws SQLException, ClassNotFoundException {
        int succes = employe.verif_connexion_employe(idEmploye, password);
        Phrase_de_reponse = employe.Phrase_de_reponse;
        return succes;
    }

    public EmployeModel RecupEmployeById(int id_employe) throws SQLException, ClassNotFoundException {
        EmployeModel employe = new EmployeModel();
        employe = employe.RecupEmployeById(id_employe);
        return employe;
    }
}
