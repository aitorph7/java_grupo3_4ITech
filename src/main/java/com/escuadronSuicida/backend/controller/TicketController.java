package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.repository.TicketRepository;
import com.escuadronSuicida.backend.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("tickets")
@AllArgsConstructor


public class TicketController {
    private TicketService ticketService;


    @GetMapping
    public ResponseEntity<List<Ticket>> findAll(){
        List<Ticket> tickets = ticketService.findTicket();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> findById(@PathVariable Long id){
        Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }

    private TicketRepository repo;

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {

        try {
            return ResponseEntity.ok(repo.save(ticket));
        }catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

    }


    @PutMapping("ticket/{id}")
    public Ticket update(@RequestBody Ticket ticket,@PathVariable Long id){
        return repo.save(ticket);
    }


    @DeleteMapping("ticket/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
