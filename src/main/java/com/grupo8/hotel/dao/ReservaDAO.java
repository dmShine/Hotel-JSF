/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.dao;
import com.grupo8.hotel.model.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author felip
 */

public class ReservaDAO {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    public void save(Reserva reserva) {
        if (reserva.getId() == null) {
            em.persist(reserva);  // Cria uma nova reserva
        } else {
            em.merge(reserva);    // Atualiza uma reserva existente
        }
    }

    public Reserva findById(Long id) {
        return em.find(Reserva.class, id);
    }

    public List<Reserva> findAll() {
        TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva r", Reserva.class);
        return query.getResultList();
    }

    public List<Reserva> findReservaAtivaByQuarto(Long quartoId) {
        TypedQuery<Reserva> query = em.createQuery(
            "SELECT r FROM Reserva r WHERE r.id_quarto = :quartoId AND r.data_check_out IS NULL", 
            Reserva.class
        );
        query.setParameter("quartoId", quartoId);
        return query.getResultList();
    }

    public void delete(Reserva reserva) {
        if (!em.contains(reserva)) {
            reserva = em.merge(reserva);
        }
        em.remove(reserva);
    }
}

