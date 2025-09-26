package models;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Aluguel {
    private String funcionario;
    private String matricula;
    private Date LocalDateTime;
    private boolean emUso;

    public Aluguel (String funcionario, String matricula, Date LocalDateTime){
        this.funcionario = funcionario;
        this.matricula = matricula;
        this.LocalDateTime = LocalDateTime;
        this.emUso = false;
    }

    public Aluguel(){};

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(Date localDateTime) {
        LocalDateTime = localDateTime;
    }

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }


    @Override
    public String toString() {
        return "Aluguel{" +
                "funcionario='" + funcionario + '\'' +
                ", matricula='" + matricula + '\'' +
                ", LocalDateTime='" + LocalDateTime + '\'' +
                '}';
    }
}
