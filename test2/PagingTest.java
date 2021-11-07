package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1;
		int itemCountPerPage = 3;
		int pageCountPerBlock = 5;
		
		
		ArrayList<String> datas = new ArrayList<>(); 
		
		for(int i = 1; i <= 26; i++) {
			datas.add(i + ".data");
		}
		
		int totalItemCount = datas.size();
		int firstPageNo = 1; // 가장 첫번째 페이지 번호
		int lastPageNo = (int)Math.ceil((double)totalItemCount / itemCountPerPage); // 가장 마지막 페이지 번호
		
		while(true) {
			
			int currentBlockNo = (int)Math.ceil((double)currentPageNo / pageCountPerBlock);
			int startPageNoInBlock = pageCountPerBlock * (currentBlockNo - 1) + 1;  
			int endPageNoInBlock = startPageNoInBlock + pageCountPerBlock - 1;
			int startIndex = itemCountPerPage * (currentPageNo - 1);
			int endIndex = startIndex + itemCountPerPage;
			
			if(startPageNoInBlock < firstPageNo) {
				startPageNoInBlock = firstPageNo;
			}
			
			if(endPageNoInBlock > lastPageNo) {
				endPageNoInBlock = lastPageNo;
			}
			
			if(endIndex > totalItemCount) {
				endIndex = totalItemCount;
			}
			
			if(startIndex < 0) {
				startIndex = 0;
			}
			
			
			for(int i = startIndex; i < endIndex; i++) {
				System.out.println(datas.get(i));
			}

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
				if(currentPageNo > firstPageNo) {
					currentPageNo--;					
				} else {
					System.out.println("첫번째 페이지입니다.");
				}
			} else if(pageCmd.equals("next")) {
				if(currentPageNo < lastPageNo) {
					currentPageNo++;					
				} else {
					System.out.println("마지막 페이지입니다.");
				}
			} else if(pageCmd.equals("go")) {
				
				
				System.out.println("몇번 페이지로 이동하시겠습니까 : ");
				int selectedPageNo = Integer.parseInt(sc.nextLine());
				
				if(selectedPageNo >= firstPageNo && selectedPageNo <= lastPageNo) {
					currentPageNo = selectedPageNo; 					
				} else {
					System.out.println("잘못된 페이지입니다.");
				}
				
				
			}
		}
	}
}
