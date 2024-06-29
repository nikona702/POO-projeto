package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empregado> empregados;
    private static Empresa instance;
    private Empresa() throws ParseException{
        empregados = new ArrayList<>();
        SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
        empregados.add(new Empregado("Bruno", "123123123", sdf.parse("02/02/2004") , "123123123","123123123"));
        empregados.add(new Empregado("Nikolas", "123123123", sdf.parse("04/07/2004") , "123123123","123123123"));
    }
    public static Empresa getInstance() throws ParseException{
        if (instance == null){
            instance = new Empresa();
        } 
        return instance;
        
    } 
    public void addEmpregado(Empregado emp){
        this.empregados.add(emp);
    }
    public void removeEmpregado(Empregado emp){
        this.empregados.remove(emp);
    }
    
    public List<Empregado> getEmpregados(){
        return empregados;
    }
    public Empregado busca(String nome){
        Empregado p;
        for(Empregado emp : empregados){
            if (emp.getNome().equalsIgnoreCase(nome)){
                return emp;
            }  
        }
        p = null;
        return p;
    } 

}
