/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm078;

import com.app.uts.ENTITYPurchaseOrder.npm078.PurchaseOrder;

/**
 *
 * @author Asus
 */
public class ConnectMysql {
     PurchaseOrderDataSource datasource = new PurchaseOrderDataSource();
   
        public static void main(String[] args) {
            //Pemanggilan method insert
            new ConnectMysql().testInsert();
           
            //Pemanggilan method update
          // new ConnnectMysql().testUpdate();
    }
        
    //pembuatan method insert
    public void testInsert(){
        //pemanggilan kelas mahasiswa
        PurchaseOrder po = new PurchaseOrder();
        po.setIdPO("55994");
        po.setDeskripsi("Log kayu");
        po.setTanggalPO("04 April 2020");
        po.setSupplier("kemal");
        po.setTotalPO("1113");
        boolean sukses = datasource.insert(po);
        //berhasil
        if (sukses) {
            System.out.println("Insert Data Berhasil!");
        }else{
            System.out.println("Insert Data Gagal!");
        }
    }
    
    //pembuatan method Update
    public void testUpdate(){
        //pemanggilan kelas getByID
        PurchaseOrder po = datasource.getByID("1445");
        po.setIdPO("1450");
        boolean sukses = datasource.update(po);
        //berhasil
        if (sukses) {
            System.out.println("Update Data Berhasil!");
        }else{
            System.out.println("Update Data Gagal!");
        }
    }
}
