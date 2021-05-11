
package br.senac.sp.yolandasystem.entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private Date datanasc;
    private String email;
    private String endereco;
    private String telefone;
    private String sexo;
    
    
    
    //GET E SET

    public Cliente(int id, String nome, String cpf, Date datanasc, String email, String endereco, String telefone, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.sexo = sexo;
    }
    
    public boolean validarID() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"nmCliente\": \"%s\", \"anCpf\": \"%s\" , \"dtNascimento\": \"%s\" , \"anEmail\": \"%s\" , \"anLogradouro\": \"%s\" , \"anTelefone\": \"%s\" , \"dmSexo\": \"%s\" }", id, nome, cpf, datanasc, email, endereco, telefone, sexo);
    }
}
