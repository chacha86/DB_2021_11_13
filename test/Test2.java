package test;

public class Test2 {

	public static void main(String[] args) {
		
		
		// 객체를 바라보는 관점이 다양해졌다. Cat, Animal -> 다형성
		Animal a1 = new Dog();
		a1.breathe(); // 개 : 헥헥 숨을쉽니다., 고양이 : 고로롱 숨을쉽니다.
		
		
	}
}

class Animal {
	void breathe() {
		System.out.println("숨을 쉬다.");
	}
}

class Dog extends Animal {
	
	void breathe() {
		System.out.println("헥헥 숨을 쉬다.");// 재정의 - 오버라이딩
	}
	
	void bark() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {

	void breathe() {
		System.out.println("고로롱 숨을 쉬다."); // 재정의 - 오버라이딩
	}
	
	void meow() {
		System.out.println("야옹");
	}
}


