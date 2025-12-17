public class Media{
  private Srting name;

public Media(String name){
  this.name=name;
}

public String setName(){
  return name;
}


  @Override
  public String toString(){
    return String.format"(
      "Type: %s - Name: %s",
      this.getClass().getSimpleName(),
      getName()
      );
  }
}

