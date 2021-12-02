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
public class PengembalianData {

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
     * @return the tanggalKembali
     */
    public String getTanggalKembali() {
        return tanggalKembali;
    }

    /**
     * @param tanggalKembali the tanggalKembali to set
     */
    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    /**
     * @return the tanggalPengembalian
     */
    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    /**
     * @param tanggalPengembalian the tanggalPengembalian to set
     */
    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
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
     * @return the idPeminjaman
     */
    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    /**
     * @param idPeminjaman the idPeminjaman to set
     */
    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }
    private String id;
    private String nama;
    private String buku;
    private String petugas;
    private String tanggalKembali;
    private String tanggalPengembalian;
    private String idPetugas;
    private String idPeminjaman;
}
