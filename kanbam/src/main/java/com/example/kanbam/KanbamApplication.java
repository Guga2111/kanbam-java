package com.example.kanbam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KanbamApplication {

	public static void main(String[] args) {
		File dockerDirectory = new File("./docker");

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(
					"docker-compose", "-f", "mysql-docker-compose.yml", "up", "-d"
			);
			processBuilder.directory(dockerDirectory);
			processBuilder.inheritIO();
			Process process = processBuilder.start();
			process.waitFor();

			waitForDatabase();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return;
		}

		SpringApplication.run(KanbamApplication.class, args);
	}

	private static void waitForDatabase() throws InterruptedException {
		System.out.println("⏳ Waiting for MySQL be ready!");

		for (int i = 0; i < 10; i++) { //50 seconds
			if (isDatabaseReady()) {
				System.out.println("✅ DB ready!");
				return;
			}
			TimeUnit.SECONDS.sleep(5);
		}

		System.out.println("❌ The DB not ready in time!");
	}

	private static boolean isDatabaseReady() {
		try {
			Process process = new ProcessBuilder(
					"docker", "exec", "meu-mysql-container", "mysqladmin", "ping", "-h", "localhost"
			).start();
			return process.waitFor() == 0;
		} catch (IOException | InterruptedException e) {
			return false;
		}
	}
}
