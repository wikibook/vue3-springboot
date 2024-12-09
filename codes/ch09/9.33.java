package kr.co.wikibook.gallery.order.dto;

import kr.co.wikibook.gallery.item.dto.ItemRead;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter // ①
@Setter // ②
@Builder // ③
public class OrderRead {

    private Integer id; // ④
    private String name; // ⑤
    private String address; // ⑥
    private String payment; // ⑦
    private Long amount; // ⑧
    private LocalDateTime created; // ⑨
    private List<ItemRead> items; // ⑩
}