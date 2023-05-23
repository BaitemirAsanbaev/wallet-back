package com.example.baitemir.wallet.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int value;
    private String date;

    @PrePersist
    private void onCreate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        LocalDate currentDate = LocalDate.now();
        date = currentDate.format(formatter);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id")
    @JsonBackReference
    private Balance from;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    @JsonBackReference
    private Balance to;

    @JsonProperty("from_id")
    public Long getFromBalanceId() {
        return this.from != null ? this.from.getId() : null;
    }
    @JsonProperty("to_id")
    public Long getToBalanceId() {
        return this.to != null ? this.to.getId() : null;
    }

    public Transaction(long id, int value, Balance fromBalance, Balance toBalance) {
        this.id = id;
        this.value = value;
        this.from = fromBalance;
        this.to = toBalance;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void setFromBalance(Balance fromBalance) {
        this.from = fromBalance;
    }


    public void setToBalance(Balance toBalance) {
        this.to = toBalance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
