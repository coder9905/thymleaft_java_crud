package uz.baxtiyor.thymleaft_java.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.baxtiyor.thymleaft_java.entity.abstractentity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Student extends AbstractEntity {

//    @Column(name = "first_name", nullable = false)
    private String firstName;

//    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

}
