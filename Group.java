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
		
		show(); // 현재 좌석 예약 현황 출력
		System.out.print("이름>>");
		name = scanner.next();
		System.out.print("번호>>");
		no = scanner.nextInt();
		
		if(no < 1 || no >= seats.length) {
			System.out.println("좌석 범위를 벗어났습니다.");
			return false;
		}
		if(seats[no-1].isOccupied()) {
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		seats[no-1].reserve(name);
		return true;
}
	public boolean cancel() {
		show();
		System.out.println("이름>>");
		String name = scanner.next();
		
		if(name != null) {
			for(int i = 0 ; i < seats.length; i++) {
				if(seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("예약자 이름을 찾을 수 없습니다.");
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