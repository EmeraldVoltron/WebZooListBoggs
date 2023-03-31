package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ZooAnimals;

/**
 * Servlet implementation class EditZooAnimalServlet
 */
@WebServlet("/editZooAnimalServlet")
public class EditZooAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditZooAnimalServlet() {
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
				ZooAnimalHelper dao = new ZooAnimalHelper();
				String species = request.getParameter("species");
				String name = request.getParameter("name");
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				
				ZooAnimals itemToUpdate = dao.searchForAnimalById(tempId);
				itemToUpdate.setSpecies(species);
				itemToUpdate.setName(name);
				
				dao.updateAnimal(itemToUpdate);
				
				getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
			}
}
