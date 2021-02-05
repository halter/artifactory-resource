/*
 * Copyright 2017-2019 the original author or authors.
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

package io.spring.concourse.artifactoryresource.command.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * The source payload containing shared configuration.
 *
 * @author Phillip Webb
 * @author Madhura Bhave
 * @author Gabriel Petrovay
 */
public class Source {

	private final String uri;

	private final String username;

	private final String password;

	@JsonProperty("build_name")
	private final String buildName;

	@JsonProperty("proxy_host")
	private final String proxyHost;

	@JsonProperty("proxy_port")
	private final int proxyPort;

	@JsonCreator
	public Source(@JsonProperty("uri") String uri, @JsonProperty("username") String username,
			@JsonProperty("password") String password, @JsonProperty("build_name") String buildName,
			@JsonProperty("proxy_host") String proxyHost, @JsonProperty("proxy_port") int proxyPort) {
		Assert.hasText(uri, "URI must not be empty");
		Assert.hasText(buildName, "Build Name must not be empty");
		this.uri = uri;
		this.username = username;
		this.password = password;
		this.buildName = buildName;
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
	}

	public String getUri() {
		return this.uri;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getBuildName() {
		return this.buildName;
	}

	public String getProxyHost() {
		return this.proxyHost;
	}

	public int getProxyPort() {
		return this.proxyPort;
	}

	@Override
	public String toString() {
		ToStringCreator creator = new ToStringCreator(this).append("uri", this.uri).append("buildName", this.buildName);
		if (StringUtils.hasText(this.proxyHost)) {
			creator.append("proxyHost", this.proxyHost);
			creator.append("proxyPort", this.proxyPort);
		}
		return creator.toString();
	}

}
