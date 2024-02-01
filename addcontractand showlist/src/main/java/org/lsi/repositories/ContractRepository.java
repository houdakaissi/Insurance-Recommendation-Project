package org.lsi.repositories;

import org.hibernate.annotations.ParamDef;
import org.lsi.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
        List<Contract> findByBuyer_IdOrSeller_Id(Long buyerId, Long sellerId);
}
