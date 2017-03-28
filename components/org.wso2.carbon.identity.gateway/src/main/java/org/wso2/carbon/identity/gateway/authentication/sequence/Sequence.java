/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.wso2.carbon.identity.gateway.authentication.sequence;

import org.wso2.carbon.identity.gateway.common.model.idp.AuthenticatorConfig;
import org.wso2.carbon.identity.gateway.common.model.sp.AuthenticationStepConfig;
import org.wso2.carbon.identity.gateway.common.model.sp.IdentityProvider;
import org.wso2.carbon.identity.gateway.exception.AuthenticationHandlerException;

import java.io.Serializable;
import java.util.List;

/**
 * Sequence interface should implement to new custom type of sequence to manage
 * the authentication flow in custom way.
 */
public interface Sequence extends Serializable {

    /**
     * Return the IdentityProvider for given step and idpName.
     *
     * @param step Step Number
     * @param identityProviderName Name of the identity provider
     * @return IdentityProvider An identity Provider instance
     * @throws AuthenticationHandlerException AuthenticationHandlerException
     */
    public abstract IdentityProvider getIdentityProvider(int step, String identityProviderName)
            throws AuthenticationHandlerException;

    /**
     * Return List of IdentityProviders to the given step.
     *
     * @param step Step number
     * @return List of Identity Providers
     * @throws AuthenticationHandlerException AuthenticationHandlerException
     */
    public abstract List<IdentityProvider> getIdentityProviders(int step)
            throws AuthenticationHandlerException;


    /**
     * Check whether we have another steps to be authenticate based on current step number.
     *
     * @param currentStep Current Step number
     * @return Returns whether a next step is present or not.
     * @throws AuthenticationHandlerException AuthenticationHandlerException
     */
    public abstract boolean hasNext(int currentStep) throws AuthenticationHandlerException;

    /**
     * Return AuthenticationStepConfig for given step.
     *
     * @param step Step Number
     * @return  Authentication Step Configurations
     */
    public abstract AuthenticationStepConfig getAuthenticationStepConfig(int step);

}
