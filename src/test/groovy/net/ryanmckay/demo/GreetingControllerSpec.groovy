package net.ryanmckay.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerSpec extends Specification {

    @LocalServerPort
    private int port

    @Autowired
    private TestRestTemplate restTemplate

    def "no Param greeting should return default message"() {

        when:
        ResponseEntity<Greeting> responseGreeting = restTemplate
                .getForEntity("http://localhost:" + port + "/greeting", Greeting.class)

        then:
        responseGreeting.statusCode == HttpStatus.OK
        responseGreeting.body.content == "Hello, World!"
    }

    def "param Greeting Should Return Tailored Message"() {
        when:
        ResponseEntity<Greeting> responseGreeting = restTemplate.getForEntity("http://localhost:" + port + "/greeting?name={name}", Greeting.class, "Spring Community")

        then:
        responseGreeting.statusCode == HttpStatus.OK
        responseGreeting.body.content == "Hello, Spring Community!"
    }
}
