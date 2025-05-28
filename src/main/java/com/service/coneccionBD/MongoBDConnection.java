/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.coneccionBD;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author ACER
 */
public class MongoBDConnection {

    private static final String CONNECTION_STRING = "mongodb+srv://jarango:GClfNp3VLZfYPQf0@cluster0.avd8vhv.mongodb.net/";
    private static final String DATABASE_NAME = "reviews";
    private static MongoClient mongoClient = null;

    // Método para obtener la conexión
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    // Método para cerrar la conexión 
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}