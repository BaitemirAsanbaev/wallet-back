package com.example.baitemir.wallet.repositories;

import com.example.baitemir.wallet.enteties.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
