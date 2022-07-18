/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Book implements Serializable{
    private String BookID;
    private String BookTitle;
    private String Author;
    private float Price;

    public Book() {
    }

    public Book(String BookID, String BookTitle, String Author, float Price) {
        this.BookID = BookID;
        this.BookTitle = BookTitle;
        this.Author = Author;
        this.Price = Price;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
    public String getPrices()
    {
        return "$" + this.Price;
    }
    
}
