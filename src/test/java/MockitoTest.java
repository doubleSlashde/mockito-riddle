import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	private TestClass testClassMock;

	private TestClassDelegate classUnderTest;

	@Before
	public void before() {
		classUnderTest = new TestClassDelegate(testClassMock);
	}

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

	/**
	 * Class that uses a dependency and delegates some calls to methods in the dependency.
	 */
	public static class TestClassDelegate {

		private final TestClass testClass;

		public TestClassDelegate(final TestClass testClass) {
			this.testClass = testClass;
		}

		public String delegateToDoSomething() {
			return testClass.doSomething();
		}

		public String doSomethingDirectly() {
			return "doSomethingDirectly";
		}
	}

	/**
	 * Dependency that is mocked.
	 */
	public static class TestClass {

		public String doSomething() {
			return "doSomething";
		}

	}
}
