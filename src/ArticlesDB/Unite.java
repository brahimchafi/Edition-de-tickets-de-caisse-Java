package ArticlesDB;

public class Unite extends Article{

    public Unite(int reference , String libelle, double prix){
        super (reference, libelle, prix);
    }
    public Unite (){}

    public String toString(){
        return getLibelle()+"    "+getPrix();
    }
}
