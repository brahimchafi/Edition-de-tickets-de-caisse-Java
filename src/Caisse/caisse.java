package Caisse;


import ArticlesDB.Article;
import ArticlesDB.BaseArticle;
import Factory.FactoryArticle;
import client.*;
import TicketBuilder.*;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class caisse {
    //ATTRIBUTS
    private double total;

    private int nombre_ticket;

    private static caisse LaCaisse = new caisse();

    //CONSTRUCTOR
    private caisse(){
        this.total = 0;
        this.nombre_ticket = 0;
    }

    //SETTERS & GETTERS
    public void setNombreTicket(int nbrTicket){
        this.nombre_ticket = nbrTicket;
    }

    public int getNombreTicket(){
        return this.nombre_ticket;
    }
    public void setTotal(){}

    public double getTotal(){
        return this.total;
    }
    //Instance Caisse (Singleton)
    public static caisse getInstance(){
        return LaCaisse;
    }
    //Incrementer Nombre de ticket
    public void incrNbrTicket() {
        setNombreTicket(getNombreTicket()+1);
    }

    //Scanner l'article


//    public Ticket scanner (BaseArticle BA, caddie Caddie) {
//        Ticket ticket = new Ticket(getNombreTicket()+1);
//
//        Iterator iter = Caddie.getChoix().iterator();
//
//        while (iter.hasNext()) {
//            Article a = BA.selectionner((Integer) iter.next());
//            int reference = a.getReference();
//            String libelle = a.getLibelle();
//            double prix = a.getPrix();
////            System.out.println(Collections.frequency(Caddie.getChoix(),reference));
//            try {
//                ticket.ajouterArticle(FactoryArticle.create(reference, libelle, prix, Collections.frequency(Caddie.getChoix(), reference)));
//
//                ticket.setTotal(prix);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//        return ticket;
//    }
    public Ticket scanner (BaseArticle BA, caddie Caddie) {
        Ticket ticket = new Ticket(getNombreTicket()+1);

        while(!Caddie.getChoix().isEmpty()) {
            Article a = BA.selectionner(Caddie.getChoix().get(0));
            int reference = a.getReference();
            String libelle = a.getLibelle();
            double prix = a.getPrix();
            int quantite = Collections.frequency(Caddie.getChoix(), reference);
            ticket.ajouterArticle(FactoryArticle.create(reference, libelle, prix, quantite));
            ticket.setTotal(prix*quantite);

            Caddie.enlever(reference);
            System.out.println("DoNE!");

        }
        incrNbrTicket();
        return ticket;
    }

}
