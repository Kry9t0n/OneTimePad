import java.security.SecureRandom;

public class OneTimePad {
	private String message;
	private byte[] pad;
	private byte[] messageBytes;
	private byte[] encrypted;
	private byte[] decrypted;
	
	
	public OneTimePad(String mesage) {
		this.message = mesage;
		this.messageBytes = this.message.getBytes();
		this.pad = new byte[this.messageBytes.length];
		this.encrypted = new byte[this.messageBytes.length];
		this.decrypted = new byte[this.messageBytes.length];
		setRandomPad();
	}
	
	private void setRandomPad() {
		new SecureRandom().nextBytes(pad);
	}
	
	public void printPAD() {
		for(byte i : pad) {
			System.out.println(i);
		}
		System.out.println("PAD");
		for(byte j : messageBytes) {
			System.out.println(j);
		}
	}
	
	public void encrypt() {
		for(int i = 0; i < encrypted.length; i++) {
			encrypted[i] = (byte) (messageBytes[i]^pad[i]);
		}
		for(byte j : encrypted) {
			System.out.print(j);
		}
		System.out.println();
		System.out.println(new String(encrypted));
	}
	
	public void decrypt() {
		for(int i = 0; i < decrypted.length; i++) {
			decrypted[i] = (byte) (encrypted[i]^pad[i]);
		}
		for(byte j : decrypted) {
			System.out.print(j);
		}
		System.out.println();
		System.out.println(new String(decrypted));
	}
	
	public static void main(String[] args0) {
		OneTimePad ot = new OneTimePad("hello my name is max mustermann");
		ot.encrypt();
		ot.decrypt();
		
	}
	
	

}
