package Session7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerTestData {

	@Test

	void fakerTest() {

		Faker f = new Faker();
		System.out.println(f.name().firstName());
		System.out.println(f.name().lastName());
		System.out.println(f.name().fullName());

		System.out.println(f.name().username());
		System.out.println(f.internet().password());

		System.out.println(f.internet().safeEmailAddress());

		System.out.println(f.internet().safeEmailAddress());

		System.out.println(f.internet().safeEmailAddress());

	}

}
