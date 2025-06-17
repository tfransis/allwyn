package net.azurewebsites.fakerestapi.books.dto;

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
public class BookDto
{
    Integer id;
    String title;
    String description;
    Integer pageCount;
    String excerpt;
    String publishDate;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final BookDto other = (BookDto) obj;

        return this.id.equals(other.id) &&
               this.title.equals(other.title) &&
               this.description.equals(other.description) &&
               this.pageCount.equals(other.pageCount) &&
               this.excerpt.equals(other.excerpt) &&
               this.publishDate.equals(other.publishDate);
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
