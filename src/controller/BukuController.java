/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BukuData;

/**
 *
 * @author HanRey
 */
public class BukuController {
    private Connection connection;
    private PreparedStatement statement;
    
    private Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus", "root", "");
        } catch (SQLException e) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    public void save(BukuData e){
        try {
            String getId = e.getId();
            String getBook = e.getJudulBuku();
            String sqlBuku = "INSERT INTO buku (id, judul_buku)\n" +
                "VALUES ("+ getId +",'"+ getBook + "');";
            statement = getConnection().prepareStatement(sqlBuku);
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(BukuData e){
        try {
            String getId = e.getId();
            String getBook = e.getJudulBuku();
            String sqlBuku = "update buku set judul_buku='"+getBook+"' where id="+getId+"";
            statement = getConnection().prepareStatement(sqlBuku);
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(BukuData e){
        try {
            statement = getConnection().prepareStatement("delete from anggota where id=?");
            statement.setString(1, e.getId());
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<BukuData> getBuku(){
        try {
            statement = getConnection().prepareStatement("select * from buku");
            ResultSet rs = statement.executeQuery();
            List<BukuData> anggotaD = new ArrayList<>();
            while (rs.next()) {                
                BukuData e = new BukuData();
                e.setId(rs.getString("id"));
                e.setJudulBuku(rs.getString("judul_buku"));
                anggotaD.add(e);
            }
            return anggotaD;
        } catch (SQLException e) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }
}
