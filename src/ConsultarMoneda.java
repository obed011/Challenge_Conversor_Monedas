import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultarMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/935bce044b5689ce8a423c22/latest/";

    public double convertirMoneda(String fromCurrency, String toCurrency, double amount) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + fromCurrency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get response from API");
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        double exchangeRate = conversionRates.get(toCurrency).getAsDouble();

        return amount * exchangeRate;
    }
    public void imprimirResultado(String base, String conversion, Scanner scanner){
        try {
            double valor;
            System.out.println("Ingrese el valor que deseas convertir: ");
            valor=scanner.nextDouble();
            double resultado = convertirMoneda(base, conversion, valor);
            System.out.println("El valor "+ valor + " [" + base + "] corresponde al valor final de: "+ resultado + " [" + conversion +"]\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
