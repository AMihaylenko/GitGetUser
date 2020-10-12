package ru.neoflex.controller;


import com.google.inject.Inject;
import ru.neoflex.config.JsonTransformer;
import ru.neoflex.service.UserService;

import static spark.Spark.*;


public class ControllerGenerate {

    private final UserService userService;

    @Inject
    public ControllerGenerate(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        get("/user", ((req, res) -> userService.getUser()), new JsonTransformer());
        get("/user/:count", (req, res) -> {
            String s = req.params(":count");
            return userService.getUsers(Integer.parseInt(s));
        }, new JsonTransformer());
    }
}