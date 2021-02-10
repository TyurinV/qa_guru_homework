package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomInt;


public class PracticeForm {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void textFields() {

        open("https://demoqa.com/automation-practice-form");
        String firstName = getRandomString(10),
                lastName = getRandomString(9),
                email = getRandomEmail(),
                gender = getRandomGender(1,1),
                mobile = getRandomPhone(),
                dayOfBirth =  getRandomInt(10,28) + "",
                monthOfBirth = getRandomMonth(1,1),
                yearOfBirth = getRandomInt(1950, 2000) + "",
                subject1 = getRandomSubjects(1,1),
                subject2 = getRandomSubjects(1,1),
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "che.png",
                currentAddress = getRandomString(50),
                state = "NCR", // могу зарандомить, но тогда city не могу, пытался через if else - не вышло.
                city = "Dehli";



        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject1).pressEnter().setValue(subject2).pressEnter();
        $(byText(hobby1)).click();
        $(byText(hobby2)).click();
        $(byText(hobby3)).click();
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        //File file = new File("src/test/resources/img/" + picture); //file1 of 2
        //$("#uploadPicture").uploadFile(file);              //file2 of 2
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[2]").shouldHave(text(email)); //mail
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[3]/td[2]").shouldHave(text(gender)); //gender
        $x("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/form/div[4]/div[2]").shouldHave(text(mobile)); // mobile
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[5]/td[2]").shouldHave(text(dayOfBirth+" "+ monthOfBirth + ","+ yearOfBirth)); // birth
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[6]/td[2]").shouldHave(text(subject1+ ", "+ subject2)); // Subjects
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[7]/td[2]").shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3)); // Hobbies
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[8]/td[2]").shouldHave(text(picture)); // picture
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[9]/td[2]").shouldHave(text("г.Москва, ул.Академика Королева, д.12")); //address
        $x("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[10]/td[2]").shouldHave(text(state + " " + city)); //state and city

        sleep(10000);
    }


}
