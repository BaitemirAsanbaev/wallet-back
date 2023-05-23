package com.example.baitemir.wallet.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int value;
    private String type;
    private String description;
    private String date;

    @PrePersist
    private void onCreate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        LocalDate currentDate = LocalDate.now();
        date = currentDate.format(formatter);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id")
    @JsonBackReference
    private Balance balance;
    @JsonProperty("balance_id")
    public Long getBalanceId() {
        return this.balance != null ? this.balance.getId() : null;
    }
    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Income(Long id, int value, Balance balance_id) {
        this.id = id;
        this.value = value;
    }

    public Income() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
