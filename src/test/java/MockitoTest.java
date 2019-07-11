import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	@Mock
	private TestClass testClassMock;

	@InjectMocks
	private TestClassDelegate classUnderTest;

	@Test
	public final void test1() {
		Mockito.when(classUnderTest.delegateToDoSomething()).thenReturn("mock"); // 1.1
		assertThat(classUnderTest.delegateToDoSomething()).isEqualTo("mock"); // 1.2
	}

	@Test
	public final void test2() {
		Mockito.when(classUnderTest.doSomethingDirectly()).thenReturn("mock"); // 2.1
		assertThat(classUnderTest.doSomethingDirectly()).isEqualTo("doSomethingDirectly"); // 2.2
	}

	@Test
	public final void test3() {
		Mockito.when(classUnderTest.doSomethingDirectly()).thenReturn("mock"); // 3.1
		assertThat(classUnderTest.doSomethingDirectly()).isEqualTo("mock"); // 3.2
	}

	@Test
	public final void test4() {
		Mockito.when(testClassMock.doSomething()).thenReturn("mock"); // 4.1
		assertThat(classUnderTest.delegateToDoSomething()).isEqualTo("mock"); // 4.2
	}



}
