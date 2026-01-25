package project.sort.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;
    private String password;
    private String mail;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(password, person.password) && Objects.equals(mail, person.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, mail);
    }

    public String toString() {
        return "\nname: " +  this.name + "; password: " + this.password + "; mail: " + this.mail;
    }
}