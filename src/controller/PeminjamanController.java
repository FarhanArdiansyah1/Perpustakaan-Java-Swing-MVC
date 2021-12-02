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
import model.PeminjamanData;


/**
 *
 * @author HanRey
 */
public class PeminjamanController {
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

//    public void delete(PeminjamanData e){
//        try {
//            statement = getConnection().prepareStatement("delete from employee where id=?");
//            statement.setString(1, e.getId());
//            statement.executeUpdate();
//            getConnection().close();
//        } catch (SQLException ex) {
//            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void save(PeminjamanData e){
        try {
            String pinjam = e.getTanggal_pinjam();
            String kembali = e.getTanggal_kembali();
            String idBuku = e.getIdBuku();
            String idAnggota = e.getId();
            String idPetugas = e.getIdPetugas();
            String sqlUpdate = "INSERT INTO peminjaman "+ 
                "(tanggal_pinjam, tanggal_kembali, id_buku, id_anggota, id_petugas)\n" +
                "VALUES ('"+ pinjam + "', '"+ kembali +"', "+ idBuku+ ", "+idAnggota+", "+idPetugas+");";
            statement = getConnection().prepareStatement(sqlUpdate);
            statement.executeUpdate();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<PeminjamanData> getPeminjaman(){
        try {
            statement = getConnection().prepareStatement(
                "SELECT peminjaman.`id`, "+ 
                "anggota.`nama`, "+ 
                "buku.`judul_buku` AS 'buku', "+ 
                "petugas.`nama_petugas` AS petugas, "+ 
                "peminjaman.`tanggal_pinjam`, "+ 
                "peminjaman.`tanggal_kembali`\n" +
                "FROM peminjaman, anggota, buku, petugas\n" +
                "WHERE anggota.id = peminjaman.id_anggota AND\n" +
                "buku.id = peminjaman.id_buku AND\n" +
                "petugas.id = peminjaman.id_petugas AND status IS NULL;");
            ResultSet rs = statement.executeQuery();
            List<PeminjamanData> peminjam = new ArrayList<>();
            while (rs.next()) {                
                PeminjamanData e = new PeminjamanData();
                e.setId(rs.getString("id"));
                e.setNama(rs.getString("nama"));
                e.setBuku(rs.getString("buku"));
                e.setPetugas(rs.getString("petugas"));
                e.setTanggal_pinjam(rs.getString("tanggal_pinjam"));
                e.setTanggal_kembali(rs.getString("tanggal_kembali"));
                peminjam.add(e);
            }
            return peminjam;
        } catch (SQLException e) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }


}
