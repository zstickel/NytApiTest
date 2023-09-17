package com.example.NytApiTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Thumbnail {
    @JsonProperty("url")
    private String url;
}
