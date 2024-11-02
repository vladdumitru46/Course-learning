package com.example.response;

import java.util.List;

public record CourseDetailsResponse(String description, String video, String tips, List<String> challenges) {
}
