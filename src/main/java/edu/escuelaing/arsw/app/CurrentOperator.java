package edu.escuelaing.arsw.app;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentOperator {
   
    private String currentop = "+";

    public CurrentOperator(){}

    public String getCurrentValue(){
        return currentop;
    }

    public void setCurrentValue(String newOp){
        currentop = newOp;
    }
    
}