package imagga.colors;


import imagga.colors.dto.ColorsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ColorsAppl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzEwM2IwY2E3N2YzM2U3Yjo1YTYyYzVjOTg5OWJjZDY2ZWQ0ZWZmMzBjYmJkNjBmNA==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);

        URI url = builder.build().toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorsResponseDto> response = restTemplate.exchange(request, ColorsResponseDto.class);
        printColor(response.getBody().getResult().getColors().getBackground_colors());

    }

    private static void printColor(List<BackgroundColors> colors) {
        System.out.println("-------------------");
        System.out.printf("%-25s %-25s %-15s%n", "color name", "parent color name", "coverage percent");
        System.out.println("-------------------");
        for (BackgroundColors color : colors) {
            System.out.printf("%-25s %-25s %-15.2f%n",
                    color.getClosest_palette_color(),
                    color.getClosest_palette_color_parent(),
                    color.getPercent());
        }
    }
}
