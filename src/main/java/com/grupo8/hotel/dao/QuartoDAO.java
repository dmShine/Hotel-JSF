/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.dao;
import com.grupo8.hotel.model.Quarto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author felip
 */

@Stateless
public class QuartoDAO {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    public List<Quarto> findAll() {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
        List<Quarto> quartos = query.getResultList();
        System.out.println("Quartos: " + quartos.size());
        return quartos;
    }

    public Quarto findById(Long id) {
        return em.find(Quarto.class, id);
    }
}

