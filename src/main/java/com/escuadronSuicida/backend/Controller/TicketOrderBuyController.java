package com.escuadronSuicida.backend.Controller;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import com.escuadronSuicida.backend.services.TicketOrderBuyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("ticketOrderBuys")
@AllArgsConstructor


public class TicketOrderBuyController {

    private TicketOrderBuyService ticketOrderBuyService;


    @GetMapping
    public ResponseEntity<List<TicketOrderBuy>> findAll(){
        List<TicketOrderBuy> ticketOrderBuys = ticketOrderBuyService.findTicketOrderBuy();
        return ResponseEntity.ok(ticketOrderBuys);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketOrderBuy> findById(@PathVariable Long id){
        TicketOrderBuy ticketOrderBuy = ticketOrderBuyService.findById(id);
        return ResponseEntity.ok(ticketOrderBuy);
    }

    private TicketOrderBuyRepository repo;

    @PostMapping("/ticketsOrderBuys")
    public ResponseEntity<TicketOrderBuy> create(@RequestBody TicketOrderBuy ticketOrderBuy) {

        try {
            return ResponseEntity.ok(repo.save(ticketOrderBuy));
        }catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

    }

    @PutMapping("ticket/{id}")
    public TicketOrderBuy update(@RequestBody TicketOrderBuy ticketOrderBuy, @PathVariable Long id){
        return repo.save(ticketOrderBuy);
    }


    @DeleteMapping("ticket/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
