package ru.neoflex.service;

import ru.neoflex.user.Sex;
import ru.neoflex.user.User;
import java.util.Collection;

public interface UserService {

    User getUser();

    Collection<User> getUsers(int count);

    /*String getName(boolean gender);

    String getSecondName(boolean gender);

    String getPatronymic(boolean gender);

    boolean getGender();

    Sex isGender(boolean gender);*/
}
