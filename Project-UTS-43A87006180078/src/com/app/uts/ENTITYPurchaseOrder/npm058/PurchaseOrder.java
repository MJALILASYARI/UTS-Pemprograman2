/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.ENTITYPurchaseOrder.npm078;

/**
 *
 * @author Asus
 */
public class PurchaseOrder {
    
    private String IdPO;
    private String Deskripsi;
    private String TanggalPO;
    private String Supplier;
    private String TotalPO;

    
    
    public PurchaseOrder() {
        
    }

    public PurchaseOrder(String IdPO, String Deskripsi, String TanggalPO, String Supplier, String TotalPO) {
        this.IdPO = IdPO;
        this.Deskripsi = Deskripsi;
        this.TanggalPO = TanggalPO;
        this.Supplier = Supplier;
        this.TotalPO = TotalPO;
    }

    public String getIdPO() {
        return IdPO;
    }

    public void setIdPO(String IdPO) {
        this.IdPO = IdPO;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    public String getTanggalPO() {
        return TanggalPO;
    }

    public void setTanggalPO(String TanggalPO) {
        this.TanggalPO = TanggalPO;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getTotalPO() {
        return TotalPO;
    }

    public void setTotalPO(String TotalPO) {
        this.TotalPO = TotalPO;
    }

   
    
}
