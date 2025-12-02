public class Contact{
  private String name;
  private String phoneNumber;
  private NumberType type;

  public Contact(String name, String phoneNumber, NumberType type){
    this.name=name;
    this.phoneNumber=phoneNumber;
    this.type=type;
  }
  
public String getName(){
  return name;
}
  public String getPhoneNumber()}
    return phoneNumber;
}

public Syring getType(){
  return type;
}


@Override
  public String toString(){
  return name+" -> "+phoneNumber+" ("+type+")";
}
