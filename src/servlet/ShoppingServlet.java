package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beansdomain.HistoryBean;
import beansdomain.ItemBean;
import beansdomain.LoginUserBean;
import daodto.Shopping;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * Handles the HTTP GET method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        RequestDispatcher rd;

        /*
         * 履歴を表示する処理
         */
        if (session.getAttribute("login_state").equals("login")) {
            String para = request.getParameter("submit");

            if (para.equals("history")) {
                Shopping shopping = new Shopping();

                // session からユーザID を取得
                String user_id = ((LoginUserBean) session.getAttribute("login_user_bean")).getId();

                //  購入履歴を取得
                ArrayList<HistoryBean> history_beans = shopping.getHistory(user_id);

                // リクエストスコープにセットして画面移動
                request.setAttribute("history", history_beans);
                rd = request.getRequestDispatcher("./history.jsp");
                rd.forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP POST method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 商品一覧を取得
        Shopping shopping = new Shopping();
        ArrayList<ItemBean> item_list = shopping.getItem();
        System.out.println("item_list" + item_list);

        // 商品一覧をリクエストスコープの属性にセット
        request.setAttribute("itemList", item_list);

        // 商品一覧画面に移動
        RequestDispatcher rd = request.getRequestDispatcher("./itemList.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
