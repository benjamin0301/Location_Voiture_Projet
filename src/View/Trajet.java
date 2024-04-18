package View;

public class Trajet {
    private String lieuDepart;
    private String dateDepart;
    private String heureDepart;
    private String lieuRetour;
    private String dateRetour;
    private String heureRetour;

    public Trajet(String lieuDepart, String dateDepart, String heureDepart, String lieuRetour, String dateRetour, String heureRetour) {
        this.lieuDepart = lieuDepart;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.lieuRetour = lieuRetour;
        this.dateRetour = dateRetour;
        this.heureRetour = heureRetour;
    }

    // Créez des méthodes get pour récupérer les données
    public String getLieuDepart() {
        return lieuDepart;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getLieuRetour() {
        return lieuRetour;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public String getHeureRetour() {
        return heureRetour;
    }
}
