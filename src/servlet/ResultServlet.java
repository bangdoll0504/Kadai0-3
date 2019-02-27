package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansdomain.LoginUserBean;
import daodto.ShoppingDao;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

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

	  // ログインid取得
	  String user_id = ((LoginUserBean) request.getSession().getAttribute("login_user_bean")).getId();

	  // 購入確認画面(purchase_confirm.jsp)にセットしていた値を取得(hiddenパラメータ)
	  String item_id = request.getParameter("item_id");
	  int purchased_num = Integer.parseInt(request.getParameter("item_quantity"));

	  ShoppingDao dao = null;
	  try {
	      /*
	       * 商品ID と購入数を元にDBを更新
	       * 対象の商品在庫をマイナスにする
	       */
	      dao = new ShoppingDao();
	      dao.updateItem(item_id, purchased_num);
	      dao.updateHistory(user_id, item_id, purchased_num);
	  } catch (SQLException sqle) {
	      sqle.printStackTrace();
	  } finally {
	      if (dao != null) {
	          dao.close();
	      }
	  }
	  // 商品結果画面に移動
	  RequestDispatcher rd = request.getRequestDispatcher("./result.jsp");
	  rd.forward(request, response);

	  }
}
