/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm078;

import com.app.uts.ENTITYPurchaseOrder.npm078.PurchaseOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kemal
 */
public class PurchaseOrderDataSource {
     private Connection connection;
    
    //berisi fungsi atau method bisa melakukan operasi database
    public PurchaseOrderDataSource(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<PurchaseOrder> getALL(){
        List<PurchaseOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM procurement";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            PurchaseOrder po;
            while (rs.next()) {                
                po = new PurchaseOrder();
                po.setIdPO(rs.getString("IdPO"));
                po.setDeskripsi(rs.getString("Deskripsi"));
                po.setSupplier(rs.getString("Supplier"));
                po.setTotalPO(rs.getString("TotalPO"));
                po.setTanggalPO(rs.getString("TanggalPO"));
                list.add(po);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public PurchaseOrder getByID(String IdPO){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM procurement WHERE IdPO = ?";
        PurchaseOrder po = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, IdPO);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
                po = new PurchaseOrder();
                po.setIdPO(rs.getString("IdPO"));
                po.setDeskripsi(rs.getString("Deskripsi"));
                po.setSupplier(rs.getString("Supplier"));
                po.setTotalPO(rs.getString("TotalPO"));
                po.setTanggalPO(rs.getString("TanggalPO"));
            }
        } catch (Exception e) {
        }
        return po;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(PurchaseOrder po){
        boolean status = false;
        String sql = "INSERT INTO  VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, po.getIdPO());
            statement.setString(2, po.getDeskripsi());
            statement.setString(3, po.getSupplier());
            statement.setString(4, po.getTotalPO());
            statement.setString(5, po.getTanggalPO());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(PurchaseOrder po){
        boolean status = false;
        String sql = "UPDATE procurement SET Deskripsi=?, Supplier=?, TotalPO=?, TanggalPO=? " +
                "WHERE IdPO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, po.getIdPO());
            statement.setString(2, po.getDeskripsi());
            statement.setString(3, po.getSupplier());
            statement.setString(4, po.getTotalPO());
            statement.setString(5, po.getTanggalPO());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(PurchaseOrder po){
        boolean status = false;
        String sql = "DELETE FROM procurement WHERE IdPO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(6, po.getIdPO());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}
