/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */

import com.mongodb.client.MongoDatabase;
import com.service.coneccionBD.MongoBDConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/mongo/test")
public class Pruebaconexion extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            MongoDatabase db = MongoBDConnection.getDatabase();
            out.println("Conectado a la base de datos: " + db.getName());
        } catch (Exception e) {
            out.println("Error al conectar con MongoDB: " + e.getMessage());
            e.printStackTrace(out);
        } finally {
            MongoBDConnection.closeConnection();
        }
    }
    
}
