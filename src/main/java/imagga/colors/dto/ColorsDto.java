package imagga.colors.dto;


import lombok.Getter;

import java.util.List;

@Getter
public class ColorsDto {
    private List<ColorsInfo> background_colors;
    private List<ColorsInfo> foreground_colors;
    private List<ColorsInfo> image_colors;
}
