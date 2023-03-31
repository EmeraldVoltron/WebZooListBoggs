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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ZooAnimalHelper lih = new ZooAnimalHelper();
		String listName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String keeperName = request.getParameter("keeperName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allAnimalsToAdd");
		List<ZooAnimals> selectedItemsInList = new ArrayList<ZooAnimals>();
		
		if(selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				ZooAnimals c = lih.searchForAnimalById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		ZooKeeper keeper = new ZooKeeper(keeperName);
		
		ZooListDetails sld = new ZooListDetails(listName, ld, keeper);
		
		sld.setListOfAnimals(selectedItemsInList);
		
		ZooListDetailsHelper slh = new ZooListDetailsHelper();
		slh.insertNewZooListDetails(sld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
