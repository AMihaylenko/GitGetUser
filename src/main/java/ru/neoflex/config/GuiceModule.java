package ru.neoflex.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import ru.neoflex.service.FileReader;
import ru.neoflex.service.UserService;
import ru.neoflex.service.impl.FileReaderImpl;
import ru.neoflex.service.impl.UserServiceImpl;

import static spark.Spark.port;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        port(8080);
        bind(FileReader.class).to(FileReaderImpl.class).in(Singleton.class);
        bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
    }
}