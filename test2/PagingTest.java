package test2;

import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {
	
		int currentPageNo = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			
			// 1 / 5 - 1
			// 2 / 5 - 1
			// 3 / 5 - 1
			// 4 / 5 - 1
			// 5 / 5 - 1
			
			// 6 / 5 - 2
			// 7 / 5 - 2
			// 10 / 5 - 2
			
			// 올림(현재페이지 / 한블럭당페이지개수)
			int currentBlockNo = (int)Math.ceil((double)currentPageNo / 5);
			
			int startPageNoInBlock = 5 * (currentBlockNo - 1) + 1;  
			int endPageNoInBlock = startPageNoInBlock + 4;
			
			// 2. 현재페이지가 5 > 6으로 바뀔 때 페이지를 6 7 8 9 10
			for(int i = startPageNoInBlock; i <= endPageNoInBlock; i++) {
				if(i == currentPageNo) {
					System.out.print("[" + i + "] ");				
				} else {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			System.out.println("페이징 명령어를 입력해주세요 ((prev : 이전,  next : 다음,  go : 선택,  back : 뒤로가기):");
			String pageCmd = sc.nextLine();
			
			if(pageCmd.equals("prev")) {
				currentPageNo--;
			} else if(pageCmd.equals("next")) {
				currentPageNo++;
			} else if(pageCmd.equals("go")) {
				System.out.println("몇번 페이지로 이동하시겠습니까 : ");
				currentPageNo = Integer.parseInt(sc.nextLine());
			}
		}
		
		
	}

}
