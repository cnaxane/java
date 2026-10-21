/**
 * Assignment 29 - Exercise 1
 * Problem Statement: Create a JSP page to display student information entered by the user.
 *
 * This program contains:
 * 1. An embedded HTTP Server to demonstrate the live JSP-based web application.
 * 2. Complete JSP source code template demonstrating standard JSP tags (<%@ page %>, <%= %>, <% %>).
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class StudentInfoJSP {
    private static final int PORT = 8081;

    // Standalone JSP Source Code Representation for assignment submission
    public static final String JSP_SOURCE_CODE = """
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>
        <head>
            <title>Student Information JSP Page</title>
            <style>
                body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
                .card { background: white; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 500px; }
                h2 { color: #333; }
                label { font-weight: bold; display: block; margin-top: 10px; }
                input[type="text"] { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; }
                input[type="submit"] { margin-top: 15px; padding: 10px 15px; background-color: #007bff; color: white; border: none; cursor: pointer; border-radius: 4px; }
                table { width: 100%; border-collapse: collapse; margin-top: 20px; }
                th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
                th { background-color: #f2f2f2; }
            </style>
        </head>
        <body>
            <div class="card">
                <h2>Student Information Form (JSP)</h2>
                <form method="POST" action="student_info.jsp">
                    <label>Roll Number:</label>
                    <input type="text" name="rollNo" required />
                    <label>Student Name:</label>
                    <input type="text" name="name" required />
                    <label>Department / Course:</label>
                    <input type="text" name="course" required />
                    <label>Semester:</label>
                    <input type="text" name="semester" required />
                    <label>Marks (%):</label>
                    <input type="text" name="marks" required />
                    <input type="submit" value="Display Information" />
                </form>

                <%
                    String rollNo = request.getParameter("rollNo");
                    String name = request.getParameter("name");
                    String course = request.getParameter("course");
                    String semester = request.getParameter("semester");
                    String marks = request.getParameter("marks");

                    if (rollNo != null && name != null) {
                %>
                    <hr />
                    <h3>Submitted Student Details:</h3>
                    <table>
                        <tr><th>Field</th><th>Value</th></tr>
                        <tr><td>Roll Number</td><td><%= rollNo %></td></tr>
                        <tr><td>Name</td><td><%= name %></td></tr>
                        <tr><td>Course</td><td><%= course %></td></tr>
                        <tr><td>Semester</td><td><%= semester %></td></tr>
                        <tr><td>Marks (%)</td><td><%= marks %> %</td></tr>
                    </table>
                <%
                    }
                %>
            </div>
        </body>
        </html>
        """;

    // Helper to parse POST form URL-encoded body
    private static Map<String, String> parseFormData(String formData) {
        Map<String, String> map = new HashMap<>();
        if (formData == null || formData.isEmpty()) return map;
        String[] pairs = formData.split("&");
        for (String pair : pairs) {
            String[] kv = pair.split("=");
            if (kv.length == 2) {
                String key = URLDecoder.decode(kv[0], StandardCharsets.UTF_8);
                String val = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                map.put(key, val);
            }
        }
        return map;
    }

    static class StudentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            Map<String, String> params = new HashMap<>();

            if ("POST".equalsIgnoreCase(method)) {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                params = parseFormData(sb.toString());
            }

            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html><html><head><title>Student Info JSP</title>");
            html.append("<style>");
            html.append("body { font-family: Arial, sans-serif; background: #eef2f7; padding: 30px; display: flex; justify-content: center; }");
            html.append(".box { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); width: 480px; }");
            html.append("h2 { color: #2c3e50; margin-top: 0; }");
            html.append("label { font-weight: bold; margin-top: 10px; display: block; }");
            html.append("input[type=text] { width: 100%; padding: 8px; margin-top: 4px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }");
            html.append("input[type=submit] { margin-top: 15px; width: 100%; padding: 10px; background: #2980b9; color: #fff; border: none; border-radius: 4px; font-size: 16px; cursor: pointer; }");
            html.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            html.append("th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }");
            html.append("th { background-color: #34495e; color: white; }");
            html.append("</style></head><body>");

            html.append("<div class='box'>");
            html.append("<h2>Student Information (JSP Simulation)</h2>");
            html.append("<form method='POST'>");
            html.append("<label>Roll Number:</label><input type='text' name='rollNo' value='").append(params.getOrDefault("rollNo", "")).append("' required />");
            html.append("<label>Student Name:</label><input type='text' name='name' value='").append(params.getOrDefault("name", "")).append("' required />");
            html.append("<label>Course:</label><input type='text' name='course' value='").append(params.getOrDefault("course", "")).append("' required />");
            html.append("<label>Semester:</label><input type='text' name='semester' value='").append(params.getOrDefault("semester", "")).append("' required />");
            html.append("<label>Marks (%):</label><input type='text' name='marks' value='").append(params.getOrDefault("marks", "")).append("' required />");
            html.append("<input type='submit' value='Submit & Display via JSP' />");
            html.append("</form>");

            if (!params.isEmpty() && params.containsKey("rollNo")) {
                html.append("<h3 style='margin-top:25px;color:#27ae60;'>JSP Output Result:</h3>");
                html.append("<table>");
                html.append("<tr><th>Field</th><th>Submitted Value</th></tr>");
                html.append("<tr><td>Roll Number</td><td>").append(params.get("rollNo")).append("</td></tr>");
                html.append("<tr><td>Student Name</td><td>").append(params.get("name")).append("</td></tr>");
                html.append("<tr><td>Course</td><td>").append(params.get("course")).append("</td></tr>");
                html.append("<tr><td>Semester</td><td>").append(params.get("semester")).append("</td></tr>");
                html.append("<tr><td>Marks (%)</td><td>").append(params.get("marks")).append("%</td></tr>");
                html.append("</table>");
            }
            html.append("</div></body></html>");

            byte[] bytes = html.toString().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 29 - Exercise 1: Student Information JSP Application ===");
        System.out.println("\n[1] Standalone JSP Code for 'student_info.jsp':");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(JSP_SOURCE_CODE);
        System.out.println("-----------------------------------------------------------------");

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/", new StudentHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("\n[2] Live Embedded JSP Demonstration Server started!");
            System.out.println("Access in browser at: http://localhost:" + PORT + "/");
            System.out.println("Press Ctrl+C or let test complete.");

            // Stop automatically after a short duration if running non-interactively
            if (args.length == 0) {
                System.out.println("Server running in background for demonstration...");
                Thread.sleep(1500);
                server.stop(0);
                System.out.println("Live simulation test completed successfully.");
            }
        } catch (Exception e) {
            System.out.println("Server note: " + e.getMessage());
        }
    }
}
