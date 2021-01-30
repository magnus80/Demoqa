package qa.guru.demoqa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static qa.guru.demoqa.Constants.*;

class DemoqaTest {

    @BeforeAll
    static void setUp() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void ICanFillAndCheckFormTest() {

        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(USER_EMAIL);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(USER_NUMBER);
        $("#dateOfBirthInput")
                .click();
        $$(".react-datepicker__day")
                .find(exactText("5"))
                .click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Bio");
        $$(".subjects-auto-complete__menu-list")
                .first()
                .click();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/../resources/guy.jpeg"));
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#state").scrollTo().click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $$x("//tbody//td[2]").shouldHave(exactTexts(FIO, USER_EMAIL, GENDER,
                USER_NUMBER, DATE, SUBJECT, HOBBIE, PICTURE, CURRENT_ADDRESS, STATE_AND_CITY));
    }
}
