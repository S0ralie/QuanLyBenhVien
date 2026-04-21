package com.hospital.QuanLyBenhVien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class QuanLyBenhVienApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyBenhVienApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void launchBrowser() {
		System.setProperty("java.awt.headless", "false");
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URI("http://localhost:8080/"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}