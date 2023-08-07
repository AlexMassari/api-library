package com.api.library.service;

import com.api.library.dto.LoanDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface LoanService {
    LoanDto getLoanById(BigInteger loanId);
    List<LoanDto> GetLoanByMember(BigInteger loanMemberId);
}
