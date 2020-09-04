package com.lexisnexis.CarStuff.operations;

import com.lexisnexis.CarStuff.entities.Car;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface FileOps {

    List<Car> read(String fileName);
    void write(String fileName, String content) throws IOException;
}
