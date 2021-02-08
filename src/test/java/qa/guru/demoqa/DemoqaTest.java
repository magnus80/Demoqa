package qa.guru.demoqa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

class DemoqaTest {

    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanov";
    private static final String USER_EMAIL = "Ivan@Ivanov.ru";
    private static final String USER_NUMBER = "1234567890";
    private static final String CURRENT_ADDRESS = "currentAddress";

    private static final String FIO = "Ivan Ivanov";
    private static final String GENDER = "Male";
    private static final String DATE = "05 February,2021";
    private static final String SUBJECT = "Biology";
    private static final String HOBBIE = "Sports";
    private static final String PICTURE = "guy.jpeg";
    private static final String STATE_AND_CITY = "Uttar Pradesh Agra";

    @BeforeAll
    static void setUp() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    @Tag("demoqa")
    void iCanFillAndCheckFormTest() {

        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(USER_EMAIL);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(USER_NUMBER);
        $("#dateOfBirthInput").click();
        $$(".react-datepicker__day")
                .find(exactText("5")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Bio");
        $(".subjects-auto-complete__menu-list").click();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("guy.jpeg");
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
