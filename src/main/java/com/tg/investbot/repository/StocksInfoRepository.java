package com.tg.investbot.repository;

import com.tg.investbot.model.StockPrice;
import com.tg.investbot.model.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @since 29.11.2023
 */
@Repository
public interface StocksInfoRepository extends JpaRepository<StockInfo, String> {
    @Override
    List<StockInfo> findAll();

    List<StockInfo> findStocksInfosByChatId(long chatId);

    @Query("SELECT new com.tg.investbot.model.StockPrice(s.ticker, SUM(s.quantity), (SUM(s.quantity * s.buyPrice) / SUM(s.quantity)))" +
            "FROM StockInfo AS s WHERE s.chatId=:chatId " +
            "GROUP BY s.ticker")
    List<StockPrice> countAverageSumByTicker(@Param("chatId") long chatId);
}