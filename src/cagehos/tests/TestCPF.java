package cagehos.tests;

import cagehos.exc.InvalidCPFNumberException;
import cagehos.lib.CPF;

public class TestCPF {
    public static void main(String[] args) {
        try {
            CPF cpf1 = new CPF("02377082050"); // julio
            CPF cpf2 = new CPF("033.594.590-24"); // leo 
            //CPF cpf3 = new CPF("11122233344"); // invalido
            
            System.out.println(cpf1.toString()); // nao formatado
            System.out.println(cpf2.toString(true)); // formatado
            //System.out.println(cpf3.toString());
        } catch (InvalidCPFNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
