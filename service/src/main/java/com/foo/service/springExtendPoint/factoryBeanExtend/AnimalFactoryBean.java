package com.foo.service.springExtendPoint.factoryBeanExtend;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 五月的仓颉 http://www.cnblogs.com/xrq730/p/5721366.html
 */
public class AnimalFactoryBean implements FactoryBean<Animal>
{
    private String    animal;
    
    public Animal getObject() throws Exception
    {
        if ("Monkey".equals(animal))
        {
            return new Monkey();
        }
        else if ("Tiger".equals(animal))
        {
            return new Tiger();
        }
        else
        {
            return null;
        }
    }

    public Class<?> getObjectType()
    {
        return Animal.class;
    }

    public boolean isSingleton()
    {
        return true;
    }

    public void setAnimal(String animal)
    {
        this.animal = animal;
    }
}