package cl.edu.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserAcademicProgramId implements Serializable {

    @Column(name = "user_information_id", length = 36, nullable = false)
    private UUID userInformationId;

    @Column(name = "academic_program_id", length = 36, nullable = false)
    private UUID academicProgramId;

}
