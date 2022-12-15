package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.slaidbar.SlaidBar;


@Epic("HOME_PAGE")
@Feature("Slide bar")
public class SlideBarTests extends BaseTest{

    @Test(dataProvider = "slides")
    public void test(String buttonOnSlide){
        steps.clickElement(buttonOnSlide);
        steps.verify404Status();
    }

    @DataProvider(name = "slides")
    public static Object[][] slides(ITestContext context) {
        return new Object[][]{
                {SlaidBar.slides.get(1).buttonXpath()},
                {SlaidBar.slides.get(2).buttonXpath()},
                {SlaidBar.slides.get(0).buttonXpath()},
        };
    }
}
