package eu.devclub.plugins;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class SelenideDemo {
  @Test
  void searchJavaPlugins() {
    open("https://duckduckgo.com");

    $("[name=q]").val("java plugins");
    $("#search_button_homepage").click();

    $$("#links .result").shouldHave(sizeGreaterThan(5));
  }
}
