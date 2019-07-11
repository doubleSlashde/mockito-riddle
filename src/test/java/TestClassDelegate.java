/**
 * Class that uses a dependency and delegates some calls to methods in the dependency.
 */
public class TestClassDelegate {

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