package com.api.library.service;

import com.api.library.dto.LoanDto;
import com.api.library.entity.LoanEntity;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public interface LoanService {
    LoanDto getLoanById(BigInteger loanId);
    List<LoanDto> GetLoanByMember(BigInteger loanMemberId);

    void insertLoan(BigInteger bookId, BigInteger memberId, Date loanDate, Date loanLimit, Date loanReturn, String loanState) throws NotFoundException;

    void updateLoan(BigInteger bookId, BigInteger memberId, Date loanDate, Date loanLimit, Date loanReturn, String loanState, BigInteger loanId) throws NotFoundException;

    void deleteLoan(BigInteger loanId) throws NotFoundException;
}
