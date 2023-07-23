package cl.otakubook.otakubookapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MangaResponseDTO {
  private Long idManga;
  private String titulo;
}
