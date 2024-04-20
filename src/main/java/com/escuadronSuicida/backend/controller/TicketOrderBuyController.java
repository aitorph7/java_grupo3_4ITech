package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import com.escuadronSuicida.backend.security.SecurityUtils;
import com.escuadronSuicida.backend.services.TicketOrderBuyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("ticketOrderBuys")
@AllArgsConstructor
@CrossOrigin("*")


public class TicketOrderBuyController {

    private TicketOrderBuyService ticketOrderBuyService;

    @GetMapping
    public ResponseEntity<List<TicketOrderBuy>> findAll(){
        List<TicketOrderBuy> ticketOrderBuys = ticketOrderBuyService.findTicketOrderBuy();
        System.out.println(ticketOrderBuys);
        return ResponseEntity.ok(ticketOrderBuys);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketOrderBuy> findById(@PathVariable Long id){
        TicketOrderBuy ticketOrderBuy = ticketOrderBuyService.findById(id);
        return ResponseEntity.ok(ticketOrderBuy);
    }

    //@GetMapping("ticketOrderBuys/filter-by-ticketOrderBuy/{id}")
    //public List<TicketOrderBuy> findAllByTicketOrderBuyId(@PathVariable Long id) {
    //    return this.repo.findByTicketOrderBuy_IdOrderByIdDesc(id);
    //}


    private TicketOrderBuyRepository repo;

    @PostMapping
    public TicketOrderBuy create(@RequestBody TicketOrderBuy ticketOrderBuy) {

        SecurityUtils.getCurrentUser().ifPresent(user -> ticketOrderBuy.setUser(user));
        return this.repo.save(ticketOrderBuy);

    }


    @PutMapping("{id}")
    public TicketOrderBuy update(@RequestBody TicketOrderBuy ticketOrderBuy, @PathVariable Long id){
        return repo.save(ticketOrderBuy);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
