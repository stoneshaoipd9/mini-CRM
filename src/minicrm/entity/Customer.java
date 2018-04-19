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
public class Customer {

    public int customerID;
    public String nameFirst;
    public String nameLast;
    public String address;
    public String postalCode;
    public String phoneNumber;
    public String SIN;

    public Customer(int customerID, String nameFirst, String nameLast, String address, String postalCode, String phoneNumber, String SIN) {
        this.customerID = customerID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.SIN = SIN;
    }

    @Override
    public String toString() {
        return customerID + ": " + nameFirst + "/" + nameLast + "/" + address + "/" + postalCode + "/" + phoneNumber + "/" + SIN;
    }
    
    
}
