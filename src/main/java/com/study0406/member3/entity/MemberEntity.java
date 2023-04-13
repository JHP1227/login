package com.study0406.member3.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.study0406.member3.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;

//일종의 테이블 역할, 테이블을 자바 객체처럼 사용하게 해준다.

@Entity
@Setter
@Getter
@Table(name = "sy_user") // 생성되는 테이블 이름
public class MemberEntity {
    @Id
    private String i_empno;

    private String n_hname;

    private String uid;

    private String grade;

    private String emp_pass;

    private String i_field;
    private LocalDateTime d_birth;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setI_empno(memberDTO.getI_empno());
        memberEntity.setN_hname(memberDTO.getN_hname());
        memberEntity.setUid(memberDTO.getUid());
        memberEntity.setGrade(memberDTO.getGrade());
        memberEntity.setEmp_pass(memberDTO.getEmp_pass());
        memberEntity.setI_field(memberDTO.getI_field());
        memberEntity.setD_birth(memberDTO.getD_birth());
        return memberEntity;
    }
}
