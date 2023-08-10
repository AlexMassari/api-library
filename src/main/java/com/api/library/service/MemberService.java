package com.api.library.service;

import com.api.library.entity.MemberEntity;
import com.api.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.math.BigInteger;
import java.util.Date;

@Service
public interface MemberService {
    MemberEntity findMemberId(BigInteger memberId);

    MemberEntity findMemberName(String memberName);

    void insertMember(String name, Date birth, String adress, String phone, String email, Date entryDate);

    void updateMember(String name, Date birth, String adress, String phone, String email, Date entryDate, BigInteger memberId) throws NotFoundException;

    void deleteMember(BigInteger memberId) throws NotFoundException;
}
