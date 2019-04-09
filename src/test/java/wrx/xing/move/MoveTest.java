package wrx.xing.move;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-10 10:57
 */
public class MoveTest {
	private List<Student> students = new ArrayList<Student>(){{
		add(new Student(1L,"wrx",26,183));
		add(new Student(2L,"bob",28,178));
		add(new Student(3L,"whs",51,172));
		add(new Student(4L,"wzy",24,168));
		add(new Student(5L,"sq",46,160));
	}};

	@Test
	public void move(){
		System.out.println("-----下移前------");
		System.out.println(students);
		down(3L);
//		up(1L);

		System.out.println("-----下移后------");
		System.out.println(students);
	}

	private void down(Long id){
		int currentIndex = -1;
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (Objects.equals(id,student.getId())) {
				currentIndex = i;
			}
		}

		if (currentIndex == -1) {
			System.out.println("参数错误");
			return;
		}

		int nextIndex = currentIndex + 1;

		if (nextIndex > students.size() - 1) {
			System.out.println("已经置底了");
			return;
		}

		Student current = students.get(currentIndex);
		Student next = students.get(nextIndex);

		int height = current.getHeight();
		current.setHeight(next.getHeight());
		next.setHeight(height);

//		students.set(currentIndex,next);
//		students.set(nextIndex,current);
		Collections.swap(students,currentIndex,nextIndex);

		if (nextIndex != students.size() - 1) {
			down(next.getId());
		}


	}

	private void up(Long id){
		System.out.println("-----下移前------");
		System.out.println(students);

		int currentIndex = -1;
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (Objects.equals(id,student.getId())) {
				currentIndex = i;
			}
		}

		if (currentIndex == -1) {
			System.out.println("参数错误");
			return;
		}

		int nextIndex = currentIndex - 1;

		if (nextIndex < 0) {
			System.out.println("已经置顶了");
			return;
		}

		Student current = students.get(currentIndex);
		Student next = students.get(nextIndex);

		int height = current.getHeight();
		current.setHeight(next.getHeight());
		next.setHeight(height);

		System.out.println("-----下移后------");
		System.out.println(students);
	}

	private void downAll(Long id){

	}
}
