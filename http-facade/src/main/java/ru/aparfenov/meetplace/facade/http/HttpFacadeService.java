package ru.aparfenov.meetplace.facade.http;

import ru.aparfenov.meetplace.dao.ejb.MPStorageEjbDAO;
import ru.aparfenov.meetplace.model.MeetPoint;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/** Represents plain RESTful webservice that serves as a facade for HTTP browser requests to
 * meet point storage
 * Created by ArtemParfenov on 21.04.2018.
 */

@WebServlet("/http-facade")
public class HttpFacadeService extends HttpServlet {
    private static final String MP_LIST_JSP_PARAM = "meet-point-list";
    @EJB
    private MPStorageEjbDAO mpStorageDAO;

    /**called for getting the list of MPs or a single MP identified by id*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processSearching(request, response);
    }

    /**called when inserting/deleting the new MP*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("add".equals(action)) {
                try {
                    handleAddition(request);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            }
        }
        response.sendRedirect("http-facade");
    }

    private void processSearching(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MeetPoint> mpList = mpStorageDAO.getMPList();
        if (mpList != null && !mpList.isEmpty()) {
            request.setAttribute(MP_LIST_JSP_PARAM, mpList);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/pages/jsp/meet-point.jsp").forward(request, response);

    }

    private void handleAddition(HttpServletRequest request) {
        String newMPId = request.getParameter("new-meet-point-id");
        long newMPx = Long.valueOf(request.getParameter("new-meet-point-x"));
        long newMPy = Long.valueOf(request.getParameter("new-meet-point-y"));
        MeetPoint newMP = new MeetPoint(newMPId, newMPx, newMPy);
        mpStorageDAO.addMP(newMP);
    }
}
