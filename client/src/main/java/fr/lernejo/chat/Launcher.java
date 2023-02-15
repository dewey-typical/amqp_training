package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input a message, we will sent it for you (q for quit):\n");
            String message = sc.nextLine();
            if (message.equals("q")) {
                System.out.println("Salam");
                return;
            }

            rabbitTemplate.convertAndSend("", "chat_messages", message);
            System.out.println("message sent ! ");
        }
    }
}
