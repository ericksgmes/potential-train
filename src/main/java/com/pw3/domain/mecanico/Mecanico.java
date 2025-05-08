package com.pw3.domain.mecanico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    @Id
    @UuidGenerator
    @GeneratedValue
    @Convert(converter = MecanicoId.MecanicoIdConverter.class)
    private MecanicoId id;

    @Convert(converter = Email.EmailConverter.class)
    private Email email;

    @Convert(converter = Nome.NomeConverter.class)
    private Nome nome;

    @Convert(converter = AnosExperiencia.AnosExperienciaConverter.class)
    private AnosExperiencia anosExperiencia;
}
