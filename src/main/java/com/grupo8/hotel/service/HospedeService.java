/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.service;

import com.grupo8.hotel.dao.HospedeDAO;
import com.grupo8.hotel.model.Hospede;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author felip
 */
@Stateless
public class HospedeService {

    @Inject
    private HospedeDAO hospedeDAO;

    public void save(Hospede hospede) {
        hospedeDAO.save(hospede);
    }

    public List<Hospede> findAll() {
        return hospedeDAO.findAll();
    }

    public Hospede findById(Long id) {
        return hospedeDAO.findById(id);
    }

    public void delete(Hospede hospede) {
        hospedeDAO.delete(hospede);
    }
}

