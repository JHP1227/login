package com.study0406.member3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study0406.member3.dto.MemberDTO;
import com.study0406.member3.entity.MemberEntity;
import com.study0406.member3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
        // 1. dto -> entity 변환 / 2. repository의 save메서드 호출

        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
         * 1. DB에서 조회
         * 2. 비밀번호가 일치하는지 판단
         */

        Optional<MemberEntity> byUid = memberRepository.findByUid(memberDTO.getUid());
        if (byUid.isPresent()) {
            // 조회 결과가 있다(해당 가진 회원 정보가 있다)
            MemberEntity memberEntity = byUid.get();
            if (memberEntity.getI_empno().equals(memberDTO.getI_empno())) {
                // 비밀번호 일치
                // entity -> dto로 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }

    // public List<MemberDTO> findAll() {
    // List<MemberEntity> memberEntityList = memberRepository.findAll();
    // List<MemberDTO> memberDTOList = new ArrayList<>();
    // for (MemberEntity memberEntity : memberEntityList) {
    // memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
    // // MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
    // // memberDTOList.add(memberDTO);
    // }
    // return memberDTOList;
    // }

    // public List<PersonDTO> queryPerson() {
    // List<PersonDTO> personList = memberRepository.findPerson();
    // }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();

        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
            // MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            // memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }
}
