package utils;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.Assert;
import java.util.ArrayList;


public class SoftAssert {
    private ArrayList<String> asserts = new ArrayList<>(0);

    public String getAsserts() {
        StringBuilder sb = new StringBuilder();
        for (String s : asserts) sb.append(s).append("\n");
        return sb.toString();
    }

    public boolean assertTrue(boolean actual, String message) {
        if (!actual) {
            asserts.add(message);
            Allure.step(message, Status.FAILED);
        }
        return actual;
    }

    public boolean assertFalse(boolean actual, String message) {
        return assertTrue(!actual, message);
    }

    public boolean assertNotNull(Object actual, String message) {
        if (actual == null) {
            String msg = message + "\nОбъект не должен быть [null]";
            asserts.add(msg);
            Allure.step(msg, Status.FAILED);
            return false;
        }
        return true;
    }

    public boolean assertNull(Object actual, String message) {
        if (actual != null) {
            String msg = message + "\nОбъект должен быть [null]";
            asserts.add(msg);
            Allure.step(msg, Status.FAILED);
            return false;
        }
        return true;
    }

    public boolean assertEquals(Integer actual, Integer expected, String message) {
        String a,e;
        a = actual == null ? "[null]" : actual.toString();
        e = expected == null ? "[null]" : expected.toString();
        return assertEquals(a, e, message);
    }

    public boolean assertEquals(String actual, String expected, String message) {
        if (!actual.equals(expected)) {
            String msg = message + "\nОжидается: " + expected + "\nФактически: " + actual;
            asserts.add(msg);
            Allure.step(msg, Status.FAILED);
        return false;
        }
        return true;
    }

    public void checkAsserts() {
        if (asserts.size() > 0) {
            StringBuilder sb = new StringBuilder("\nВ процессе выполнения сценария обнаружены ошибки (" + asserts.size() + "):");
            int i=0; for (String error : asserts) sb.append("\n").append("[").append(++i).append("]\n").append(error);
            Assert.fail(sb.toString());
        }
    }
}
