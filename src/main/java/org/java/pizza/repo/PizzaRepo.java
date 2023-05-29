package org.java.pizza.repo;

import java.util.List;

import org.java.pizza.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
	public List<Pizza> findByNomeContaining(String Nome);
}
