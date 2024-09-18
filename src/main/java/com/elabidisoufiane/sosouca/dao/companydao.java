package com.elabidisoufiane.sosouca.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elabidisoufiane.sosouca.model.Company;

@Repository
public interface companydao extends JpaRepository<Company, Integer> {
	Company findByName(String name);

}
