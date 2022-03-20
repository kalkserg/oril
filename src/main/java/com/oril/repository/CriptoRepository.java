package com.oril.repository;

import com.oril.model.Cripto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriptoRepository extends MongoRepository<Cripto, Long> {

    Cripto findTopByCurr1AndCurr2OrderByDateDesc(String curr1, String curr2);

    Cripto findTopByCurr1OrderByLpriceDesc(String curr1);

    Cripto findTopByCurr1OrderByLpriceAsc(String curr1);

    Page<Cripto> findByCurr1OrderByLpriceAsc(String curr1, Pageable pageable);

}
