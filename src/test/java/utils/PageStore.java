package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageStore {

    private WebDriver webDriver;
    private List<Object> pages;

    public PageStore() {
        webDriver = new CreateDriver().getDriver();
        pages = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz) {
        for (Object page : pages) {
            if (page.getClass() == clazz)
                return (T) page;
        }
        T page = PageFactory.initElements(webDriver, clazz);
        pages.add(page);
        return page;
    }

    public WebDriver getDriver() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return webDriver;
    }
}
