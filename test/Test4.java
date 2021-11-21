package test;

public class Test4 {

	public static void main(String[] args) {
		자동차 a자동차 = new 자동차();
		
		a자동차.run();
		a자동차.stop();
	}

}

class 자동차 {
	int speed = 100;
	
	엔진 a엔진 = new 엔진();
	
	public void run() {
		a엔진.useEngine(speed);
	}
	
	public void stop() {
		a엔진.stopEngine();
	}
}

class 엔진 {
	public void useEngine(int speed) {
		System.out.println(speed + "km 자동차가 달립니다.");
	}
	public void stopEngine() {
		System.out.println("자동차가 멈춥니다.");
	}
}

