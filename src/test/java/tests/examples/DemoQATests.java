package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen=true;

    }

    @Test
    void fillFormTest() {
        String userName = "Marina";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Marina");
        $("#lastName").setValue("Komisarchuk");
        $("#userEmail").setValue("komisarchukmarina.003@gmail.com");
        $("#gender-radio-2").parent().click();
//        $("#genterWrapper").$(byText("Female")).click(); альтернатива
//        $("label[for=gender-radio-2]").click(); альтернатива
        $("#userNumber").setValue("5432345674");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2003");
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#currentAddress").setValue("Nezavisimosti 130");
        $("#hobbies-checkbox-3").parent().click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath(("img/1.png"));
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear); // должен появиться
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Komisarchuk"),text(userName),
                text("komisarchukmarina.003@gmail.com"),text("5432345674"),
                text("Female"),text("08 January,2003"),
                text("Maths"),text("Nezavisimosti 130"),
                text("Music"),text("1.png"),
                text("Haryana"),text("Karnal"));

    }

}
