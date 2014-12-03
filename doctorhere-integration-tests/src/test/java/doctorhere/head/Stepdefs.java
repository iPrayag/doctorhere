package doctorhere.head;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author : prayagupd
 */

public class Stepdefs {
    private Head head;
    private int waitingTime;

    @Given("^I have (\\d+) cukes in my head$")
    public void i_have_cukes_in_my_belly(int cukes) throws Throwable {
      head = new Head();
      head.eat(cukes);
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int waitingTime) throws Throwable {
      this.waitingTime = waitingTime;
    }

    @Then("^my head should (.*)$")
    public void my_belly_should_growl(String expectedSound) throws Throwable {
      String actualSound = head.getSound(waitingTime);
      assertThat(actualSound, is(expectedSound));
    }

}
