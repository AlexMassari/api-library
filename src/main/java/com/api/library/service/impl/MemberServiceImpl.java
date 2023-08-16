package com.api.library.service.impl;

import com.api.library.dto.BookDto;
import com.api.library.entity.AuthorEntity;
import com.api.library.entity.BookEntity;
import com.api.library.entity.MemberEntity;
import com.api.library.entity.PublisherEntity;
import com.api.library.exception.*;
import com.api.library.repository.MemberRepository;
import com.api.library.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<MemberEntity> getMembers() {
        List<MemberEntity> memberEntities = memberRepository.listMembers();
        return new ArrayList<>(memberEntities);
    }

    @Override
    @Transactional
    public void insertMember(String name, Date birth, String adress, String phone, String email, Date entryDate) {
        memberRepository.insertMember(name, birth, adress, phone, email, entryDate);
    }

    @Override
    @Transactional
    public void updateMember(String name, Date birth, String adress, String phone, String email, Date entryDate, BigInteger memberId) throws NotFoundException{
        MemberEntity member = memberRepository.findMemberById(memberId).orElse(null);
        if(member==null){
            throw new NotFoundException("Member not found");
        }
        memberRepository.updateMember(name, birth, adress, phone, email, entryDate, memberId);
    }

    @Override
    @Transactional
    public void deleteMember(BigInteger memberId) throws NotFoundException {
        MemberEntity member = memberRepository.findMemberById(memberId).orElse(null);
        if(member==null){
            throw new NotFoundException("Member not found");
        }
        memberRepository.deleteMember(memberId);
    }
}
