package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ZooAnimals;
import model.ZooKeeper;
import model.ZooListDetails;

/**
 * Servlet implementation class EditZooListDetailsServlet
 */
@WebServlet("/editZooListDetailsServlet")
public class EditZooListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditZooListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				ZooListDetailsHelper dao = new ZooListDetailsHelper();
				ZooAnimalHelper lih = new ZooAnimalHelper();
				ZooKeeperHelper sh = new ZooKeeperHelper();
				
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ZooListDetails listToUpdate = dao.searchForListDetailsById(tempId);

				String newListName = request.getParameter("listName");

				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				
				String keeperName = request.getParameter("keeperName");
				//find our add the new shopper
				ZooKeeper newKeeper = sh.findZooKeeper(keeperName);

				LocalDate ld;
				try {
					ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				} catch (NumberFormatException ex) {
					ld = LocalDate.now();
				}

				try {
					//items are selected in list to add
					String[] selectedAnimals = request.getParameterValues("allAnimalsToAdd");
					List<ZooAnimals> selectedAnimalsInList = new ArrayList<ZooAnimals>();

					for (int i = 0; i < selectedAnimals.length; i++) {
						System.out.println(selectedAnimals[i]);
						ZooAnimals c = lih.searchForAnimalById(Integer.parseInt(selectedAnimals[i]));
						selectedAnimalsInList.add(c);

					}
					listToUpdate.setListOfAnimals(selectedAnimalsInList);
				} catch (NullPointerException ex) {
					// no items selected in list - set to an empty list
					List<ZooAnimals> selectedAnimalsInList = new ArrayList<ZooAnimals>();
					listToUpdate.setListOfAnimals(selectedAnimalsInList);
				}

				listToUpdate.setListName(newListName);
				listToUpdate.setLastShift(ld);
				listToUpdate.setZooKeeper(newKeeper);

				dao.updateList(listToUpdate);

				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
	}
