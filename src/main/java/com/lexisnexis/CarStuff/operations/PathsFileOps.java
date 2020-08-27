package com.lexisnexis.CarStuff.operations;

import com.lexisnexis.CarStuff.entities.Car;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service("paths")
public class PathsFileOps extends BucataComuna implements FileOps {

    public List<Car> read(String fileName) {
        //Path path = Paths.get("car_data.csv");

        try {
            Resource resource = new ClassPathResource("car_data.csv");
            File file = resource.getFile();
            BufferedReader reader = Files.newBufferedReader(file.toPath());
            return readUsingBufferReader(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void write(String fileName, String content) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }
}
