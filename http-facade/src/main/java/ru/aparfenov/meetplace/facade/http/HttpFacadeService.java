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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Represents plain RESTful webservice that serves as a facade for HTTP browser requests to
 * meet point storage
 * Created by ArtemParfenov on 21.04.2018.
 */

@WebServlet("/http-facade")
public class HttpFacadeService extends HttpServlet {
    private static final String MP_LIST_JSP_PARAM = "meet-point-list";
    public static final String ADD_ACTION = "add";
    public static final String SEARCH_ACTION = "search";
    @EJB
    private MPStorageEjbDAO mpStorageDAO;

    /**called for getting the list of MPs or a single MP identified by id*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processInitialLoading(request, response);
    }

    /**called when inserting/deleting the new MP*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (ADD_ACTION.equals(action)) {
                try {
                    handleAddition(request);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            } else if (SEARCH_ACTION.equals(action)) {
                try {
                    handleSearching(request, response);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            }
        }
        response.sendRedirect("http-facade");
    }

    private void processInitialLoading(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

    private void handleSearching(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> params = new HashMap<>();
        List<MeetPoint> mpList = mpStorageDAO.getMPListByParams(params);
        if (mpList != null && !mpList.isEmpty()) {
            request.setAttribute(MP_LIST_JSP_PARAM, mpList);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/pages/jsp/meet-point.jsp").forward(request, response);
    }
}
