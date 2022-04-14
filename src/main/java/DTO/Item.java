/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author XuanQuy
 */
public class Item {

    int maSp;
    int soLuong;
    String title;
    float price;
    String image;

    public Item() {
    }

    public Item(int maSp, int soLuong, String title, float price, String image) {
        this.maSp = maSp;
        this.soLuong = soLuong;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.maSp;
        hash = 47 * hash + this.soLuong;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Float.floatToIntBits(this.price);
        hash = 47 * hash + Objects.hashCode(this.image);
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
        final Item other = (Item) obj;
        if (this.maSp != other.maSp) {
            return false;
        }
        return true;
    }

}
