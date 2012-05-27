
public class Pribor implements Protokol {
	
	public boolean receivePacket(AnswerPacket bi){
		System.out.println("Pribor RP");
		return true;
	}

}
