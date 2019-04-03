package ch5.persistentData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class RequestDataPersistent extends shared.PersistentBase implements Serializable
{
    protected String hobby;
    protected String hobby2;
    
    public RequestDataPersistent() 
    {
        
    }
    
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getHobby() 
    {
        return hobby;
    } 

    public void setHobby(String hobby) 
    {
        this.hobby = hobby;
    }
    
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getHobby2() 
    {
        return hobby2;
    } 
    
    public void setHobby2(String hobby2) 
    {
        this.hobby2 = hobby2;
    }
    
    protected int daysPerWeek;

    @Min(value=1, message="must be greater than 1, if this is a hobby.")
    @Max(value=7, message="cannot be greater than 7. A week only has 7 days.")
    public int getDaysPerWeek() 
    {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) 
    {
        this.daysPerWeek = daysPerWeek;
    }

}

