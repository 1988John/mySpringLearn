package com.foo.test.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlType;  
  
/** 
 * @author      zhuc 
 * @create      2013-3-29 下午2:51:52 
 */  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = { "name", "desc" })  
public class Role {  
  
    @XmlElement  
    private String name;  
  
    @XmlElement  
    private String desc;  
  
    /** 
     * @return the name 
     */  
    public String getName() {  
        return name;  
    }  
  
    /** 
     * @return the desc 
     */  
    public String getDesc() {  
        return desc;  
    }  
  
    /** 
     * @param name the name to set 
     */  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    /** 
     * @param desc the desc to set 
     */  
    public void setDesc(String desc) {  
        this.desc = desc;  
    }  
  
    /* (non-Javadoc) 
     * @see java.lang.Object#toString() 
     */  
    @Override  
    public String toString() {  
        return "Role [name=" + name + ", desc=" + desc + "]";  
    }  
  
}  