package ru.neoflex.service.impl;

import ru.neoflex.service.FileReader;
import ru.neoflex.service.UserService;
import ru.neoflex.user.Sex;
import ru.neoflex.user.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static ru.neoflex.user.Sex.MAN;
import static ru.neoflex.user.Sex.WOMAN;

public class UserServiceImpl implements UserService {

    @Inject
    public UserServiceImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    private final FileReader fileReader;

    private final String fileMansName = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\MansNames.txt";
    private final String fileWomansName = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\WomansNames.txt";
    private final String fileMansSurname = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\MansSurnames.txt";
    private final String fileWomansSurname = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\WomansSurnames.txt";
    private final String fileMansPatronymics = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\MansPatronymics.txt";
    private final String fileWomansPatronymics = "C:\\Users\\amikhailenko\\demo1\\test\\test\\PracticeGuice\\src\\main\\resources\\WomansPatronymics.txt";


    private boolean getGender() {
        return new Random().nextBoolean();
    }


    private Sex getSex(boolean gender) {
        if (gender) {
            return MAN;
        } else return WOMAN;
    }


    private String getName(boolean gender) {
        List<String> names = gender ? fileReader.readFile(fileMansName) :
                fileReader.readFile(fileWomansName);
        return names.get((int) (Math.random() * names.size()));
    }


    private String getSecondName(boolean gender) {
        List<String> names = gender ? fileReader.readFile(fileMansSurname) :
                fileReader.readFile(fileWomansSurname);
        return names.get((int) (Math.random() * names.size()));
    }


    private String getPatronymic(boolean gender) {
        List<String> names = null;
        names = gender ? fileReader.readFile(fileMansPatronymics) :
                fileReader.readFile(fileWomansPatronymics);
        return names.get((int) (Math.random() * names.size()));
    }

    @Override
    public User getUser() {
        boolean gender = getGender();
        return new User(getSecondName(gender), getName(gender), getPatronymic(gender), getSex(gender));
    }

    @Override
    public Collection<User> getUsers(int count) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boolean gender = getGender();
            list.add(new User(getSecondName(gender), getName(gender), getPatronymic(gender), getSex(gender)));
        }
        return list;
    }
}