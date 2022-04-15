/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author XuanQuy
 */
public class Cart {

    ArrayList<Item> cart;

    public Cart() {
        this.cart = new ArrayList<Item>();
    }

    public boolean add(Item item, int so) {
        try {
            System.out.println("id" + item.getMaSp());
            if (cart.contains(item)) {
                // item hien tai
                System.out.println("go here for update");
                Item currentItem = cart.get(cart.indexOf(item));
                currentItem.setSoLuong(currentItem.getSoLuong() + so);
                // update
            } else {
                System.out.println("go here for create");
                cart.add(item);
                // add
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }
  public boolean add1(Item item) {
        try {
            System.out.println("id" + item.getMaSp());
            if (cart.contains(item)) {
                // item hien tai
                System.out.println("go here for update");
                Item currentItem = cart.get(cart.indexOf(item));
                currentItem.setSoLuong(item.getSoLuong());
                // update
            } else {
                System.out.println("go here for create");
                cart.add(item);
                // add
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public boolean removeQuantity(Item item) {
        try {
            System.out.println("id" + item.getMaSp());
            if (cart.contains(item)) {
                // item hien tai
                System.out.println("go here for update");
                Item currentItem = cart.get(cart.indexOf(item));
                currentItem.setSoLuong(currentItem.getSoLuong() - 1);
                // update
            } else {
                System.out.println("go here for create");
                cart.add(item);
                // add
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

    public float getTongTien() {
        float tongTien = 0;
        for (Item item : cart) {
            tongTien += item.getSoLuong() * item.getPrice();
        }
        return tongTien;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public int getSize() {
        return cart.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.cart);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.cart, other.cart)) {
            return false;
        }
        return true;
    }

}
