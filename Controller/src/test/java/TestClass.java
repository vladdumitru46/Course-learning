import com.example.ServerApplication;
import com.example.course.CourseService;
import com.example.course.challenges.CourseChallengesService;
import com.example.models.course.Course;
import com.example.models.course.challenges.CourseChallenges;
import com.example.models.course.challenges.types.ChallengeType;
import com.example.models.course.challenges.types.CodingChallenge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {ServerApplication.class})
public class TestClass {
    @Autowired
    CourseChallengesService courseChallengesService;
    @Autowired
    CourseService courseService;

    @Test
    public void test() {
        try {
            Course course = courseService.getByName("Course1");
            List<ChallengeType> list = new ArrayList<>();
            List<String> testCases = new ArrayList<>();
            List<String> expectedResults = new ArrayList<>();
            testCases.add("testcase");
            testCases.add("testcase2");
            expectedResults.add("expectedResult");
            expectedResults.add("expectedResult2");
            list.add(new CodingChallenge("firstChallenge", "Theorrryyy", "the task at hand", testCases, expectedResults));
            list.add(new CodingChallenge("SecondChallenge", "Theorrryyydfadsasd", "the task at hand sadaadf", testCases, expectedResults));
            courseChallengesService.add(new CourseChallenges("TestCase1", "Description of this", course, list));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
