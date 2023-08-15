package com.api.library.controller.impl;

import com.api.library.controller.MemberController;
import com.api.library.entity.MemberEntity;
import com.api.library.exception.NotFoundException;
import com.api.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberControllerImpl implements MemberController {

    private final MemberService memberService;

    @Override
    @GetMapping("/id/{id}")
    public MemberEntity getMemberById(HttpServletRequest request, @PathVariable(name = "id") final BigInteger memberId){
        return memberService.findMemberId(memberId);
    }

    @Override
    @GetMapping("/name/{name}")
    public MemberEntity getMemberByName(HttpServletRequest request, @PathVariable(name = "name") final String memberName){
        return memberService.findMemberName(memberName);
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> createMember(@RequestBody MemberEntity member) {
        try{
            memberService.insertMember(member.getMemberName(), member.getMemberBirth(), member.getMemberAdress(), member.getMemberPhone(), member.getMemberEmail(), member.getMemberEntryDate());
            return ResponseEntity.ok("Member inserted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating member");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMember(@PathVariable (name="id") BigInteger memberId, @RequestBody MemberEntity member) {
        try{
        memberService.updateMember(member.getMemberName(), member.getMemberBirth(), member.getMemberAdress(), member.getMemberPhone(), member.getMemberEmail(), member.getMemberEntryDate(), memberId);
        return ResponseEntity.ok("Member update successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Member not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating member");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable (name="id") BigInteger memberId) {
        try {
            memberService.deleteMember(memberId);
            return ResponseEntity.ok("Member delete successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error !!! Member not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting member");
        }
    }
}
