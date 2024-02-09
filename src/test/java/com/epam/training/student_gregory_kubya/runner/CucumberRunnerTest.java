package com.epam.training.student_gregory_kubya.runner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
//@SelectClasspathResource("src/test/resources/features/CartFunctionality.feature")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.student_gregory_kubya.steps")
public class CucumberRunnerTest {

}
