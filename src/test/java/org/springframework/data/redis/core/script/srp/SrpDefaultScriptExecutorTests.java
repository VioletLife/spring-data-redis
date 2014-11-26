/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.core.script.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.data.redis.SettingsUtils;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.srp.SrpConnectionFactory;
import org.springframework.data.redis.core.script.AbstractDefaultScriptExecutorTests;
import org.springframework.data.redis.core.script.DefaultScriptExecutor;

/**
 * Integration test of {@link DefaultScriptExecutor} with SRP
 * 
 * @author Thomas Darimont
 */
public class SrpDefaultScriptExecutorTests extends AbstractDefaultScriptExecutorTests {

	private static SrpConnectionFactory connectionFactory;

	@Before
	public void setup() {
		connectionFactory = new SrpConnectionFactory(SettingsUtils.getHost(), SettingsUtils.getPort());
		connectionFactory.afterPropertiesSet();
	}

	@After
	public void teardown() {

		super.tearDown();

		if (connectionFactory != null) {
			connectionFactory.destroy();
		}
	}

	@Override
	protected RedisConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	@Ignore("transactional execution is currently not supported with SRP")
	@Override
	public void testExecuteTx() {
		// super.testExecuteTx();
	}

	@Ignore("pipelined execution is currently not supported with SRP")
	@Override
	public void testExecutePipelined() {
		// super.testExecutePipelined();
	}
}
