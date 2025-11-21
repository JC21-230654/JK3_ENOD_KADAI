package gyutan;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apiClass.GetClu;

@WebServlet("/Gyutan2025")
public class Gyutan2025 extends HttpServlet {
	private static final long serialVersionUID = 1L;
            
    public Gyutan2025() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("doGet method.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 受取ったパラメータの文字エンコードをUTF-8にする
		request.setCharacterEncoding("UTF-8");

		// パラメータを取得する
		String param = request.getParameter("param");
		// パラメータがnullなら、変数paramを""にする
		if(Objects.isNull(param)) {
			param="";
		}
		
		// paramを送ってCLUからデータを取得する
		String detected = GetClu.getLanguageText(param);
		
		// 結果（スキーム）をコンソールに表示
		System.out.println(detected);
		
		// 結果（スキーム）によってページを遷移させる
		if ("ABOUT".equals(detected)) {
			request.getRequestDispatcher("store_info.html").forward(request, response);
		} else if ("MENU".equals(detected)) {
			request.getRequestDispatcher("menu.html").forward(request, response);
		} else if ("SHOP".equals(detected)) {
			request.getRequestDispatcher("online_store.html").forward(request, response);
		} else if ("HISTORY".equals(detected)) {
			request.getRequestDispatcher("history.html").forward(request, response);
		} else {
			// いずれのインテントにも一致しない場合はトップページに遷移
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}
}
