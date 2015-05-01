package support;

import nicebank.Teller;

/**
 * Created by liudi on 5/1/15.
 */
public interface AtmInterface extends Teller {
    void type(int amount);
    boolean isDisplaying(String message);
}
