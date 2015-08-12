/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.advweb.day4.business;

import com.acme.advweb.day4.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerBean {
    
    @PersistenceContext private EntityManager em;  
    
    public void doSomething()
    {
    }
    
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery(
                "select c from Customer c", Customer.class);
        return (query.getResultList());
    }
    
    public Customer find(Integer custId) {
        TypedQuery<Customer> query = em.createQuery(
                "select c from Customer c where c.customerId = :cid"
                , Customer.class);        
        query.setParameter("cid", custId);
        List<Customer> result = query.getResultList();
        return ((result.size() > 0)? result.get(0): null);
        //return (em.find(Customer.class, custId));
    }
}
