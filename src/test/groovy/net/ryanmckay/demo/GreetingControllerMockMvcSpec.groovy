package net.ryanmckay.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
class GreetingControllerMockMvcSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "no Param greeting should return default message"() {

        when:
        def resultActions = mockMvc.perform(get("/greeting")).andDo(print())

        then:
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.content').value("blah"))
    }

    def "param Greeting Should Return Tailored Message"() {

        when:
        def resultActions = this.mockMvc.perform(get("/greeting").param("name", "Spring Community")).andDo(print())

        then:
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.content').value("Hello, Spring Community!"))

    }
}
