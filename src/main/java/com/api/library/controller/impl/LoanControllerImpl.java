package com.api.library.controller.impl;

import com.api.library.controller.LoanController;
import com.api.library.dto.LoanDto;
import com.api.library.entity.LoanEntity;
import com.api.library.exception.NotFoundException;
import com.api.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
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

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createLoan(@RequestBody LoanEntity loanEntity) {
        try {
            loanService.insertLoan(loanEntity.getLoanBookId(), loanEntity.getLoanMemberId(), loanEntity.getLoanDate(), loanEntity.getLoanLimitDate(), loanEntity.getLoanReturnDate(), loanEntity.getLoanState());
            return ResponseEntity.ok("Loan inserted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting loan");
        }
    }

    @Override
    @PutMapping("/update/{loanId}")
    public ResponseEntity<String> updateLoan(@PathVariable(name = "loanId") BigInteger loanId, @RequestBody LoanEntity loanEntity) {
        try {
            loanService.updateLoan(loanEntity.getLoanBookId(), loanEntity.getLoanMemberId(), loanEntity.getLoanDate(), loanEntity.getLoanLimitDate(), loanEntity.getLoanReturnDate(), loanEntity.getLoanState(), loanId);
            return ResponseEntity.ok("Loan update successfully");

        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Loan not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating loan");
        }
    }

    @Override
    @DeleteMapping("/delete/{loanId}")
    public ResponseEntity<String> deleteLoan(@PathVariable(name="loanId") BigInteger loanId) {
        try {
            loanService.deleteLoan(loanId);
            return ResponseEntity.ok("Loan deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Loan not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating loan");
        }
    }
}
