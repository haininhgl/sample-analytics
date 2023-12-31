package com.example.sample.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    @Positive
    @NotNull
    private Integer account_id;

    @Positive
    @PositiveOrZero
    private Integer transaction_count;
    private Date bucket_start_date;
    private Date bucket_end_date;

    @Field("transaction")
    private List<transactions> transactionsList = new ArrayList<>();

    public static class transactions {
        @NotNull
        @Past
        private Date date;
        private Integer amount;
        private String transaction_code;

        private String symbol;
        @NotNull
        @Positive
        private Double price;

        @NotNull
        @Positive
        private Double total;

        public transactions(@NotNull Date date, @NotNull Integer amount, @NotNull String transaction_code, String symbol, @NotNull Double price, @NotNull Double total) {
            this.date = date;
            this.amount = amount;
            this.transaction_code = transaction_code;
            this.symbol = symbol;
            this.price = price;
            this.total = total;
        }
        public Date getDate(){
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Integer getAmount(){
            return amount;
        }
        public void setAmount(Integer amount) {
            this.amount = amount;
        }
        public String getTransaction_code(){
            return transaction_code;
        }
        public void setTransaction_code(String transaction_code) {
            this.transaction_code = transaction_code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }
    }

    public Transaction() {
    }

    public Transaction(String id, @NotNull Integer account_id, @NotNull Integer transaction_count, Date bucket_start_date, Date bucket_end_date, List<transactions> transactionsList ){
        this.id = id;
        this.account_id = account_id;
        this.transaction_count = transaction_count;
        this.bucket_end_date = bucket_end_date;
        this.bucket_start_date = bucket_start_date;
        this.transactionsList = transactionsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Date getBucket_end_date() {
        return bucket_end_date;
    }

    public void setBucket_end_date(Date bucket_end_date) {
        this.bucket_end_date = bucket_end_date;
    }

    public Date getBucket_start_date() {
        return bucket_start_date;
    }

    public void setBucket_start_date(Date bucket_start_date) {
        this.bucket_start_date = bucket_start_date;
    }

    public Integer getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(Integer transaction_count) {
        this.transaction_count = transaction_count;
    }

    public List<transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
