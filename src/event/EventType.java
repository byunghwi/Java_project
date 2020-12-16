package event;

public enum EventType {
	TWOPLUSONE("2+1"),
	ONEPLUSONE("1+1"),
	TENPERCENT("10% 할인"),
	TWENTYPERCENT("20% 할인");
	
 private final String value;
    
 	EventType(String value){
        this.value = value;        
    }
    
    public String getValue(){
        return value;
    }
}
