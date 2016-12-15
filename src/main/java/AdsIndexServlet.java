import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")

public class AdsIndexServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ListAdsDao ads = new ListAdsDao();
        List<Ad> ListAds = ads.all();
        request.setAttribute("ads", ListAds);
        request.getRequestDispatcher("ads/index.jsp").forward(request, response);

    }
}
