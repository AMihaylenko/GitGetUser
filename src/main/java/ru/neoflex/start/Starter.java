package ru.neoflex.start;

import com.google.inject.Guice;
import ru.neoflex.config.GuiceModule;
import ru.neoflex.controller.ControllerGenerate;

public class Starter {
    public static void main(String[] args) {
        Guice.createInjector(new GuiceModule()).getInstance(ControllerGenerate.class).run();
    }
}
