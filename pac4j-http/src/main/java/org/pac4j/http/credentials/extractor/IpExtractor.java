/*
  Copyright 2012 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.pac4j.http.credentials.extractor;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.credentials.extractor.CredentialsExtractor;
import org.pac4j.core.exception.RequiresHttpAction;
import org.pac4j.core.util.CommonHelper;

/**
 * To extract a remote IP address.
 *
 * @author Jerome Leleu
 * @since 1.8.0
 */
public class IpExtractor implements CredentialsExtractor<TokenCredentials> {

    private final String clientName;

    public IpExtractor(final String clientName) {
        this.clientName = clientName;
    }

    public TokenCredentials extract(WebContext context) throws RequiresHttpAction {
        final String ip = context.getRemoteAddr();
        if (ip == null) {
            return null;
        }

        return new TokenCredentials(ip, clientName);
    }

    @Override
    public String toString() {
        return CommonHelper.toString(this.getClass(), "clientName", this.clientName);
    }
}
