import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    @Test
    public void fiftynineShouldReturnF() {
        Grader GraderTester = new Grader();
        char result = GraderTester.determineLetterGrade(59);
        assertEquals('F', result);
    }
    @Test
    public void minusOneReturnsllegalArgumentException() {
        Grader GraderTester = new Grader();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    GraderTester.determineLetterGrade(-1);
                });
    }
    /*
     * more test cases can come below ......
     */
}