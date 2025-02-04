package com.onestep.back.controller.member;

import com.onestep.back.dto.member.MemberDTO;
import com.onestep.back.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 1. 회원 정보 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable String memberId) {
        MemberDTO member = memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    // 2. 회원 정보 수정 (memberId 제거)
    @PutMapping("/update")
    public ResponseEntity<String> updateMember(@RequestBody MemberDTO memberDTO) {
        memberService.updateMember(memberDTO.getMemberId(), memberDTO);
        return ResponseEntity.ok("회원 정보가 수정되었습니다.");
    }

    // 3. 회원 탈퇴
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable String memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("회원 탈퇴가 완료되었습니다.");
    }

    // 4. 현재 참가 중인 목표 조회
    @GetMapping("/{memberId}/goals")
    public ResponseEntity<List<String>> getMemberGoals(@PathVariable String memberId) {
        List<String> goals = memberService.getMemberGoals(memberId);
        return ResponseEntity.ok(goals);
    }
}
