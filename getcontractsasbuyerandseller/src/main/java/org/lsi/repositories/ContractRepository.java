package org.lsi.repositories;

import org.lsi.entities.Contract;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    // Add custom query methods if needed
}
