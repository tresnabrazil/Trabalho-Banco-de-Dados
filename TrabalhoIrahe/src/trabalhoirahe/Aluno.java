
package trabalhoirahe;



public class Aluno {
    
   
     private int id;
     private String nome;
     private String curso;
     private String cpf;
     private String turno;
     private String nascimento;
     private String telefone;
     private String rg;
     private String sexo;
     private String status;
     private String cidade;
   
     public Aluno(String nome, String telefone,String cpf, String nascimento, String curso,String turno,String rg,String sexo, String status, String cidade) {
 
        this.nome = nome;
        this.curso = curso;
        this.cpf  = cpf; 
        this.turno = turno;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.rg = rg;
        this.sexo = sexo;
        this.status = status;
        this.cidade = cidade;
    }
   
    public Aluno() {
          
    }
     public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getCurso() {
        return curso;
    }
 
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

   
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
}

