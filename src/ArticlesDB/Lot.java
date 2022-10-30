package ArticlesDB;

public class Lot extends Article{

    private int quantite;
    private double prixTotal;

    public Lot(int reference , String libelle, double prix, int quantite){
        super( reference ,  libelle,  prix);
        this.quantite = quantite;
        this.prixTotal = quantite * prix;
    }

    public double getPrixTotal(){
        return Math.round(this.prixTotal*100.0)/100.0;
    }
    public int getQuantite(){
        return this.quantite;
    }

    public String toString (){
        return getLibelle()+"\n   "+getQuantite()+" x "+getPrix()+"    "+getPrixTotal();
    }
}
