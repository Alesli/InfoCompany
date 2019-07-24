package entity;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * data entity employee
 *
 * @author Alesia Skaraknoh
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    private Long id;

    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "[A-Za-z]+", message = "'Name' must contain Latin letters")
    private String name;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[A-Za-z]+", message = "'Last name' must contain Latin letters")
    private String lastName;

    private Date dateOfBirth;

    @Email(message = "E-mail should be valid")
    private String email;

    @Override
    public String toString() {
        return "Employee : " + id + "\n" +
                "name = " + name + "\n" +
                "lastName = " + lastName + "\n" +
                "dateOfBirth = " + dateOfBirth + "\n" +
                "email = " + email + "\n";
    }
}
