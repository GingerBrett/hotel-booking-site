package edu.wgu.d387_sample_code.convertor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.*;

@Service
public class WelcomeMessage {

    // pool with at least 2 threads
    private static final ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

    public String[] getWelcomeMessage() throws ExecutionException, InterruptedException {
        // submit two independent threads, each calling loadMessage
        Future<String> englishFuture = messageExecutor.submit(() -> loadMessage("welcome_en_CA.properties"));
        Future<String> frenchFuture = messageExecutor.submit(() -> loadMessage("welcome_fr_CA.properties"));

        // both threads are running loadMessage() in parallel
        String english = englishFuture.get(); // wait until English finishes
        String french = frenchFuture.get();   // wait until French finishes

        return new String[]{english, french};
    }

    // executed inside each thread
    private String loadMessage(String fileName) {
        try (InputStream in = new ClassPathResource(fileName).getInputStream()) {
            Properties prop = new Properties();
            prop.load(in);
            return prop.getProperty("welcome");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading " + fileName;
        }
    }
}
