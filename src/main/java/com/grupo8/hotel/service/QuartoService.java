/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.service;

import com.grupo8.hotel.dao.QuartoDAO;
import com.grupo8.hotel.model.Quarto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author felip
 */
@Stateless
public class QuartoService {

    @Inject
    private QuartoDAO quartoDAO;

    public List<Quarto> findAll() {
        return quartoDAO.findAll();
    }

    public Quarto buscarPorId(Long id) {
        return quartoDAO.findById(id);
    }
}

