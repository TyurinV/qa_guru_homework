package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {



    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void textFields() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Федя");
        $("#lastName").setValue("Киняев");
        $("#userEmail").setValue("fedya@kinyaev.ru");

        $("label[for='gender-radio-3']").click(); //gender other
        $("#userNumber").setValue("5435434355");

        // birthday
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("April"); // month
        $(".react-datepicker__year-select").selectOption("1975");   // year
        $("[aria-label='Choose Monday, April 14th, 1975']").click();      // day


        $("#subjectsInput").setValue("hi").pressEnter();
        $("label[for='hobbies-checkbox-1']").click(); //hobbies sports
        $("label[for='hobbies-checkbox-2']").click(); //hobbies reading
        $("label[for='hobbies-checkbox-3']").click(); //hobbies music

        $("#uploadPicture").setValue("D:\\Autotests\\qa_guru_homework\\src\\test\\pic\\che.png"); //file

        $("#currentAddress").setValue("г.Москва, ул.Академика Королева, д.12");

        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("N").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


    }


}
