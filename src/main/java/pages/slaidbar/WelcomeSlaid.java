package pages.slaidbar;

public class WelcomeSlaid extends AbstractSlaid {


    @Override
    public String buttonXpath() {
        return "//app-rush-slide[contains(@class,'active')]//div[contains(@class,'--welcome-bonus')]//a";
    }
}
