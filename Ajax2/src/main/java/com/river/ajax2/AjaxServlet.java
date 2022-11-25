package com.river.ajax2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName AjaxServlet
 * Date 2022/11/25 15:02
 * Author river
 */

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        String val = req.getParameter("val");

        // 模拟查询
        List<String> list1 = new ArrayList<>();
        list1.add("艾尔登法环");
        list1.add("黑暗之魂");
        list1.add("塞尔达：旷野之息");

        List<String> list2 = new ArrayList<>();
        list2.add("CoD:NMW2");
        list2.add("Battlefield2042");
        list2.add("Apex:Legends");

        List<String> list3 = new ArrayList<>();
        list3.add("极限国度");
        list3.add("FIFA2022");
        list3.add("NBA2K");

        Map<String, List<String>> map = new HashMap<>();
        map.put("1", list1);
        map.put("2", list2);
        map.put("3", list3);

        List<String> returnList = map.get(val);

        resp.getWriter().print(returnList);

    }
}
