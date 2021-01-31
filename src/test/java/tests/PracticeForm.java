package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

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

        $("#firstName").setValue("Фома");
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

        File file = new File("src/test/resources/che.png"); //file1 of 2
        $("#uploadPicture").uploadFile(file);              //file2 of 2


        $("#currentAddress").setValue("г.Москва, ул.Академика Королева, д.12");

        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("N").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).shouldHave(text("Фома Киняев"));
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).shouldHave(text("fedya@kinyaev.ru")); //mail
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).shouldHave(text("Other")); //gender
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).shouldHave(text("5435434355")); // mobile
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).shouldHave(text("14 April,1975")); // birth
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).shouldHave(text("Hindi")); // Subjects
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).shouldHave(text("Sports, Reading, Music")); // Hobbies
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")).shouldHave(text("che.png")); // picture
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).shouldHave(text("г.Москва, ул.Академика Королева, д.12")); //address
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).shouldHave(text("NCR Gurgaon")); //state and city


    }


}
