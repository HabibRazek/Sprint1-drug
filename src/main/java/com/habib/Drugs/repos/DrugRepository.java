package com.habib.Drugs.repos;

import com.habib.Drugs.entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long>{

}
