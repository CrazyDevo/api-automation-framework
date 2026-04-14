package runner;


import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("tests")
@IncludeTags("smoke") // change dynamically


public class TestRunner {
}