package com.study0406.member3.dto;

import com.study0406.member3.entity.PersonEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonDTO {
    private String i_field;
    private String i_empno;
    private String n_hname;
    private String n_hpno;

    public static PersonDTO toPersonDTO(PersonEntity personEntity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setI_field(personEntity.getI_field());
        personDTO.setI_empno(personEntity.getI_empno());
        personDTO.setN_hname(personEntity.getN_hname());
        personDTO.setN_hpno(personEntity.getN_hpno());
        return personDTO;
    }
}
