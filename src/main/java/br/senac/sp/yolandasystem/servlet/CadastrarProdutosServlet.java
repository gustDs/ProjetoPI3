package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import br.senac.sp.yolandasystem.entidade.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //PASSO 1 - RECUPERAR OS PARAMETROS
        String filial = request.getParameter("filial");
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String modelo = request.getParameter("modelo");

        String precostr = request.getParameter("preco");
        Double preco = Double.valueOf(precostr);

        String qtdstr = request.getParameter("quantidade");
        Integer quantidade = Integer.valueOf(qtdstr);

        //PASSO 2 - INSERIR O CLIENTE NO BD
        Produtos produtos = new Produtos(0, filial, nome, categoria, modelo, preco, quantidade);
        boolean ok = ProdutosDAO.cadastrar(produtos);
        response.setStatus(ok ? 200 : 500);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);

        Produtos produto = ProdutosDAO.getProduto(id);
        request.setAttribute("produto", produto);
        //response.getWriter().write(produto.toString());
        request.getRequestDispatcher("/produtos/cadastrar.jsp").forward(request, response);
    }

}
