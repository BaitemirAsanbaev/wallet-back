package com.example.baitemir.wallet.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
    @JsonProperty("balance_id")
    public Long getBalanceId() {
        return this.balance != null ? this.balance.getId() : null;
    }
    public Expense(long id, int value, Balance balance) {
        this.id = id;
        this.value = value;
        this.balance = balance;
    }

    public Expense() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
