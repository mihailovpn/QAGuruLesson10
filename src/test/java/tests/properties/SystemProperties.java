package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemProperties {
    @Test
    void test1() {
        String variable = System.getProperty("value");
        System.out.println(variable);
        //null
    }
    @Test
    void test2() {
        String variable = System.getProperty("value", "defaultValue");
        System.out.println(variable);
        //defaultValue
    }
    @Test
    void test3() {
        System.setProperty("variable", "setValue");
        String variable = System.getProperty("variable");
        System.out.println(variable);
        //setValue
    }
    @Test
    void test4() {
        System.setProperty("variable", "setValue");
        String variable = System.getProperty("value", "defaultValue");
        System.out.println(variable);
        //setValue
    }
    @Test
    @Tag("properties")
    void test5() {
        String variable = System.getProperty("browser", "chrome");
        System.out.println(variable);
    }
    //gradle clean properties_tests
    //chrome
    //gradle clean properties_tests -Dbrowser=opera
    //opera

    @Test
    @Tag("properties")
    void test6() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "89");
        String browserSize = System.getProperty("browserSize", "600x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        // gradle clean properties_tests -Dbrowser=opera -Dversion=93
    }
}
