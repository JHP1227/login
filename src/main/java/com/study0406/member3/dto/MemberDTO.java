package com.study0406.member3.dto;

import java.time.LocalDateTime;

import com.study0406.member3.entity.MemberEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok이 getter setter tostring 자동으로 만들어줌
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private String i_empno;
    private String n_hname;
    private String uid;
    private String grade;
    private String emp_pass;
    private String i_field;
    private LocalDateTime d_birth;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setI_empno(memberEntity.getI_empno());
        memberDTO.setN_hname(memberEntity.getN_hname());
        memberDTO.setUid(memberEntity.getUid());
        memberDTO.setGrade(memberEntity.getGrade());
        memberDTO.setEmp_pass(memberEntity.getEmp_pass());
        memberDTO.setI_field(memberEntity.getI_field());
        memberDTO.setD_birth(memberEntity.getD_birth());
        return memberDTO;
    }
}
