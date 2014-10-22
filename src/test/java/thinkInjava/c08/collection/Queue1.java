package thinkInjava.c08.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {

	/**
	 * @param args
	 * @author JavaAlpha
	 *         Info 测试队列
	 */
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1");// 插入一个元素
		queue.offer("2");
		queue.offer("3");
		// 打印元素个数
		System.out.println("queue.size()=" + queue.size());
		// 遍历打印所有的元素,安装插入是顺序打印
		for (String string : queue) {
			System.out.println(string);
		}
	}
}
