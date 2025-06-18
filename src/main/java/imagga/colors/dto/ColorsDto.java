package imagga.colors.dto;

import imagga.colors.BackgroundColors;
import lombok.Getter;

import java.util.List;

@Getter
public class ColorsDto {
    private List<BackgroundColors> background_colors;
    private List<ForegroundColors> foreground_colors;
    private List<ImageColors> image_colors;
}
