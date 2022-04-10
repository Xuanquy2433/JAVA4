/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author XuanQuy
 */
public class Cart {

    ArrayList<Item> cart;

    public Cart() {
        this.cart = new ArrayList<Item>();
    }

    public boolean add(Item item) {
        try {
            if (cart.contains(item)) {
                //update
                Item currentItem = cart.get(cart.lastIndexOf(item));
                currentItem.setSoLuong(currentItem.getSoLuong() + 1);
            } else {
                //add
                cart.add(item);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(Item item) {
        try {
            if (cart.contains(item)) {
                int vt = cart.indexOf(item);
                cart.remove(vt);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public float getTongTien(Item item) {
        float tongTien = 0;
        for (Item ele : cart) {
            tongTien += ele.getSoLuong() * ele.getPrice();
        }
        return tongTien;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public int getSize() {
        return cart.size();
    }

}
