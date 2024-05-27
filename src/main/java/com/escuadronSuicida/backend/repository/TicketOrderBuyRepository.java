package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketOrderBuyRepository extends JpaRepository<TicketOrderBuy, Long> {
    boolean existsByUser_IdAndTicket_Id(Long userId, Long ticketId);

    //List<TicketOrderBuy> findByTicketOrderBuy_IdOrderByIdDesc(Long id);

}