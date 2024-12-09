import java.util.ArrayList;
import java.util.List;

class Disciplina {
    String nome;

    public Disciplina(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return nome;
    }
}

class Professor {
    String nome;
    List<Disciplina> disciplinas;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return nome + " - Disciplinas: " + disciplinas;
    }
}

class Departamento {
    String nome;
    List<Professor> professores;

    public Departamento(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    @Override
    public String toString() {
        return nome + " - Professores: " + professores;
    }
}


class Universidade {
    String nome;
    List<Departamento> departamentos;

    public Universidade(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    public void adicionarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    @Override
    public String toString() {
        return "Universidade: " + nome + "\nDepartamentos: " + departamentos;
    }
}

class Main {
    public static void main(String[] args) {
        Disciplina quimica = new Disciplina("Química");
        Professor professor = new Professor("Ana");
        professor.adicionarDisciplina(quimica);

        Departamento exatas = new Departamento("Departamento de Ciências Exatas");
        exatas.adicionarProfessor(professor);

        Universidade maisPraTi = new Universidade("Universidade Federal Rural do Rio de Janeiro");
        maisPraTi.adicionarDepartamento(exatas);

        System.out.println(maisPraTi);
    }
}