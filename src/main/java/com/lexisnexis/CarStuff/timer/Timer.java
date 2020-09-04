package com.lexisnexis.CarStuff.timer;

import com.lexisnexis.CarStuff.entities.Car;
import com.lexisnexis.CarStuff.operations.BufferFileOps;
import com.lexisnexis.CarStuff.operations.FileOps;
import com.lexisnexis.CarStuff.repository.Repository;
import com.lexisnexis.CarStuff.repository.RepositoryFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class Timer {

    static final int REPEAT_TIME_MILLIS = 10 * 60 * 1000;


//    public void run(){
//        System.out.println(Thread.currentThread());
//        Runnable helloRunnable = new Runnable() {
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
//
//    }

    @Scheduled(cron = "0 */1 * ? * *")
    public void scheduleFixedRateTask() {
            FileOps fr = new BufferFileOps();
            List<Car> list = fr.read("car_data.csv");
            Date data = new Date();
            Repository repo = RepositoryFactory.getRepository(2);

            for (Car c : list) {
                int nr = ThreadLocalRandom.current().nextInt(1, 12);
                if (nr == 7) {
                    c.setCreatedDate(data);
                    c.setLastUpdatedDate(data);
                    //repo.saveCar(c);
                }
            }
        System.out.println("It worked dw");
    }
}
