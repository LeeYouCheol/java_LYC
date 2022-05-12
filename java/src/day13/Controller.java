package day13;

public interface Controller {
	int MIN = 1;
	void run();// public abstract가 앞에 자동으로 붙는다.
	void stop();
	void print();
	default void test() {}
}
