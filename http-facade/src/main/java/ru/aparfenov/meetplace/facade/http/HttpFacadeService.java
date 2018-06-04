package ru.aparfenov.meetplace.facade.http;

import ru.aparfenov.meetplace.dao.db.PreparedStatementParam;
import ru.aparfenov.meetplace.dao.db.PreparedStatementParamType;
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
    private static final String MP_COMMON_LIST_JSP_PARAM = "meet-point-list";
    private static final String MP_FOUND_LIST_JSP_PARAM = "meet-point-found-list";
    public static final String ADD_ACTION = "add";
    public static final String SEARCH_ACTION = "search";
    public static final String DELETE_BY_MP_ID_ACTION = "delete";
    public static final String DELETE_BY_MP_ID_PARAM = "delete-by-mp-id";
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
//        String deleteByMpId = request.getParameter(DELETE_BY_MP_ID_ACTION);
        if (ADD_ACTION.equals(action)) {
            try {
                handleAddition(request);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
            response.sendRedirect("http-facade");
        } else if (SEARCH_ACTION.equals(action)) {
            try {
                handleSearching(request, response);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        } else if (DELETE_BY_MP_ID_ACTION.equals(action)) {
            handleDeletion(request);
            response.sendRedirect("http-facade");
        }
    }

    private void processInitialLoading(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MeetPoint> mpList = mpStorageDAO.getMPList();
        if (mpList != null && !mpList.isEmpty()) {
            request.setAttribute(MP_COMMON_LIST_JSP_PARAM, mpList);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/pages/jsp/meet-point.jsp").forward(request, response);

    }

    private void handleAddition(HttpServletRequest request) {
        String newMPId = request.getParameter("new-meet-point-id");
        double newMPx = Double.valueOf(request.getParameter("new-meet-point-x"));
        double newMPy = Double.valueOf(request.getParameter("new-meet-point-y"));
        MeetPoint newMP = new MeetPoint(newMPId, newMPx, newMPy);
        mpStorageDAO.addMP(newMP);
    }

    /**processes meet point searching according to user defined parameters*/
    private void handleSearching(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, PreparedStatementParam> params = new HashMap<>();
        String id = null;
        String mpX = null;
        String mpY = null;
        if (((id = request.getParameter("search-param-mp-id")) != null) && !id.isEmpty()) {
            //TODO terrible boilerplate - need to refactor
            params.put("id", new PreparedStatementParam().
                    setName("id").
                    setType(PreparedStatementParamType.STRING).
                    setValue(id));
        }
        if (((mpX = request.getParameter("search-param-mp-x")) != null) && !mpX.isEmpty()){
            params.put("x", new PreparedStatementParam().
                    setName("x").
                    setType(PreparedStatementParamType.NUMBER).
                    setValue(Long.valueOf(mpX)));
        }
        if (((mpY = request.getParameter("search-param-mp-y")) != null) && !mpY.isEmpty()) {
            params.put("y", new PreparedStatementParam().
                    setName("y").
                    setType(PreparedStatementParamType.NUMBER).
                    setValue(Long.valueOf(mpY)));
        }
        if (!params.isEmpty()) {
            List<MeetPoint> mpList = mpStorageDAO.getMPListByParams(params);
            if (mpList != null && !mpList.isEmpty()) {
                request.setAttribute(MP_FOUND_LIST_JSP_PARAM, mpList);
            }
            request.getServletContext().getRequestDispatcher("/WEB-INF/pages/jsp/meet-point.jsp").forward(request, response);
        }

    }

    private void handleDeletion(HttpServletRequest request) {
        String id = request.getParameter(DELETE_BY_MP_ID_PARAM);
        mpStorageDAO.deleteMp(id);
    }
}
