package com.example.NytApiTest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Meta {
    private int hits;
    private int offset;
    private int time;
}
