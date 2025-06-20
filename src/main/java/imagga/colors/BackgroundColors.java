package imagga.colors;

import imagga.colors.dto.ColorInfo;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BackgroundColors implements ColorInfo {
    private String closest_palette_color;
    private String closest_palette_color_parent;
    private double percent;

}
