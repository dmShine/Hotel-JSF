/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo8.hotel.bean;

import com.grupo8.hotel.model.Hospede;
import com.grupo8.hotel.model.Quarto;
import com.grupo8.hotel.model.Reserva;
import com.grupo8.hotel.service.HospedeService;
import com.grupo8.hotel.service.QuartoService;
import com.grupo8.hotel.service.ReservaService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author felip
 */
@Named
@SessionScoped
public class ReservaBean implements Serializable {
    private Reserva reserva;
    private List<Hospede> hospedes;
    private List<Quarto> quartos;

    @Inject
    private ReservaService reservaService;
    
    @Inject
    private HospedeService hospedeService;

    @Inject
    private QuartoService quartoService;
    
    @PostConstruct
    public void init() {
        reserva = new Reserva();
        hospedes = hospedeService.findAll();
        System.out.println("Hospedes carregados: " + hospedes.size());
        quartos = quartoService.findAll();
        System.out.println("Quartos carregados: " + quartos.size());
    }

    public void saveReserva() throws Exception {
        reserva.setHospede(reserva.getHospede());
        reserva.setQuarto(reserva.getQuarto());        
        
        reservaService.save(reserva);
        reserva = new Reserva();
    }

    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public List<Hospede> getHospedes() {
        return hospedes;
    }
    public List<Quarto> getQuartos() {
        return quartos;
    }
}
