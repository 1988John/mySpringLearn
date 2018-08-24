package com.foo.test.xml;

import java.util.Date;
  
import javax.xml.bind.annotation.XmlAccessType;  
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;  
  
/** 
 * @author      zhuc 
 * @create      2013-3-29 下午2:49:48 
 */  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement  
@XmlType(name = "book", propOrder = { "author", "calendar", "price", "id" })  
public class Book {  
  
    @XmlElement(required = true)  
    private String author;  
  
    @XmlElement(name = "price_1", required = true)  
    private float price;  
  
    @XmlElement  
    private Date calendar;  
  
    @XmlAttribute  
    private Integer id;  
  
    /** 
     * @return the author 
     */  
    public String getAuthor() {  
        return author;  
    }  
  
    /** 
     * @return the price 
     */  
    public float getPrice() {  
        return price;  
    }  
  
    /** 
     * @return the calendar 
     */  
    public Date getCalendar() {  
        return calendar;  
    }  
  
    /** 
     * @return the id 
     */  
    public Integer getId() {  
        return id;  
    }  
  
    /** 
     * @param author the author to set 
     */  
    public void setAuthor(String author) {  
        this.author = author;  
    }  
  
    /** 
     * @param price the price to set 
     */  
    public void setPrice(float price) {  
        this.price = price;  
    }  
  
    /** 
     * @param calendar the calendar to set 
     */  
    public void setCalendar(Date calendar) {  
        this.calendar = calendar;  
    }  
  
    /** 
     * @param id the id to set 
     */  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    /* (non-Javadoc) 
     * @see java.lang.Object#toString() 
     */  
    @Override  
    public String toString() {  
        return "Book [author=" + author + ", price=" + price + ", calendar=" + calendar + ", id=" + id + "]";  
    }  
  
}  