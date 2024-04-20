package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketOrderBuyRepository extends JpaRepository<TicketOrderBuy, Long> {

    List<TicketOrderBuy> findByTicketOrderBuy_IdOrderByIdDesc(Long id);
}