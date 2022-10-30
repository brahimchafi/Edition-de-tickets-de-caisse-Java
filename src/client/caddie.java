package client;

import java.util.Comparator.*;
import java.util.ArrayList;
import java.util.Iterator;



public class caddie {
    ArrayList<Integer> ChoixArticles = new ArrayList<Integer>();

    public ArrayList<Integer> getChoix(){
        return this.ChoixArticles;
    }


    public void ajouter(int reference){
        this.ChoixArticles.add(reference);
    }

    public void enlever(int reference){
        Iterator iter = ChoixArticles.iterator();
        while (iter.hasNext()) {
            int ref = (Integer) iter.next();
            if(ref ==reference ){
                iter.remove();
            }
        }
    }

    public void annuler(){
        this.ChoixArticles.clear();
    }

    public void afficher(){
        Iterator iter = ChoixArticles.iterator();
        System.out.println("Références de produits choisis :");
        while (iter.hasNext()) {
            System.out.println("- "+iter.next());
        }
    }

}
