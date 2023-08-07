package com.api.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loan")
public class LoanEntity {
    @Id
    @Column(name = "LO_ID")
    private BigInteger loanId;
    @Column(name = "LO_BOOKID")
    private BigInteger loanBookId;
    @Column(name = "LO_MEMBERID")
    private BigInteger loanMemberId;
    @Column(name="LO_LOANDATE")
    private Date loanDate;
    @Column(name="LO_LOANLIMITDATE")
    private Date loanLimitDate;
    @Column(name="LO_RETURNDATE")
    private Date loanReturnDate;
    @Column(name = "LO_STATE")
    private String loanState;
}

