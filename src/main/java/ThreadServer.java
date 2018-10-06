import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс - сервер, принимает запросы от клиентов и отдает данные
 */
public class ThreadServer {
    public static void main(String args[]) {
        // Определяем номер порта, который будет "слушать" сервер
        int port = 1777;

        try {
            // Открыть серверный сокет (ServerSocket)
            ServerSocket servSocket = new ServerSocket(port);
            int i = 1;
            while (true) {
                System.out.println("Waiting for a connection on " + port);

                // Получив соединение начинаем работать с сокетом
                Socket fromClientSocket = servSocket.accept();

                // Стартуем новый поток для обработки запроса клиента
                new Thread(new SocketThread(fromClientSocket), "Client № " + i).start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

