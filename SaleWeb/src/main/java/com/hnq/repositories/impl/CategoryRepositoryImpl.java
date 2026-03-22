/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnq.repositories.impl;

import com.hnq.pojo.Category;
import com.hnq.repositories.CategoryRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements  CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    public List<Category> getCates() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
}
