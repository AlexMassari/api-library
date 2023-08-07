package com.api.library.controller.impl;

import com.api.library.controller.LoanController;
import com.api.library.dto.LoanDto;
import com.api.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanControllerImpl implements LoanController {

    private final LoanService loanService;

    @Override
    @GetMapping("/id/{loanId}")
    public LoanDto getLoanById(HttpServletRequest request, @PathVariable(name = "loanId") final BigInteger loanId) {
        return loanService.getLoanById(loanId);
    }

    @Override
    @GetMapping("/member/{loanMemberId}")
    public List<LoanDto> getLoanByMember(HttpServletRequest request, @PathVariable(name = "loanMemberId") final BigInteger loanMemberId) {
        return loanService.GetLoanByMember(loanMemberId);
    }
}
