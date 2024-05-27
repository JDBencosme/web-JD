package org.pucmm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

// Leer la URL desde la entrada estándar para despues crear el httpclient

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una URL válida:");
        String url = scanner.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar la solicitud y manejar la respuesta
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(body -> {
                    analyzeHtmlContent(body);
                })
                .join();
    }

    private static void analyzeHtmlContent(String html) {
        Document document = Jsoup.parse(html);

        //Imprimir la cantidad de lineas, parrafos, imagenes y formularios

        int lineCount = html.split("\n").length;
        System.out.println("Cantidad de líneas: " + lineCount);

        Elements paragraphs = document.select("p");
        System.out.println("Cantidad de párrafos: " + paragraphs.size());

        int imagesInParagraphs = 0;
        for (Element paragraph : paragraphs) {
            imagesInParagraphs += paragraph.select("img").size();
        }
        System.out.println("Cantidad de imágenes dentro de párrafos: " + imagesInParagraphs);

        Elements forms = document.select("form");
        int postForms = 0;
        int getForms = 0;
        for (Element form : forms) {
            String method = form.attr("method").toUpperCase();
            if ("POST".equals(method)) {
                postForms += 1;
            } else if ("GET".equals(method)) {
                getForms += 1;
            }
        }
        System.out.println("Cantidad de formularios (POST): " + postForms);
        System.out.println("Cantidad de formularios (GET): " + getForms);

        // Mostrar los campos del tipo input y su respectivo tipo
        for (Element form : forms) {
            System.out.println("Formulario encontrado:");
            Elements inputs = form.select("input");
            for (Element input : inputs) {
                System.out.println("  Tipo de input: " + input.attr("type"));
            }
        }

        // Identificar que el método de envío sea POST y enviar una petición
        for (Element form : forms) {
            String method = form.attr("method").toUpperCase();
            if ("POST".equals(method)) {
                String action = form.attr("action");
                sendPostRequest(action);
            }
        }
    }

    private static void sendPostRequest(String actionUrl) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(actionUrl))
                .header("20190470", "10138017")
                .POST(HttpRequest.BodyPublishers.ofString("practica1"))
                .build();

        // Enviar la solicitud y manejar la respuesta
        client.sendAsync(request, BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Respuesta del servidor al enviar el formulario POST:");
                    System.out.println(response.body());
                })
                .join();
    }
}
