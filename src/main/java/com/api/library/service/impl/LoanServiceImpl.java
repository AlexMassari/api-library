package com.api.library.service.impl;

import com.api.library.dto.LoanDto;
import com.api.library.entity.BookEntity;
import com.api.library.entity.LoanEntity;
import com.api.library.entity.MemberEntity;
import com.api.library.exception.BookIdNotFoundException;
import com.api.library.exception.LoanIdNotFoundException;
import com.api.library.exception.MemberIdNotFoundException;
import com.api.library.repository.BookRepository;
import com.api.library.repository.LoanRepository;
import com.api.library.repository.MemberRepository;
import com.api.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
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
    public List<LoanDto> GetLoanByMember(BigInteger loanMemberId) {
        List<LoanEntity> loanByMember = loanRepository.findLoanByMember(loanMemberId);
        List<LoanDto> loanDtos = new ArrayList<>();
        for(LoanEntity loan : loanByMember){
            BookEntity book = bookRepository.findBookById(loan.getLoanBookId())
                    .orElseThrow(()-> new BookIdNotFoundException(loan.getLoanBookId()));
            MemberEntity member = memberRepository.findMemberById(loan.getLoanMemberId())
                    .orElseThrow(() -> new MemberIdNotFoundException(loan.getLoanMemberId()));
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
}
