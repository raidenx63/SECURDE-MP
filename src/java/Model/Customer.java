/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Stewrat
 */
public class Customer extends User{
    private String billAdd;
    private String shipAdd;
    private CCard card;
    
    public String getBillAdd() {
        return billAdd;
    }

    public void setBillAdd(String billAdd) {
        this.billAdd = billAdd;
    }

    public String getShipAdd() {
        return shipAdd;
    }

    public void setShipAdd(String shipAdd) {
        this.shipAdd = shipAdd;
    }

    public CCard getCard() {
        return card;
    }

    public void setCard(CCard card) {
        this.card = card;
    }
    
    
}
