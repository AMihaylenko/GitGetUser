package ru.neoflex.service.impl;

import ru.neoflex.exception.FileNotFoundException;
import ru.neoflex.service.FileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileReaderImpl implements FileReader {

    public List<String> readFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.trim());
            }
            return data;
        } catch (IOException e) {
            throw new FileNotFoundException("FileNotFound");
        }
    }
}