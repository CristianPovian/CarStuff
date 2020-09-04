package com.lexisnexis.CarStuff.operations;

import com.lexisnexis.CarStuff.entities.Car;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service("scanner")
public class ScannerFileOps implements FileOps {

    public List<Car> read(String fileName) {
        File file = new File(fileName);
        try {
            Scanner myReader = new Scanner(file);
            List<Car> carList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                carList.add(CsvParser.parsing(data));
            }
            myReader.close();
            return carList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void write(String fileName, String content){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
