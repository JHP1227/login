package com.study0406.member3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.study0406.member3.dto.PersonDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "hr_person")
public class PersonEntity {
    @Id
    private String i_field;

    private String i_empno;

    private String n_hname;

    private String n_hpno;

    public static PersonEntity toPersonEntity(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setI_field(personDTO.getI_field());
        personEntity.setI_empno(personDTO.getI_empno());
        personEntity.setN_hname(personDTO.getN_hname());
        personEntity.setN_hpno(personDTO.getN_hpno());
        return personEntity;
    }
}
