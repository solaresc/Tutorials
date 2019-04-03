package ch3.defaultValidate;

public class RequestDataDefault 
{
    protected String hobby;
    protected String hobby2;

    public void setHobby(String hobby) 
    {
        this.hobby = hobby;
    }
    
    public String getHobby() 
    {
    if (isValidHobby()) {
      return hobby;
    }
    return "No first hobby";
    }
    
    public void setHobby2(String hobby2) 
    {
        this.hobby2 = hobby2;
    }
    
    public String getHobby2() 
    {
    if (isValidHobby()) {
      return hobby2;
    }
    return "No second hobby";
    }
    
    public boolean isValidHobby() {
    return hobby != null && !hobby.trim().equals("");
  }
  
  public boolean isValidHobby2() {
    return hobby2 != null && !hobby2.trim().equals("");
  }  
}

