
public class PriborObject extends Pribor implements Protokol {
	
	public boolean receivePacket(AnswerPacket bi){
		System.out.println("PribOb RP");
		super.receivePacket(bi);
		return true;
	}

}
