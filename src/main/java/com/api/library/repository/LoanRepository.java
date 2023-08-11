package com.api.library.repository;

import com.api.library.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
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

    @Modifying
    @Query(value = "INSERT INTO Loans (LO_BOOKID, LO_MEMBERID, LO_LOANDATE, LO_LOANLIMITDATE, LO_RETURNDATE, LO_STATE) " +
            "VALUES (:bookId, :memberId, :loanDate, :loanLimit, :loanReturn, :loanState)", nativeQuery = true)
    void insertLoan(@Param("bookId") BigInteger bookId,
                    @Param("memberId") BigInteger memberId,
                    @Param("loanDate") Date loanDate,
                    @Param("loanLimit") Date loanLimit,
                    @Param("loanReturn") Date loanReturn,
                    @Param("loanState") String loanState);

    @Modifying
    @Query(value="UPDATE Loans SET LO_BOOKID=:bookId, LO_MEMBERID=:memberId, LO_LOANDATE=:loanDate, LO_LOANLIMITDATE=:loanLimit, " +
            "LO_RETURNDATE=:loanReturn, LO_STATE=:loanState where LO_ID =:loanId", nativeQuery=true)
    void updateLoan(@Param("bookId") BigInteger bookId,
                      @Param("memberId") BigInteger memberId,
                      @Param("loanDate") Date loanDate,
                      @Param("loanLimit") Date loanLimit,
                      @Param("loanReturn") Date loanReturn,
                      @Param("loanState") String loanState,
                      @Param("loanId") BigInteger loanId);

    @Modifying
    @Query(value="DELETE FROM Loans WHERE LO_ID=:loanId", nativeQuery = true)
    void deleteLoan(@Param("loanId") BigInteger loanId);
}
