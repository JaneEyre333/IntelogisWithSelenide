package ru.intelogis.auth.page;

import com.codeborne.selenide.SelenideElement;
import ru.intelogis.auth.data.DataGenerator;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
        private final SelenideElement loginField = $("#login");
        private final SelenideElement passwordField = $("#password");
        private final SelenideElement loginButton = $("[type='submit']");
        private final SelenideElement loginWarning = $(withText("Ошибка авторизации"));

        public MainPage validLogin(DataGenerator.AuthInfo info) {
            loginField.setValue(info.getLogin());
            passwordField.setValue(info.getPassword());
            loginButton.click();
            return new MainPage();
        }

        public SelenideElement invalidLogin(DataGenerator.AuthInfo info) {
            loginField.setValue(info.getLogin());
            passwordField.setValue(info.getPassword());
            loginButton.click();
            loginWarning.shouldBe(appear);
            return loginWarning;
        }
}
