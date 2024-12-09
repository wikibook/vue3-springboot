package kr.co.wikibook.gallery.item.dto;

import lombok.Builder;
import lombok.Getter;

@Getter // ①
@Builder // ②
public class ItemRead {

    private Integer id; // ③
    private String name; // ④
    private String imgPath; // ⑤
    private Integer price; // ⑥
    private Integer discountPer; // ⑦
}