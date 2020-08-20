package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class MockData {
    private FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());
    private static String email;
    private static String password;
    private static String name;

    public String generateRandomEmail() {
        email = fakeValuesService.bothify(new Faker().name().firstName() + "####@gmail.com");
        return email;
    }

    public String generateRandomPassword() {
        password = fakeValuesService.bothify(new Faker().name().firstName() + "1234567");
        return password;
    }

    public String generateName() {
        name = fakeValuesService.bothify(new Faker().name().firstName());
        return name;
    }
}
