package com.sim;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;

public class DemoQA {
    @BeforeAll
    static void openMaximized() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillTheForm () {
        open("/automation-practice-form");
        String firstName = "Pavel";
        String lastName = "Mikhaylov";
        String userEmail = "mih@test.ru";
        String gender = "Male";
        String userNumber = "9999999999";
        String month = "May";
        String year = "1986";
        String date = "29 May,1986\n";
        String subjectsInput = "Hindi";
        String hobbie = "Reading";
        File file = new File("src/test/resources/img/test.jpg");
        String fileName = "test.jpg";
        String currentAddress = "SPB.ru";
        String state = "NCR";
        String city = "Delhi";



        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();


        $("#close-fixedban").click();
        $("#submit").click();

        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text(firstName + " " + lastName));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text(userEmail));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text(gender));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text(userNumber));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text(date)); // Не знаю как проверить число
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text(subjectsInput));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text(hobbie));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(text(fileName));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text(currentAddress));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(text(state + " " + city));

        sleep(1000);
    }

}
