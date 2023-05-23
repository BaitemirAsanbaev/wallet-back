package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.enteties.Budget;
import com.example.baitemir.wallet.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BudgetImplementation implements BudgetService{
    @Autowired
    private BudgetRepository budgetRepo;

    @Override
    public Budget getBudget(){
        return  budgetRepo.findAll().get(0);
    }
    @Override
    public void setBudget(Budget budget){
        budgetRepo.deleteAll();
        budgetRepo.save(budget);
    }
}

