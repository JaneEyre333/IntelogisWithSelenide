package ru.intelogis.auth.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement heading = $(".ils-title");

    public MainPage() {
        heading.shouldBe(visible);
    }
}

