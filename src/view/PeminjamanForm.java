/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PeminjamanController;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;
import model.PeminjamanData;


/**
 *
 * @author HanRey
 */
public class PeminjamanForm extends javax.swing.JFrame {

    /**
     * Creates new form EmplyeeForm
     */
    //private Service service;
    private PeminjamanController service;
    public PeminjamanForm() {
        initComponents();
        //service = new Service();
        service = new PeminjamanController();
        runTime();
    }
    private void runTime(){
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                showData();
            }
        }, 0, 5000);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        bSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfAnggota = new javax.swing.JTextField();
        tfBuku = new javax.swing.JTextField();
        tfPetugas = new javax.swing.JTextField();
        tfPinjam = new javax.swing.JTextField();
        tfKembali = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(777, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Data Peminjaman");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 10, 200, 40);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 60, 670, 200);

        bSave.setText("Pinjam");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        getContentPane().add(bSave);
        bSave.setBounds(430, 370, 80, 20);

        jLabel2.setText("Id Anggota");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 280, 80, 14);

        jLabel3.setText("Id Buku");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 320, 70, 14);

        jLabel4.setText("Id Petugas");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 360, 60, 14);

        jLabel5.setText("Tanggal Kembali");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(330, 320, 100, 14);
        getContentPane().add(tfAnggota);
        tfAnggota.setBounds(150, 280, 80, 22);
        getContentPane().add(tfBuku);
        tfBuku.setBounds(150, 320, 80, 22);
        getContentPane().add(tfPetugas);
        tfPetugas.setBounds(150, 360, 80, 22);
        getContentPane().add(tfPinjam);
        tfPinjam.setBounds(490, 280, 80, 22);
        getContentPane().add(tfKembali);
        tfKembali.setBounds(490, 320, 80, 22);

        jLabel7.setText("Tanggal Pinjam");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(330, 280, 100, 14);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 310, 110, 110);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // now save to temporary database
        service.save(getData());
        
        clear();
        // now we need  show data to table
        showData();
    }//GEN-LAST:event_bSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Beranda().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
private PeminjamanData getData(){
        String id = tfAnggota.getText();
        String idBuku = tfBuku.getText();
        String idPetugas = tfPetugas.getText();
        String tanggal_pinjam = tfPinjam.getText();
        String tanggal_kembali = tfKembali.getText();
        
        // create Employee class
        PeminjamanData e = new PeminjamanData();
        e.setId(id);
        e.setIdBuku(idBuku);
        e.setIdPetugas(idPetugas);
        e.setTanggal_pinjam(tanggal_pinjam);
        e.setTanggal_kembali(tanggal_kembali);
        return e;
    }

    private void clear(){
        tfAnggota.setText("");
        tfBuku.setText("");
        tfPetugas.setText("");
        tfPinjam.setText("");
        tfKembali.setText("");
    }
    private DefaultTableModel model;
    
    private void showData(){
        Object[] column = {"Id", "Nama", "Buku", "Petugas", "Tgl_pinjam", "Tgl_kembali"};
        Object[][] data = new Object[service.getPeminjaman().size()][6];
        // value 3 means much column on table
        for (int i = 0; i < service.getPeminjaman().size(); i++) {
            PeminjamanData e = service.getPeminjaman().get(i);
            Object[] arr_data = {e.getId(), e.getNama(), e.getBuku(), e.getPetugas(), e.getTanggal_pinjam(), e.getTanggal_kembali()};
            data[i] = arr_data;
        }
        
        model = new DefaultTableModel(data, column);
        tableData.setModel(model);
    }
    

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSave;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField tfAnggota;
    private javax.swing.JTextField tfBuku;
    private javax.swing.JTextField tfKembali;
    private javax.swing.JTextField tfPetugas;
    private javax.swing.JTextField tfPinjam;
    // End of variables declaration//GEN-END:variables
}