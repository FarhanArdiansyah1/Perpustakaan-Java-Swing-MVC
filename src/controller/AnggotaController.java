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
import model.AnggotaData;

/**
 *
 * @author HanRey
 */
public class AnggotaController {
    private Connection connection;
    private PreparedStatement statement;
    
    private Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus", "root", "");
        } catch (SQLException e) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    public void save(AnggotaData e){
        try {
            statement = getConnection().prepareStatement("insert into anggota values(?, ?, ?, ?, ?)");
            statement.setString(1, e.getId());
            statement.setString(2, e.getNama());
            statement.setString(3, e.getPekerjaan());
            statement.setString(4, e.getAlamat());
            statement.setString(5, e.getNo_telp());
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(AnggotaData e){
        try {
            statement = getConnection().prepareStatement("update anggota set nama=?, pekerjaan=?, alamat=?, no_telp=? where id=?");
            statement.setString(1, e.getNama());
            statement.setString(2, e.getPekerjaan());
            statement.setString(3, e.getAlamat());
            statement.setString(4, e.getNo_telp());
            statement.setString(5, e.getId());
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(AnggotaData e){
        try {
            statement = getConnection().prepareStatement("delete from anggota where id=?");
            statement.setString(1, e.getId());
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<AnggotaData> getAnggota(){
        try {
            statement = getConnection().prepareStatement("select * from anggota");
            ResultSet rs = statement.executeQuery();
            List<AnggotaData> anggotaD = new ArrayList<>();
            while (rs.next()) {                
                AnggotaData e = new AnggotaData();
                e.setId(rs.getString("id"));
                e.setNama(rs.getString("nama"));
                e.setPekerjaan(rs.getString("pekerjaan"));
                e.setAlamat(rs.getString("alamat"));
                e.setNo_telp(rs.getString("no_telp"));
                anggotaD.add(e);
            }
            return anggotaD;
        } catch (SQLException e) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }
}
