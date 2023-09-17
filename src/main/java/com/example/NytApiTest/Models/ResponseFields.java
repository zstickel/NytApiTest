package com.example.NytApiTest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseFields {
    private List<Documents> docs;
    private Meta meta;
}
