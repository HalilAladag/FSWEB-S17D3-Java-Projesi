package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kangaroo {
    private int id;
    private String name;
    private int weight;
    private int height;
    private boolean isAggressive;
    private String gender;
}
