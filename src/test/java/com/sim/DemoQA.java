package com.sim;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Description;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

@Feature("Form")
@Owner("DemoQA")
public class DemoQA {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        String selenoidAddress = System.getProperty("selenoidAddress", "selenoid.autotests.cloud/wd/hub/");
        String selenoidLogin = credentials.selenoidLogin();
        String selenoidPass = credentials.selenoidPass();
        Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPass + "@" + selenoidAddress;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Description("Positive test")
    void test0() {
        assertTrue(true);
    }
    @Test
    @Description("Negative test")
    void test1() {
        assertTrue(true);
    }

    @Test
    @Description("Test form second lesson")
    @Severity(SeverityLevel.MINOR)

    void fillTheForm () {

        open("https://demoqa.com/automation-practice-form");
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
        //$("#uploadPicture").uploadFile(file);
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
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text(date)); // ???? ???????? ?????? ?????????????????? ??????????
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text(subjectsInput));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text(hobbie));
        //$("tr:nth-child(8) > td:nth-child(2)").shouldHave(text(fileName));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text(currentAddress));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(text(state + " " + city));

        sleep(1000);
    }


}
