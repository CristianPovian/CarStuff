package com.lexisnexis.CarStuff.repository;

public class RepositoryFactory {

    static volatile MongoRepository mongo; //vizibilitate pentru toti
    static MemoryRepository memory;

    private RepositoryFactory() {
    }//sa nu putem instantia in alta parte "din greseala"

//    public static Repository getRepository(int ceva) {
//        if (ceva % 2 == 0) {
//            if(mongo == null) {
//                mongo = new MongoRepository();
//            }
//            return mongo;
//        } else {
//            if(memory == null){
//                memory = new MemoryRepository();
//            }
//            return memory;
//        }
//    }

    public static Repository getRepository(int ceva) {
        if (ceva % 2 == 0) {
            if(mongo == null) {
                synchronized (RepositoryFactory.class) {
                    if(mongo == null) {
                        mongo = new MongoRepository();
                    }
                }
            }
            return mongo;
        } else {
            if(memory == null){
                memory = new MemoryRepository();
            }
            return memory;
        }
    }

}
