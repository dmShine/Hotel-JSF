/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.dao;
import com.grupo8.hotel.model.Hospede;
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
public class HospedeDAO {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    public void save(Hospede hospede) {
        if (hospede.getId() == null) {
            em.persist(hospede);
        } else {
            em.merge(hospede);
        }
    }

    public Hospede findById(Long id) {
        return em.find(Hospede.class, id);
    }

    public List<Hospede> findAll() {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h", Hospede.class);
        List<Hospede> hospedes = query.getResultList();
        System.out.println("Hospedes: " + hospedes.size());
        return hospedes;
    }

    public void delete(Hospede hospede) {
        if (!em.contains(hospede)) {
            hospede = em.merge(hospede);
        }
        em.remove(hospede);
    }
}

