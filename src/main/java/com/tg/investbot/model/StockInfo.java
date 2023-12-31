package com.tg.investbot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * TODO javadoc
 *
 * @since 29.11.2023
 */

@Entity
@Table(name = "stocks", schema = "public")
public class StockInfo {

    @Column (name = "ticker")
    private String ticker;

    @Column (name = "quantity", nullable = false)
    private Integer quantity;

    @Column (name = "buy_price", nullable = false)
    private Double buyPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private String id;

    @Column (name = "chat_id", nullable = false)
    private Long chatId;

    public StockInfo(String ticker,
                     Integer quantity,
                     Double buyPrice,
                     String id,
                     Long chatId) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.id = id;
        this.chatId = chatId;
    }

    public Long getChatId() {
        return chatId;
    }

    public StockInfo() {
    }

    public String getTicker() {
        return ticker;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StocksInfo{" +
                "ticker='" + ticker + '\'' +
                ", quantity='" + quantity + '\'' +
                ", buyPrice='" + buyPrice + '\'' +
                ", id='" + id + '\'' +
                ", chatId='" + chatId + '\'' +
                '}';
    }

    public static final class StocksInfoBuilder {
        private String ticker;
        private Integer quantity;
        private Double buyPrice;
        private String id;
        private Long chatId;

        private StocksInfoBuilder() {
        }

        public static StocksInfoBuilder aStocksInfo() {
            return new StocksInfoBuilder();
        }

        public StocksInfoBuilder withTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public StocksInfoBuilder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public StocksInfoBuilder withBuyPrice(Double buyPrice) {
            this.buyPrice = buyPrice;
            return this;
        }

        public StocksInfoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public StocksInfoBuilder withChatId(Long chatId) {
            this.chatId = chatId;
            return this;
        }

        public StockInfo build() {
            return new StockInfo(ticker, quantity, buyPrice, id, chatId);
        }
    }
}
