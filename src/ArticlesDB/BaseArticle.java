package ArticlesDB;

import DataBase.*;
import Factory.FactoryArticle;
import com.mysql.cj.conf.url.FailoverDnsSrvConnectionUrl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BaseArticle <T extends Article> {


    private DB database = DB.getInstance();

    private static BaseArticle baseArticle = new BaseArticle();

     private  BaseArticle(){}

    //GET DATABASE
    public DB getDatabase(){
        return database;
    }

    //SINGLETON
    public static BaseArticle getBaseArticle(){
        return baseArticle;
    }

    //GESTION DE LA BASE DE DONNE
    public void enregistrer ( T article){
        if(database != null) {
            try {
                Statement statement = getDatabase().getConnexionDBMysql().createStatement();

                statement.execute("Insert into article (libelle , prix )values ('" + article.getLibelle() + "','" + article.getPrix() + "')");
                System.out.println("Article Ajouté à la base de donnée !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Erreur : Not connected to a Database");
        }
    }

    public void supprimer (T article) {

        if(getDatabase() != null) {
            try {
                Statement statement = getDatabase().getConnexionDBMysql().createStatement();

                statement.execute("Insert into article (libelle , prix )values ('" + article.getLibelle() + "','" + article.getPrix() + "')");
                System.out.println("Article Ajouté à la base de donnée !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Erreur : Not connected to a Database");
        }
    }

    public void afficher (){
        if(getDatabase() != null) {
            try {
                Statement statement = getDatabase().getConnexionDBMysql().createStatement();
                ResultSet resultset = statement.executeQuery("select * from article ;");
                System.out.println("reference || Libelle || Prix ");
                while(resultset.next()) {
                    System.out.println(resultset.getInt("reference") + " || " + resultset.getString("libelle") + " || " + resultset.getDouble("prix"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Erreur : Not connected to a Database");
        }
    }

    public Article selectionner(int reference){
        if(getDatabase() != null) {

            try {
                Statement statement = getDatabase().getConnexionDBMysql().createStatement();
                ResultSet resultset = statement.executeQuery("select * from article where reference = '"+ reference +"' ;");


                FactoryArticle FA = new FactoryArticle();
                Article a  = FA.create();

                while(resultset.next()) {
                    a.setReference(resultset.getInt("reference"));
                    a.setLibelle(resultset.getString("libelle"));
                    a.setPrix(resultset.getDouble("prix"));
                }


                return a;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            System.out.println("Erreur : Not connected to a Database");
            return null;
        }
    }

}


