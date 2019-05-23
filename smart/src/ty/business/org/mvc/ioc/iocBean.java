package org.mvc.ioc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.smart.framework.ioc.annotation.Bean;

@Bean
public class iocBean {

    ObjectMapper objectMapper=new ObjectMapper();


}
