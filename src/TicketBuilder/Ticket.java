package TicketBuilder;

import java.util.*;
import ArticlesDB.Article;
import Caisse.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ticket <T extends Article> {

    private double Total;
    private int Numero;

    private int nombreArticle;

    ArrayList<T> ArticleChoisis = new ArrayList<T>();

    public Ticket (int numero){
        this.Numero = numero;
    }

    public double getTotal() {
        return Total;
    }


    public int getNumero() {
        return Numero;
    }

    public void setTotal(double prix){
        this.Total = this.Total + prix;
    }

    public void setNombreArticle(int nombreArticle) {
        this.nombreArticle = nombreArticle;
    }

    public int getNombreArticle() {
        return nombreArticle;
    }

    public void ajouterArticle(T article){
        try {
            ArticleChoisis.add(article);

        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void imprimer(){
        System.out.println("-------------------------");
        System.out.println("Ticket Numero "+getNumero());
        System.out.println("-------------------------");



        Iterator iterator = ArticleChoisis.iterator();
        while (iterator.hasNext()) {

            T a = (T) iterator.next();
            System.out.println(a.toString());
        }
        System.out.println("Total "+getNombreArticle()+" article(s) :"+getTotal());
    }
}
