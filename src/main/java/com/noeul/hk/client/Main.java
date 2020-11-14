package com.noeul.hk.client;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.sun.javafx.application.PlatformImpl;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new WindowsLookAndFeel());
		new JFrame("HK for Developers") {{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenWidth = (int) screenSize.getWidth();
			int screenHeight = (int) screenSize.getHeight();
			int width = 1280, height = 720;

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
			setSize(width, height);
			setMinimumSize(new Dimension(width, height));
			setMaximumSize(new Dimension(width, height));
			setResizable(false);

			JFXPanel panel = new JFXPanel();
			panel.setBounds(0, 0, width, height);
			add(panel);

			PlatformImpl.startup(() -> {
				Group group = new Group();
				Scene scene = new Scene(group);
				panel.setScene(scene);

				WebView webView = new WebView();

				group.getChildren().add(webView);
				webView.setMinSize(width, height);
				webView.setMaxSize(width, height);

				WebEngine webEngine = webView.getEngine();

				webEngine.load("https://hkdev.services/");
			});
		}}.setVisible(true);
	}
}
