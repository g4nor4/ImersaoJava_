import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main { //Classe principal
    public static void main(String[] args) throws IOException, InterruptedException {
        // fazer uma conexão HTTP(protocolo para se comunicar na web) e buscar pelos filme
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();//buscar dados de uma URI
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body); //agindo como um navegador age, o MPD recebeu uma requisicao e acessou no navegador e guardou a API em uma var

        // extrair/parciar os dados que interessam (título, poster, classificação)
        var parser = new JsonParset();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        for (Map<String, String> filme : listaDeFilmes){
            System.out.println("Título: " + filme.get("title"));
            System.out.println("Imagem: " + filme.get("image"));
            System.out.println("Classificacao: " + filme.get("imDbRating"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int estrelinhas = (int)classificacao;
            for(int n = 1; n <= estrelinhas; n++) {
                System.out.print("⭐");
            }

            System.out.println("\n");

        }

        //exibir e manipular os dados
    }
}