import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("🚀 Server started on http://localhost:8081");
    }

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = """
            <html>
            <head>
                <title>DevOps Project</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        text-align: center;
                        background-color: #0f172a;
                        color: white;
                        padding: 50px;
                    }
                    h1 {
                        font-size: 50px;
                        color: #38bdf8;
                    }
                    h2 {
                        color: #facc15;
                    }
                    p {
                        font-size: 20px;
                    }
                    .box {
                        margin-top: 30px;
                        padding: 20px;
                        border-radius: 10px;
                        background-color: #1e293b;
                    }
                </style>
            </head>
            <body>

                <h1>🚀 DevOps Pipeline Project</h1>
                <p><b>By Prem</b></p>

                <div class="box">
                    <h2>Project Flow</h2>
                    <p>GitHub → Jenkins → Docker → AWS EC2 → Monitoring</p>
                </div>

                <div class="box">
                    <h2>Tech Stack</h2>
                    <p>Java | Docker | Jenkins | AWS | Prometheus | Grafana</p>
                </div>

                <div class="box">
                    <h2>Status</h2>
                    <p>✅ Application Running Successfully</p>
                </div>

            </body>
            </html>
            """;

            // Proper encoding (important)
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);

            // Set header
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");

            // Send response
            exchange.sendResponseHeaders(200, responseBytes.length);

            // Write response safely
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }

            System.out.println("Request handled ✅");
        }
    }
}