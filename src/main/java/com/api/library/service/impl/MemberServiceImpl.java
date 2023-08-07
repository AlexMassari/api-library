package com.api.library.service.impl;

import com.api.library.entity.MemberEntity;
import com.api.library.exception.MemberIdNotFoundException;
import com.api.library.exception.MemberNameNotFoundException;
import com.api.library.repository.MemberRepository;
import com.api.library.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public MemberEntity findMemberId(BigInteger memberId) {
        return memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new MemberIdNotFoundException(memberId));
    }

    @Override
    public MemberEntity findMemberName(String memberName) {
        return memberRepository.findMemberByName(memberName)
                .orElseThrow(() -> new MemberNameNotFoundException(memberName));
    }

    @Override
    @Transactional
    public void insertMember(String name, Date birth, String adress, String phone, String email, Date entryDate) {
        memberRepository.insertMember(name, birth, adress, phone, email, entryDate);
    }

    @Override
    @Transactional
    public void updateMember(String name, Date birth, String adress, String phone, String email, Date entryDate, BigInteger memberId) {
        memberRepository.updateMember(name, birth, adress, phone, email, entryDate, memberId);
    }

    @Override
    @Transactional
    public void deleteMember(BigInteger memberId) {
        memberRepository.deleteMember(memberId);
    }
}
