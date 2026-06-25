package com.sanz.xpensto.repository;

import com.sanz.xpensto.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<ExpenseModel, Long> {
}
// extending jpa repo so it tells spring that entity class - ExpenseModel
// and primary key is type - Long
// this avoids manual DAO methods, DB connection and manual CRUD boilerplate
