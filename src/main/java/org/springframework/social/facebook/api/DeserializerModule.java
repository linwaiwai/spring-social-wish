/*
 * Copyright 2015 the original author or authors.
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
package org.springframework.social.facebook.api;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;

final class DeserializerModule extends SimpleModule {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3085121165591934190L;
	private BeanDeserializerModifier deserializerModifier;

    public DeserializerModule(BeanDeserializerModifier deserializerModifier) {
        super("DeserializerModule", Version.unknownVersion());
        this.deserializerModifier = deserializerModifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.addBeanDeserializerModifier(deserializerModifier);
    }

}