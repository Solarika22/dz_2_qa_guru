import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchWiki {
    @Test
    void FindExampleCodeJUnit5() {
        // Открыть страницу Selenide на GitHub
        open("https://github.com/selenide/selenide");
        // Клик на вкладку Wiki
        $(byText("Wiki")).click();
        // Поиск по Pages (проверяем что есть SoftAssertions)
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // Клик на SoftAssertions (Открыть страницу)
        $(byText("SoftAssertions")).click();
        // Проверить, что есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }

    @Test
    void DragAndDropAB() {
        // Открыть сайт
       open("https://the-internet.herokuapp.com/drag_and_drop");
       // Перенести А на место В$
        $("#column-a").dragAndDropTo("#column-b");
        // Проверить, что они переместились
        $ ("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
