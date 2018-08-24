package com.foo.test.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;  
  
/** 
 * @author      zhuc 
 * @create      2013-3-29 下午2:51:44 
 */  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "student")  
@XmlType(propOrder = {})  
public class Student {  
  
    @XmlAttribute  
    private Integer id;  
  
    @XmlElement  
    private String name;  
  
    @XmlElement(name = "role")  
    private Role role;  
  
    /** 
     * @return the id 
     */  
    public Integer getId() {  
        return id;  
    }  
  
    /** 
     * @return the name 
     */  
    public String getName() {  
        return name;  
    }  
  
    /** 
     * @return the role 
     */  
    public Role getRole() {  
        return role;  
    }  
  
    /** 
     * @param id the id to set 
     */  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    /** 
     * @param name the name to set 
     */  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    /** 
     * @param role the role to set 
     */  
    public void setRole(Role role) {  
        this.role = role;  
    }  
  
    /* (non-Javadoc) 
     * @see java.lang.Object#toString() 
     */  
    @Override  
    public String toString() {  
        return "Student [id=" + id + ", name=" + name + ", role=" + role + "]";  
    }  
  
}  