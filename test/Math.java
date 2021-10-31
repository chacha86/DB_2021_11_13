package test;

public class Math {
	
	// protected : 같은패키지 + 상속관계
	
	private int num1;
	private int num2;
	
	
	public int plus() {
		int result = num1 + num2;
		return result;
	}
	
	public double divide() {
		double result = (double)num1 / num2;
		return result;
	}
	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	public int getNum1() {
		return this.num1;
	}
	
	public int getNum2() {
		return this.num2;
	}
	
	public void setNum2(int num2) {
		
		// 코드 작성.
		// 데이터 검증 가능
		if(num2 == 0) {
			System.out.println("0은 안됩니다.");
			
			this.num2 = 1;
			return;
		}
		
		this.num2 = num2;
	}
	
	
	
}
