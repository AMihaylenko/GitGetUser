package ru.neoflex.user;

public class User {

    private String name;
    private String secName;
    private String patronymic;
    private Sex sex;


    public User(String name, String secName, String patronymic, Sex sex) {
        this.name = name;
        this.secName = secName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

}