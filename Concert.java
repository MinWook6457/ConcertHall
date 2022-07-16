import java.util.Scanner;
public class Concert {
	private String hallName;
	private Scanner scanner = new Scanner(System.in);
	private Group[] group = new Group[3]; // S,A,B 좌석
	
	
	public Concert(String hallName) { // Concert 생성자
		this.hallName = hallName;
		group[0] = new Group('S',10); // 좌석그룹, 좌석수
		group[1] = new Group('A',10);
		group[2] = new Group('B',10);
	}
	private void reserve() {
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if(type<1 || type >3) {
			System.out.println("잘못된 좌석 구분입니다.");
			return;
		}
		group[type-1].reserve();
	}
	private void search() {
		for(int i = 0 ; i < group.length; i++) {
			group[i].show();
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");		
	}
	private void cancel() {
		System.out.println("좌석구분 S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if(type<1 || type >3) {
			System.out.println("잘못된 좌석 구분입니다.");
			return;
		}
		group[type-1].cancel();
		
	}
	public void run() {
		System.out.println(hallName + "예약시스템 입니다.");
		int choice = 0; // 사용자가 선택한 기능 1 : 예약 2 : 조회 3 : 취소 4 : 끝내기
		while(choice != 4) { // 끝내기가 아니면 계속해서 반복
			System.out.print("예약: 1, 조회: 2, 취소 3:, 끝내기: 4 >>");
			choice = scanner.nextInt(); 
			
			switch(choice) {
			case 1: // 예약
				reserve(); 
				break;
			case 2: // 조회
				search();
				break;
			case 3: // 취소
				cancel();
				break;
			case 4: // 끝내기
				break;
			default:
				System.out.println("잘못 입력했습니다.");
			} // end of switch
		} // end of while
	} // end of run()
}
