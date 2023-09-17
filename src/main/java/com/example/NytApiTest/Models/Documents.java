package com.example.NytApiTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Documents {

    @JsonProperty("abstract")
    private String abstractDescription;
    private String web_url;
    private String snippet;
    @JsonProperty("lead_paragraph")
    private String leadParagraph;
}
