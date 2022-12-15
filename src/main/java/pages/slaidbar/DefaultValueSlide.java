package pages.slaidbar;

public class DefaultValueSlide extends AbstractSlaid {
    @Override
    public String buttonXpath() {
        return "//app-rush-slide[contains(@class,'active')]//span[text()='[{\"key\":\"default\",\"value\":\"test2\"}]']/ancestor::div[@class=\"home-slider__item\"]//a";
    }
}
