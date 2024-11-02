package com.example.models.course.challenges.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class CodingChallenge extends ChallengeType {
    private List<String> testCases;
    private List<String> expectedResult;

    public CodingChallenge(String name, String theory, String task, List<String> testCases, List<String> expectedResult) {
        super(name, theory, task);
        this.testCases = testCases;
        this.expectedResult = expectedResult;
    }
}
