package se.iths.paveena.labb2bankomat.controller;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnTwoEnTest {

    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
    }
    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createPage() {
        page = browser.newPage();
    }

    // Sidan går att nå
    @Test
    @DisplayName("Balance page should be reachable")
    public void balancePageReachable() {

        Response response = page.navigate("http://localhost:8080/balance");

        assertEquals(200, response.status());
    }


    // Sidan laddas korrekt

    @Test
    @DisplayName("Balance page should load content")
    public void balancePageLoads() {

        page.navigate("http://localhost:8080/balance");

        String title = page.title();

        assertEquals("Account balance", title);
    }

    // Saldo visas
    @Test
    @DisplayName("Balance should be displayed")
    public void balanceDisplayed() {

        page.navigate("http://localhost:8080/balance");

        String balanceText =
                page.locator("#balance").innerText();

        assertNotNull(balanceText);
    }
}
