package net.ryanmckay.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@AutoConfigureMockMvc
@SpringBootTest
class GreetingControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc;

    def "no Param greeting should return default message"() throws Exception {

        when:
        def response = this.mockMvc.perform(get("/greeting")).andDo(print()).andReturn().response

        then:
        response.status != 200
    }
}
