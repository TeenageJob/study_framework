package org.plugin.mongdb.base;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class Mongdb {

    private static final String IP = "127.0.0.7";
    private static final int PORT = 27017;

    private static MongoDatabase mongoDatabase;

    public Mongdb() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(IP, PORT);
            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void close() {
        mongoDatabase.drop();
    }

    public static void createCollection(String name) {
        mongoDatabase.createCollection(name);
    }

    public static MongoCollection<Document> getCollection(String name) {
        if (mongoDatabase.getCollection(name) != null) {
            return mongoDatabase.getCollection(name);
        } else {
            createCollection(name);
            return mongoDatabase.getCollection(name);
        }
    }


}
