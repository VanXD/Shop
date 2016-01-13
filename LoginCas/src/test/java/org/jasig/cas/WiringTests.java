package org.jasig.cas;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Unit test to verify Spring context wiring.
 *
 * @author Middleware Services
 */
public class WiringTests {
    private XmlWebApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new XmlWebApplicationContext();
        applicationContext.setConfigLocations(new String[]{
                "file:src/main/webapp/WEB-INF/cas-servlet.xml",
                "file:src/main/webapp/WEB-INF/deployerConfigContext.xml",
        "file:src/main/webapp/WEB-INF/spring-configuration/*.xml"});
        applicationContext.setServletContext(new MockServletContext(new ResourceLoader() {
            @Override
            public Resource getResource(final String location) {
                return new FileSystemResource("src/main/webapp" + location);
            }

            @Override
            public ClassLoader getClassLoader() {
                return getClassLoader();
            }
        }));
        applicationContext.refresh();
    }

    @Test
    public void testWiring() throws Exception {
        assertTrue(applicationContext.getBeanDefinitionCount() > 0);
    }
}
