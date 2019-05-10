package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class TestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.dropbox.com/");
		selenium.start();
	}

	@Test
	public void testCase() throws Exception {
		selenium.open("http://localhost:8081/home/");
		assertEquals("Insert title here", selenium.getTitle());
		selenium.select("id=op", "label=Create Folder");
		selenium.type("name=dropboxPath", "Test");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals("", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
