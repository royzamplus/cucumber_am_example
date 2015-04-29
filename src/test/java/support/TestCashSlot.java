package support;

import nicebank.CashSlot;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by liudi on 4/29/15.
 */
@Component
@Scope("cucumber-glue")
public class TestCashSlot extends CashSlot {

}
