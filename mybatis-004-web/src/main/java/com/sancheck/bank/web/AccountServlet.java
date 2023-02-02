package com.sancheck.bank.web;

import com.sancheck.bank.exceptions.MoneyNotEnoughException;
import com.sancheck.bank.exceptions.TransferException;
import com.sancheck.bank.service.AccountService;
import com.sancheck.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: fengyuxiang
 * @ClassName: AccountServlet
 * @version: 1.0
 * @description:
 * @create: 2/2/2023
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActon = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            accountService.transfer(fromActno,toActon,money);

            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");

        }

    }
}
