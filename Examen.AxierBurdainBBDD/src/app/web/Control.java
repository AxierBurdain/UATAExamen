package app.web;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.modelo.Personas;
import app.persistencia.AccesoPersonas;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("entra en el doGet");

		String opcion = request.getParameter("op");
		System.out.println("opcion" + opcion);

		switch (opcion) {

		case "1":
			System.out.println("entra en el switch 1");
			AccesoPersonas ap1 = new AccesoPersonas();
			Personas p1 = new Personas(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"),
					request.getParameter("email"), request.getParameter("telefono"));
			try {
				ap1.cambiarDatos(p1);
				PrintWriter salida = response.getWriter();
				salida.println("Los nuevos datos son: " + p1.toString());
				salida.println("<br>");
				salida.println("<br>");
				salida.println("<a href=index.html>VOLVER</a>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "2":
			System.out.println("entra en el switch 2");
			AccesoPersonas ap2 = new AccesoPersonas();
			try {

				int id = Integer.parseInt(request.getParameter("id"));
				PrintWriter salida = response.getWriter();
				salida.println("Los datos del contacto son: " + ap2.consultarContacto(id));
				salida.println("<br>");
				salida.println("<br>");
				salida.println("<br>");
				salida.println("<a href=index.html>VOLVER</a>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "3":
			System.out.println("entra en el switch 3");
			AccesoPersonas ap3 = new AccesoPersonas();
			try {
				ap3.borrarContacto(Integer.parseInt(request.getParameter("id")));
				PrintWriter salida = response.getWriter();
				salida.println("El contacto " + Integer.parseInt(request.getParameter("id") + " se ha eliminado"));
				salida.println("<br>");
				salida.println("<a href=index.html>VOLVER</a>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "4":
			System.out.println("entra en el switch 4");
			AccesoPersonas ap4 = new AccesoPersonas();
			try {
				PrintWriter salida = response.getWriter();
				salida.println("Agenda completa:" + ap4.consultarTodos());

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter salida = response.getWriter();
			salida.println("<br>");
			salida.println("<br>");
			salida.println("<br>");
			salida.println("<a href=index.html>VOLVER</a>");
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("entra en el post");

		Personas p1 = new Personas(request.getParameter("nombre"), request.getParameter("email"),
				request.getParameter("telefono"));

		System.out.println(p1.toString());

		HttpSession hs1 = request.getSession();
		if (request.getParameter("nombre") != null) {

			hs1.setAttribute("nombre", p1);
			hs1.setAttribute("email", p1);
			hs1.setAttribute("telefono", p1);

			AccesoPersonas ap1 = new AccesoPersonas();

			try {
				ap1.altaContacto(p1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			PrintWriter salida = response.getWriter();
			salida.println("<a href=index.html>VOLVER</a>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter salida = response.getWriter();
			salida.println("<h3>No se han encontrado los datos</h3>");
			salida.println("<br>");
			salida.println("<a href=index.html>VOLVER</a>");
			salida.println("<body>");
			salida.println("</html>");
			salida.close();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		System.out.println("sale de control");
		rd.forward(request, response);

	}
}
