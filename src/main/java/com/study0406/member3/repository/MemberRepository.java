package com.study0406.member3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study0406.member3.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> { // Entity Class, PK의 타입

    // 회원정보 조회 (SELECT * FROM SY_USER WHERE I_EMPNO = ?)
    Optional<MemberEntity> findByUid(String uid);

    @Query(value = "SELECT  B.I_FIELD     I_FIELD," +
            "        A.I_EMPNO     I_EMPNO," +
            "        B.N_HNAME     N_HNAME," +
            "        B.D_BIRTH     D_BIRTH," +
            "        A.GRADE       GRADE," +
            "        A.UID         UID," +
            "        A.EMP_PASS    EMP_PASS" +
            " FROM    SY_USER A   INNER JOIN HR_PERSON B ON A.I_EMPNO = B.I_EMPNO" +
            " WHERE   A.F_USE = 'Y'", nativeQuery = true)
    List<MemberEntity> findAll();

}
