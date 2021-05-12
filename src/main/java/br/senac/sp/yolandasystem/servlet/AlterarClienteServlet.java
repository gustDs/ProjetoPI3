package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
import br.senac.sp.yolandasystem.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarClienteServlet extends HttpServlet {

    //CARREGAR INFORMAÇÕES DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);

        Cliente cliente = ClienteDAO.getCliente(id);

        System.out.println("cliente " + cliente.getClass().getSimpleName());
        request.setAttribute("cliente", cliente);
        response.getWriter().write(cliente.toString());
        // request.getRequestDispatcher("/clientes/cadastrar.jsp").forward(request, response);

    }

    //ATUALIZAR O BD COM AS NOVAS INFORMAÇÕES 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);

        String nome = request.getParameter("nmCliente");
        String cpf = request.getParameter("anCpf");
        String datanasc = request.getParameter("dtNascimento");

        Date date = Date.valueOf(datanasc);

        String email = request.getParameter("anEmail");
        String endereco = request.getParameter("anLogradouro");
        String telefone = request.getParameter("anTelefone");
        String sexo = request.getParameter("dmSexo");

        Cliente cliente = new Cliente(id, nome, cpf, date, email, endereco, telefone, sexo);
        boolean ok = ClienteDAO.atualizar(cliente);
        response.setStatus(ok ? 200 : 500);

    }

}
