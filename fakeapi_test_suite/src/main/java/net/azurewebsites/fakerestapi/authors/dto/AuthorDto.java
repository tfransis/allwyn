package net.azurewebsites.fakerestapi.authors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDto {
    Integer id;
    Integer idBook;
    String firstName;
    String lastName;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final AuthorDto other = (AuthorDto) obj;

        return this.id.equals(other.id) &&
                this.idBook.equals(other.idBook) &&
                this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
