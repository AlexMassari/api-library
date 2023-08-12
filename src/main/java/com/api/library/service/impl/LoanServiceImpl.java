package com.api.library.service.impl;

import com.api.library.dto.LoanDto;
import com.api.library.entity.BookEntity;
import com.api.library.entity.LoanEntity;
import com.api.library.entity.MemberEntity;
import com.api.library.exception.*;
import com.api.library.repository.BookRepository;
import com.api.library.repository.LoanRepository;
import com.api.library.repository.MemberRepository;
import com.api.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl  implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Override
    public LoanDto getLoanById(BigInteger loanId) {
        LoanEntity loan = loanRepository.findLoanById(loanId)
                .orElseThrow(()-> new LoanIdNotFoundException(loanId));
        BookEntity book = bookRepository.findBookById(loan.getLoanBookId())
                .orElseThrow(()-> new BookIdNotFoundException(loan.getLoanBookId()));
        MemberEntity member = memberRepository.findMemberById(loan.getLoanMemberId())
                .orElseThrow(() -> new MemberIdNotFoundException(loan.getLoanMemberId()));

        LoanDto loanDto= new LoanDto();
        loanDto.setID(loan.getLoanId());
        loanDto.setBOOKTITLE(book.getBookTitle());
        loanDto.setMEMBERNAME(member.getMemberName());
        loanDto.setDATE(loan.getLoanDate());
        loanDto.setDATELIMIT(loan.getLoanLimitDate());
        loanDto.setDATERETURN(loan.getLoanReturnDate());
        loanDto.setSTATE(loan.getLoanState());
        return loanDto;
    }

    @Override
    public List<LoanDto> GetLoanByMember(BigInteger loanMemberId) throws NotFoundException {
        MemberEntity member = memberRepository.findMemberById(loanMemberId)
                .orElseThrow(()->new MemberIdNotFoundException(loanMemberId));
        List<LoanEntity> loanByMember = loanRepository.findLoanByMember(loanMemberId);
        List<LoanDto> loanDtos = new ArrayList<>();
        for(LoanEntity loan : loanByMember){
            BookEntity book = bookRepository.findBookById(loan.getLoanBookId())
                    .orElseThrow(()-> new BookIdNotFoundException(loan.getLoanBookId()));
            LoanDto loanDto = new LoanDto();
            loanDto.setID(loan.getLoanId());
            loanDto.setBOOKTITLE(book.getBookTitle());
            loanDto.setMEMBERNAME(member.getMemberName());
            loanDto.setDATE(loan.getLoanDate());
            loanDto.setDATELIMIT(loan.getLoanLimitDate());
            loanDto.setDATERETURN(loan.getLoanReturnDate());
            loanDto.setSTATE(loan.getLoanState());
            loanDtos.add(loanDto);
        }
        return loanDtos;
    }

    @Override
    public void insertLoan(BigInteger bookId, BigInteger memberId, Date loanDate, Date loanLimit, Date loanReturn, String loanState) throws NotFoundException {
        loanRepository.insertLoan(bookId, memberId, loanDate, loanLimit, loanReturn, loanState);
    }

    @Override
    public void updateLoan(BigInteger bookId, BigInteger memberId, Date loanDate, Date loanLimit, Date loanReturn, String loanState, BigInteger loanId) throws NotFoundException {
        LoanEntity loan=loanRepository.findLoanById(loanId).orElse(null);
        if(loan==null){
            throw new NotFoundException("Loan ID Not Found");
        }
        loanRepository.updateLoan(bookId, memberId, loanDate, loanLimit, loanReturn, loanState, loanId);
    }

    @Override
    public void deleteLoan(BigInteger loanId) throws NotFoundException {
        LoanEntity loan=loanRepository.findLoanById(loanId).orElse(null);
        if(loan==null)
        {
            throw new NotFoundException("Loan ID not found");
        }
        loanRepository.deleteLoan(loanId);
    }
}
