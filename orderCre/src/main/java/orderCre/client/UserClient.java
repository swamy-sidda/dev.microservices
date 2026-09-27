package orderCre.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import orderCre.dto.UserResponseDto;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final RestTemplate restTemplate;

    public UserResponseDto getUserById(Long userId) {

        String url = "http://localhost:8080/users/" + userId;

        return restTemplate.getForObject(url, UserResponseDto.class);
    }
}