package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestFakerData.*;

public class PracticeWithFakerForm extends com.demoqa.tests.TestFakerBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();


    @Feature("Заполнение регистрационной формы")
    @Story("Заполнение формы с фейковыми данными")
    @Test
    @DisplayName("Полное заполнение регистрационной формы c Faker")
     void fillTestes() {
        practiceFormPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail(email)
        .setGender(gender)
        .setNumber(number)
        .setBirthDate(day,month,year )
        .setHobbies(hobby)
        .setSubjects(subject)
        .setUploadPicture("John Doe.jpeg")
        .setAddress(address)
        .setState(state)
        .setCity(city)
        .setSubmit();

        practiceFormPage.checkResultsTableVisible()
                .checkResult("Student Name",firstName + " " + lastName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",number)
                .checkResult("Date of Birth",date)
                .checkResult("Subjects",subject)
                .checkResult("Hobbies",hobby)
                .checkResult("Picture","John Doe.jpeg")
                .checkResult("Address",address)
                .checkResult("State and City",state + " " + city);

    }
}

