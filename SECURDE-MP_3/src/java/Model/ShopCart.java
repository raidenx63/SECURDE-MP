/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Stewrat
 */
public class ShopCart {
    private ArrayList<Item> items = new ArrayList();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    public void addItem(Item item){
        this.items.add(item);
    }
    
    public float calculateTotal(){
        float sum = 0; 
        
        for (Item item : items) {
            sum += item.getPrice();
        }
        
        return sum;
    }
}
