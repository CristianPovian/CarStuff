package com.lexisnexis.CarStuff.operations;

import com.lexisnexis.CarStuff.entities.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BucataComuna {
    public List<Car> readUsingBufferReader(BufferedReader bufferedReader) throws IOException {
        String st;
        List<Car> carList = new ArrayList<>();

        while ((st = bufferedReader.readLine()) != null) {
            carList.add(CsvParser.parsing(st));
        }
        bufferedReader.close();
        return carList;
    }
}
