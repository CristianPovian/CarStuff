package com.lexisnexis.CarStuff.operations;


import com.lexisnexis.CarStuff.entities.Car;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service("buffer")
public class BufferFileOps extends BucataComuna implements FileOps {

    public List<Car> read(String fileName) throws RuntimeException{
        //File file = new File(fileName);
        try {
            Resource resource = new ClassPathResource("car_data.csv");
            File file = resource.getFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            return readUsingBufferReader(br);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void write(String fileName, String content) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(content);

        writer.close();
    }

}