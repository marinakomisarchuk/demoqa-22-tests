package tests.examples;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnit5Examples {

    @BeforeAll
    static void setUp() {
        System.out.println("___setUp()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("_____beforeEach()");
    }

    @Test
    void firstTest() {
        System.out.println("_______firstTest()");
    }

    @Test
    void secondTest() {
        System.out.println("_______secondTest()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("_____afterEach()");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("___tearDown()");
    }

}
