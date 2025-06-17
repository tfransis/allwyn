package com.netcompany.intrasoft.dto.actions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netcompany.intrasoft.dto.actions.completiondata.CompletionData;
import com.netcompany.intrasoft.dto.actions.enums.WorkTaskType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book
{
    Integer id;
    String title;
    String description;
    Integer pageCount;
    String excerpt;
    String publishDate;
}



