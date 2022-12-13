package champollion;

import java.util.Date;
import java.util.HashMap;

public class Intervention {

    private Date debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;

    private UE matiere;
    private Salle lieu;
    private TypeIntervention type;
    private Enseignant intervenant;

    public Intervention(Date debut, int duree, int heureDebut, UE matiere, Salle lieu, TypeIntervention type, Enseignant intervenant) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.matiere = matiere;
        this.lieu = lieu;
        this.type = type;
        this.intervenant = intervenant;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public UE getMatiere() {
        return matiere;
    }

    public Salle getLieu() {
        return lieu;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setMatiere(UE matiere) {
        this.matiere = matiere;
    }

    public void setLieu(Salle lieu) {
        this.lieu = lieu;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public void setIntervenant(Enseignant intervenant) {
        this.intervenant = intervenant;
    }


}
