package pages.slaidbar;

public class UpTo100Slaid extends AbstractSlaid{


    @Override
    public String buttonXpath() {
        return "//app-rush-slide[contains(@class,'active')]//span[text()=' 50% up to €100']//ancestor::div[@class=\"home-slider__item\"]//a";
    }
}
