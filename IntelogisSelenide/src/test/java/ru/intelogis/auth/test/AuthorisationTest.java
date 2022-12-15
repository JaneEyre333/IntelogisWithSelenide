package ru.intelogis.auth.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelogis.auth.data.DataGenerator;
import ru.intelogis.auth.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthorisationTest {
    LoginPage loginPage;

    @BeforeEach
    void setup() {
        Configuration.headless = true;
        loginPage = open("https://ilswebreact-develop.azurewebsites.net/", LoginPage.class);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Should login success ")
    void shouldLoginSuccess() {
        var authInfo = DataGenerator.getValidAuthInfo();
        var mainPage = loginPage.validLogin(authInfo);
    }

    @Test
    @DisplayName("Wrong login")
    void shouldFailWrongLogin() {
        var authInfo = DataGenerator.getInvalidLogin();
        var result = loginPage.invalidLogin(authInfo);
    }

    @Test
    @DisplayName("Wrong password")
    void shouldFailWrongPassword() {
        var authInfo = DataGenerator.getInvalidPassword();
        var result = loginPage.invalidLogin(authInfo);
    }

}
