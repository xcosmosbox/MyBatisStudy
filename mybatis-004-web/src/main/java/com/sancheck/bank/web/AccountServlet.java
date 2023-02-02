package com.sancheck.bank.web;

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActon = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));



    }
}
