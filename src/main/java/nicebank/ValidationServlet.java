package nicebank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liudi on 4/30/15.
 */
public class ValidationServlet extends HttpServlet {
    private CashSlot cashSlot;

    public ValidationServlet(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);

        int amount = Integer.parseInt(req.getParameter("amount"));

        if (cashSlot.canDispense(amount)) {
            resp.getWriter().println("{\"content\":\"\"}");
        } else {
            resp.getWriter().println("{\"content\":\"Insufficient ATM funds\"}");
        }
    }
}
