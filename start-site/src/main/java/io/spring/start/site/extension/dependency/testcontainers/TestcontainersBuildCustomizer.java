/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.start.site.extension.dependency.testcontainers;

import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.spring.build.BuildCustomizer;

/**
 * {@link BuildCustomizer} for Testcontainers that adds a module-specific module if a
 * supported entry is selected.
 *
 * @author Maciej Walkowiak
 * @author Stephane Nicoll
 */
class TestcontainersBuildCustomizer implements BuildCustomizer<Build> {

	private final TestContainerModuleRegistry modulesRegistry;

	TestcontainersBuildCustomizer(TestContainerModuleRegistry modulesRegistry) {
		this.modulesRegistry = modulesRegistry;
	}

	@Override
	public void customize(Build build) {
		this.modulesRegistry.modules().forEach((module) -> module.customize(build));
	}

}
