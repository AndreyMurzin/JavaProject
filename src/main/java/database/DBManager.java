package database;

import constants.Constants;
import entity.Discipline;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `discipline` where `status` = '1'");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static Discipline getDisciplineById(String id) {
        Discipline discipline = new Discipline();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where id = '"+id+"';");

            while (rs.next()) {
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discipline;
    }

    public static void createNewDiscipline(String disc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('"+disc+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modifyDiscipline(String id, String disc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '"+disc+"' WHERE (`id` = '"+id+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteDiscipline(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = 'qwer', `status` = '0' WHERE (`id` = '"+id+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Term> getAllActiveTerms() {
        ArrayList<Term> terms = new ArrayList<Term>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term` where `status` = '1'");

            int count = 1;
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName("Семестр " + count);
                count++;
                term.setDuration(rs.getString("duration"));
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static Term getTermById(String id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term` where `status` = '1' and `id` = '"+id+"'");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setDuration(rs.getString("duration"));
                return term;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Discipline> getAllActiveDisciplinesByTerm(int idTerm) {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM students_19.term_discipline as td\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where td.id_term = '"+idTerm+"'\n" +
                    "and d.status = '1'");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static boolean isVerifiedUser(String login, String password, String role) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_role as us\n" +
                    "left join user as u on us.id_user = u.id\n" +
                    "where u.login = '"+login+"' and u.password = '"+password+"' and us.id_role = " + role);

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
