package pages.slaidbar;

import java.util.List;

public class SlaidBar {

    public static final List<Slaid> slides = List.of(
            new DefaultValueSlide(),
            new UpTo100Slaid(),
            new WelcomeSlaid()
    );
}
