/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HanRey
 */
public class PeminjamanData {

    /**
     * @return the idBuku
     */
    public String getIdBuku() {
        return idBuku;
    }

    /**
     * @param idBuku the idBuku to set
     */
    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    /**
     * @return the idPetugas
     */
    public String getIdPetugas() {
        return idPetugas;
    }

    /**
     * @param idPetugas the idPetugas to set
     */
    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the buku
     */
    public String getBuku() {
        return buku;
    }

    /**
     * @param buku the buku to set
     */
    public void setBuku(String buku) {
        this.buku = buku;
    }

    /**
     * @return the petugas
     */
    public String getPetugas() {
        return petugas;
    }

    /**
     * @param petugas the petugas to set
     */
    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    /**
     * @return the tanggal_pinjam
     */
    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    /**
     * @param tanggal_pinjam the tanggal_pinjam to set
     */
    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    /**
     * @return the tanggal_kembali
     */
    public String getTanggal_kembali() {
        return tanggal_kembali;
    }

    /**
     * @param tanggal_kembali the tanggal_kembali to set
     */
    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }
    private String id;
    private String nama;
    private String idBuku;
    private String buku;
    private String idPetugas;
    private String petugas;
    private String tanggal_pinjam;
    private String tanggal_kembali;
    
}
