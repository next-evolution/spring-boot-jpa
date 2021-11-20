package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account ORDER BY account_number", nativeQuery = true)
    List<Account> list();

    @Query(value = "SELECT * FROM account WHERE email_address = :emailAddress", nativeQuery = true)
    Account get(@Param("emailAddress") String emailAddress);

    /**
     * booleanを返す場合は 'true' 'false' などのように「'」で括らないと
     * java.math.BigInteger cannot be cast to class java.lang.Boolean
     */
    @Query(value = "SELECT CASE WHEN T.CNT > 0 THEN 'true' ELSE 'false' END FROM " +
                   "( select count(*) AS CNT from account where email_address = :emailAddress ) T",
            nativeQuery = true)
    Boolean exists(@Param("emailAddress") String emailAddress);

}
