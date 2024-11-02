package com.example.models.course.challenges.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public sealed abstract class ChallengeType implements Serializable permits CodingChallenge{
    private String name;
    private String theory;
    private String task;
}