package org.plugin.mongdb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.plugin.mongdb.base.Mongdb;

public class MongDBHelper  extends Mongdb{

    /**
     * 插入Document
     * @param key
     * @param document
     */
    public static void put(String key,String json){
        String jsons="{'html':'"+json+"'}";
        Document document = Document.parse(jsons);
        getCollection(key).insertOne(document);
    }

    public static String get(String key){
        MongoCollection<Document> collection = getCollection(key);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
        return null;
    }

}
