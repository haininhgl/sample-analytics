package com.example.sample.dto;

import java.util.List;

public class AccountDTO {

    private Integer account_id;

    private Integer limit;

    private List<String> products;

    public AccountDTO(Integer account_id, Integer limit, List<String> products) {
        this.account_id = account_id;
        this.limit = limit;
        this.products = products;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
