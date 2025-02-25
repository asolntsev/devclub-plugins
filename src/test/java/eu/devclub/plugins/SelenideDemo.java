package eu.devclub.plugins;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class SelenideDemo {
  @Test
  void searchJavaPlugins() {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();

    $$("#user-tags .tag").shouldHave(sizeGreaterThan(8));
    $$("#selenide-users .user:not(.hidden)").shouldHave(size(1));

    $("#user-tags").find(byTagAndText("a", "all")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeGreaterThan(80));

    $("#user-tags").find(byTagAndText("a", "ukraine")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeLessThan(80));

    $("#user-tags").find(byTagAndText("a", "healthcare")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeLessThan(20));
  }
}
