package edu.escuelaing.arsw.app;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentValue {
   
    private double currentval = 0;

    public CurrentValue(){}

    public double getCurrentValue(){
        return currentval;
    }

    public void setCurrentValue(double newValue){
        currentval = newValue;
    }
    
}
