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
public class Representative {

    public int representativeID;
    public String nameFirst;
    public String nameLast;

    public Representative(int representativeID, String nameFirst, String nameLast) {
        this.representativeID = representativeID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    @Override
    public String toString() {
        return representativeID + ": " + nameFirst + "  " + nameLast;
    }
    
    
}
