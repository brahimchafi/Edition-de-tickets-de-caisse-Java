import java.sql.*;
import java.util.HashMap;

import ArticlesDB.Article;
import ArticlesDB.*;
import ArticlesDB.BaseArticle;
import Factory.*;
import TicketBuilder.Ticket;
import client.*;
import Caisse.*;

public class Main {

    public static void main(String[] args) {
        caddie cad = new caddie();
        caisse LaCaisse = Caisse.caisse.getInstance();
        BaseArticle ba = BaseArticle.getBaseArticle();
        HashMap<Article,Integer> ArticleChoisis = new HashMap<Article,Integer>();
        Ticket t = new Ticket(1);

        cad.ajouter(5);
        cad.ajouter(5);
        cad.ajouter(2);
        cad.ajouter(1);
        LaCaisse.scanner(ba,cad).imprimer();



    }
 }