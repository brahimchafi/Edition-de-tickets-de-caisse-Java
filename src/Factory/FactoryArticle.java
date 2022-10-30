package Factory;

import ArticlesDB.*;


public class FactoryArticle {

    public static Article create(int reference  ,String libelle , double prix , int quantite ){
        if(quantite > 1){
            return new Lot(reference ,libelle ,prix, quantite);
        }
        else {
            return new Unite(reference,libelle ,prix);
        }
    }

    public static Article create(){
        return new Unite ();
    }

}
