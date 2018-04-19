/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicrm.entity;

/**
 *
 * @author ipd
 */
public class Interaction {

    public int interactionID;
    public int customerID;
    public int repID;
    public String date;
    public String notes;

    public Interaction(int interactionID, int customerID, int repID, String date, String notes) {
        this.interactionID = interactionID;
        this.customerID = customerID;
        this.repID = repID;
        this.date = date;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Interaction{" + "interactionID=" + interactionID + ", customerID=" + customerID + ", repID=" + repID + ", date=" + date + ", notes=" + notes + '}';
    }
    
    
}
