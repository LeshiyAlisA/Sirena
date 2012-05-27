public class SE100 extends PriborObject implements Protokol {
	
	
	public boolean receivePacket(AnswerPacket bi){
		System.out.println("SE100 RP");
		super.receivePacket(bi);
		return true;
	}

	
	
}
