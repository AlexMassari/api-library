package com.api.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MB_ID")
    private BigInteger memberId;
    @Column(name = "MB_NAME")
    private String memberName;
    @Column(name="MB_BIRTH")
    private Date memberBirth;
    @Column(name = "MB_ADRESS")
    private String memberAdress;
    @Column(name = "MB_PHONE")
    private String memberPhone;
    @Column(name = "MB_EMAIL")
    private String memberEmail;
    @Column(name="MB_ENTRYDATE")
    private Date memberEntryDate;
}
