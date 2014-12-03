package doctorhere.head;

/**
 * @author : prayagupd
 */

public class Head {
  private int cukes;

  public void eat(int cukes) {
    this.cukes = cukes;
  }

  public String getSound(int waitingTime) {
    if (cukes > 41 && waitingTime >= 1) {
      return "growl";
    } else {
      return "silent";
    }
  }
}
