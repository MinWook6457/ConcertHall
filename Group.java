import java.util.Scanner;
public class Group{
	private Scanner scanner = new Scanner(System.in);
	private char seat;
	private Seat[] seats;
	// seat = S,A,B numb = number of seats
	public Group(char seat,int num){
		this.seat = seat;
		seats = new Seat[num];
		for(int i = 0 ; i < seats.length; i++)
			seats[i] = new Seat();
	}
	
	public boolean reserve() {
		int no;
		String name;
		
		show(); // ���� �¼� ���� ��Ȳ ���
		System.out.print("�̸�>>");
		name = scanner.next();
		System.out.print("��ȣ>>");
		no = scanner.nextInt();
		
		if(no < 1 || no >= seats.length) {
			System.out.println("�¼� ������ ������ϴ�.");
			return false;
		}
		if(seats[no-1].isOccupied()) {
			System.out.println("�̹� ����� �¼��Դϴ�.");
			return false;
		}
		seats[no-1].reserve(name);
		return true;
}
	public boolean cancel() {
		show();
		System.out.println("�̸�>>");
		String name = scanner.next();
		
		if(name != null) {
			for(int i = 0 ; i < seats.length; i++) {
				if(seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("������ �̸��� ã�� �� �����ϴ�.");
		}
		return false;
	}
	
	public void show() {
			System.out.print(seat + ">>");
			for(int i = 0 ; i < seats.length ; i++ ) {
				if(seats[i].isOccupied())
					System.out.print(seats[i].getName());
				else
					System.out.print("---");
				System.out.print(" ");
				
			}
			System.out.println();
	}
}