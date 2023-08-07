package com.api.library.repository;

import com.api.library.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, BigInteger> {
    @Query(value="select LO_ID, LO_BOOKID, LO_MEMBERID, LO_LOANDATE, LO_LOANLIMITDATE, LO_RETURNDATE, LO_STATE \n" +
            "from Loans where LO_ID =:loanId", nativeQuery=true)
    Optional<LoanEntity> findLoanById(@Param("loanId") BigInteger loanId);

    @Query(value="select LO_ID, LO_BOOKID, LO_MEMBERID, LO_LOANDATE, LO_LOANLIMITDATE, LO_RETURNDATE, LO_STATE \n" +
            "from Loans where LO_MEMBERID =:loanMemberId", nativeQuery=true)
    List<LoanEntity> findLoanByMember(@Param("loanMemberId") BigInteger loanMemberId);
}
