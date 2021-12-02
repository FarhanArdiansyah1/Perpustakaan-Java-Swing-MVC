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
import model.PengembalianData;


/**
 *
 * @author HanRey
 */
public class PengembalianController {
    private Connection connection;
    private PreparedStatement statement;
    
    private Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus", "root", "");
        } catch (SQLException e) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
//    public void save(Peminjaman e){
//        try {
//            statement = getConnection().prepareStatement("insert into employee values(?, ?, ?)");
//            statement.setString(1, e.getId());
//            statement.setString(2, e.getName());
//            statement.setString(3, e.getNation());
//            statement.executeUpdate();
//            getConnection().close();
//        } catch (SQLException ex) {
//            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public void delete(PengembalianData e){
//        try {
//            statement = getConnection().prepareStatement("delete from employee where id=?");
//            statement.setString(1, e.getId());
//            statement.executeUpdate();
//            getConnection().close();
//        } catch (SQLException ex) {
//            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void save(PengembalianData e){
        try {
            String pengembalian = e.getTanggalPengembalian();
            String idPeminjaman = e.getIdPeminjaman();
            String idPetugas = e.getIdPetugas();
            String sqlUpdate = "INSERT INTO pengembalian (tanggal_pengembalian, id_peminjaman, id_petugas)\n" +
                "VALUES ('"+ pengembalian + "', "+ idPeminjaman +", "+ idPetugas+ ");";
            statement = getConnection().prepareStatement(sqlUpdate);
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String statusKembali = "Sudah Dikembalikan";
            String idPem = e.getIdPeminjaman();
            String setStatus = "UPDATE peminjaman\n" +
                "SET STATUS = '"+statusKembali+"'\n" +
                "WHERE id = "+ idPem +";";
                statement = getConnection().prepareStatement(setStatus);
                statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<PengembalianData> getPengembalian(){
        try {
            statement = getConnection().prepareStatement(
                "SELECT pengembalian.`id`, \n" +
                "anggota.`nama`, \n" +
                "petugas.`nama_petugas`,\n" +
                "peminjaman.`tanggal_kembali`, \n" +
                "pengembalian.`tanggal_pengembalian`\n" +
                "FROM pengembalian, petugas, peminjaman, anggota\n" +
                "WHERE petugas.id = peminjaman.id_petugas AND "+ 
                "anggota.id = peminjaman.id_anggota AND "+ 
                "peminjaman.`id` = pengembalian.`id_peminjaman`;");
            ResultSet rs = statement.executeQuery();
            List<PengembalianData> pengembali = new ArrayList<>();
            while (rs.next()) {                
                PengembalianData e = new PengembalianData();
                e.setId(rs.getString("id"));
                e.setNama(rs.getString("nama"));
                e.setPetugas(rs.getString("nama_petugas"));
                e.setTanggalKembali(rs.getString("tanggal_kembali"));
                e.setTanggalPengembalian(rs.getString("tanggal_pengembalian"));
                pengembali.add(e);
            }
            return pengembali;
        } catch (SQLException e) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }


}
