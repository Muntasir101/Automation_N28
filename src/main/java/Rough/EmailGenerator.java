package Rough;

import java.util.Random;

public class EmailGenerator {
    public static void main(String[] args) {
        System.out.println(generateUniqueEmail("test"));
    }

    public static String generateUniqueEmail(String username) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        // Generate a random string as a unique identifier
        String uniqueIdentifier = randomString.toString();

        // Construct the unique email address
        String domain = "gmail.com"; // You can replace this with your desired domain

        return username + "_" + uniqueIdentifier + "@" + domain;
    }
}
