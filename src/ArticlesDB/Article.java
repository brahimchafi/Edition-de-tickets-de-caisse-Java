package ArticlesDB;

public abstract class Article {


    private int reference;
    private double prix;
    private String libelle;

    //Constructeur
    public Article (){}
    public Article (int refenrence ,String libelle , double prix){
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
    }

    //GETTERS
    public double getPrix() {
        return Math.round(prix*100.0)/100.0;
    }

    public String getLibelle() {
        return libelle;
    }
    //SETTERS
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    abstract public String toString();

}
