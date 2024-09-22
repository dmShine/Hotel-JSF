/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.service;

import com.grupo8.hotel.dao.ReservaDAO;
import com.grupo8.hotel.model.Reserva;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author felip
 */
@Stateless
public class ReservaService {

    @Inject
    private ReservaDAO reservaDAO;

    public void save(Reserva reserva) throws Exception {
        // Validações antes de salvar a reserva
        if (!reservaDAO.findReservaAtivaByQuarto(reserva.getQuarto().getId()).isEmpty()) {
            throw new Exception("O quarto já está reservado para as datas selecionadas.");
        }

        reservaDAO.save(reserva);
    }

    public List<Reserva> findAll() {
        return reservaDAO.findAll();
    }

    public Reserva findById(Long id) {
        return reservaDAO.findById(id);
    }

    public void delete(Reserva reserva) {
        reservaDAO.delete(reserva);
    }
}
