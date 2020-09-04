package com.lexisnexis.CarStuff.operations;


import com.lexisnexis.CarStuff.entities.Car;

import java.util.Date;

public class CsvParser {
    private CsvParser() {
    }

    public static Car parsing(String line){
        String[] arr = line.split(",");
        Car car = new Car(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],Double.parseDouble(arr[8]),Double.parseDouble(arr[9]),Double.parseDouble(arr[10]),
                Double.parseDouble(arr[11]), Double.parseDouble(arr[12]),arr[13],arr[14],Double.parseDouble(arr[15]),arr[16], Double.parseDouble(arr[17]),arr[18],
                arr[19],Double.parseDouble(arr[20]),Double.parseDouble(arr[21]),arr[22]);
        return car;
    }
}
