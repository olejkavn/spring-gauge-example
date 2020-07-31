import com.thoughtworks.gauge.ClassInitializer;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.StepsConfiguration;

public class RegisterIOC implements ClassInitializer {

    private static final ApplicationContext applicationContext;

    static {
        // Initiate the application context only one-time
        System.out.println("just for test!!!");
        applicationContext = new AnnotationConfigApplicationContext(StepsConfiguration.class);
        System.out.println("just for test!!!");
    }

    /**
     * Determine beans from Spring context when initializing.
     */
    @Override
    public Object initialize(Class<?> aClass) throws Exception {
        String[] beanNames = applicationContext.getBeanNamesForType(aClass);
        if (beanNames.length == 0) {
            throw new NoSuchBeanDefinitionException(aClass.getName());
        }
        String s = beanNames[0];
        return aClass.cast(applicationContext.getBean(s));
    }
}